package train.tasks.Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    private static Socket socket;
    private static DataOutputStream dos;
    private static DataInputStream dis;

    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            socket = new Socket(host.getHostName(), 5600);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());

            Thread serverListenerThread = new Thread(new ServerListener());
            serverListenerThread.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while (!line.equals("bye")) {
                try {
                    line = reader.readLine();
                    dos.writeUTF(line);
                    dos.flush();
                } catch (IOException ioe) {
                    System.out.println("Sending error: " + ioe.getMessage());
                }
            }
            serverListenerThread.interrupt();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ServerListener implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    if (socket.getInputStream().available() > 0) {
                        String response = dis.readUTF();
                        System.out.println(response);
                    }
                }
            } catch (IOException e) {
                System.out.println("Listener error: " + e.getMessage());
            }
        }
    }
}