package train.tasks.Chat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {

   private ServerSocketChannel serverChannel;
   private int port = 5600;
   private boolean isRunning = true;
   private List<Thread> clientThreads = Collections.synchronizedList(new ArrayList<>());
   protected static final Map<String,DataOutputStream> clientNames = new HashMap<String,DataOutputStream>(); 

   private Server() {
      try {
    	  serverChannel = ServerSocketChannel.open();
    	  serverChannel.configureBlocking(true);
    	  serverChannel.socket().bind(new InetSocketAddress(port));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      Server server = new Server();
      Thread serverThread = new Thread(server::start); serverThread.start();
      new Thread(new CommandHandler(server, serverThread)).start();
   }

   protected void stopServer() {
	    isRunning = false;
	    try {
	        if (serverChannel != null) {
	            serverChannel.close();
	            for (Thread clientThread : clientThreads) {
	                clientThread.interrupt();
	            }
	            clientThreads.clear();
	        }
	    } catch (IOException e) {
	        System.out.println("Error closing the server socket channel: " + e.getMessage());
	    }
	}
    
   protected static void broadcast(String line) throws IOException {
	   for(DataOutputStream dos : clientNames.values()) {
		   dos.writeUTF(line);
	   }
   }
   
   private void start() {
	    System.out.println("Waiting for client ...");
	    while (isRunning) {
	        try {
	            SocketChannel clientChannel = serverChannel.accept();
	            if (clientChannel != null) {
	            	Socket socket = clientChannel.socket();
	            	System.out.println("Client accepted: " + socket);
	            	Thread clientThread = new Thread(new ClientHandler(socket));
	            	clientThreads.add(clientThread);
	            	clientThread.start();
	            } else {
	            	Thread.sleep(100);
	            }
	        } catch (InterruptedException ie) {
	            Thread.currentThread().interrupt();
	        } catch (IOException ioe) {
	            if (!isRunning) {
	                System.out.println("Server has stopped accepting new connections");
	            } else {
	                System.out.println("Error accepting client connection: " + ioe.getMessage());
	            }
	        }
	    }
	}
}

class CommandHandler implements Runnable {
	private Server server;
	private Thread serverThread;
	private boolean running = true;

    public CommandHandler(Server server,Thread serverThread) {
        this.server = server;
        this.serverThread = serverThread;
    }
    
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        	System.out.println("Ready to listen commands");
            String command;
            while (running) {
                command = reader.readLine();
                switch(command) {
                case "stop":
                	Server.broadcast("Server is shutting down by admin");
                	server.stopServer();
                    System.out.println("Server stopped by admin");
                    if (serverThread != null) {
                        serverThread.interrupt(); // Interrupt the main server thread
                    }
                    running = false;
                    break;
                default:
                	System.out.println("Unknown command");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler implements Runnable {
   private Socket socket;

   public ClientHandler(Socket socket) {
      this.socket = socket;
   }
   
   private String getClientName(DataOutputStream dos) {
	    for (Map.Entry<String, DataOutputStream> entry : Server.clientNames.entrySet()) {
	        if (entry.getValue().equals(dos)) {
	            return entry.getKey();
	        }
	    }
	    return "Unknown client";
	}

   private boolean authenticator(DataInputStream dis, DataOutputStream dos) throws IOException {
	    try {
	        String login;
	        String password;
	        
	        dos.writeUTF("Enter login: ");
	        dos.flush();
	        login = dis.readUTF();
	        
	        dos.writeUTF("Enter password: ");
	        dos.flush();
	        password = dis.readUTF();
	        
	        if (login.equals("login") && password.equals("password")) {
	        	dos.writeUTF("authentication successful");
		        dos.flush();
		        dos.writeUTF("Enter your name: ");
		        dos.flush();
		        Server.clientNames.put(dis.readUTF(), dos);
	            return true;
	        }
	    } catch (IOException e) {
	        System.out.println("ClientHandler error during authentication: " + e.getMessage());
	        throw e;  
	    }
	    return false;
	}
   
   @Override
   public void run() {
	   try {
           DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
           DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
           
           int attempts = 0;
           final int MAX_ATTEMPTS = 3;
           
           try {
           while(attempts <= MAX_ATTEMPTS) {
        	   if(authenticator(dis,dos)) {
        		   break;
        	   }else {
        		   System.out.println("Client " + socket + " invalid username or password");
        		   dos.writeUTF("Invalid username or password");
        		   attempts++;
        		   if(attempts >= MAX_ATTEMPTS) {
        			   	System.out.println("Client " + socket + " too many failed attempts. Disconnecting.");
        	            dos.writeUTF("Too many failed attempts. Disconnecting.");
        	            socket.close();
        	            Thread.currentThread().interrupt();  
        	            return;
        	        }
        	   }
           }
           } catch (IOException e) {
        	    System.out.println("ClientHandler error during repeated authentication: " + e.getMessage());
        	    return;
           }
           
           String line;
           boolean done = false;

           while (!done && !Thread.currentThread().isInterrupted()) {
        	    try {
        	        line = dis.readUTF();
        	        String formattedMessage = getClientName(dos) + ": " + line;
        	        Server.broadcast(formattedMessage);
        	        System.out.println(formattedMessage);
        	    } catch (IOException e) {
        	        System.out.println("Error reading message from: " + getClientName(dos) + " " + e.getMessage());
        	        done = true;
        	    }
        	}
           
           Server.clientNames.clear();
           dis.close();
           dos.close();
       } catch (IOException e) {
           System.out.println("ClientHandler error: " + e.getMessage());
       }
   }
}