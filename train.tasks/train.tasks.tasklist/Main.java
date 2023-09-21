package train.tasks.tasklist;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner mainsc = new Scanner(System.in);
		Application.printList();
		
		while (true) {
	           String commandKey = mainsc.nextLine();
	           if(commandKey.equals("Exit")) {
	        	   break;
	           }
	           Commands.mainExecute(commandKey);
	       }
		
		mainsc.close();
	}
}