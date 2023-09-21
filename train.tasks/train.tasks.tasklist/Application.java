package train.tasks.tasklist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	private static final LocalDate curDate = LocalDate.now();
	private static Scanner sc = new Scanner(System.in);
	
	protected static final class Activity{
		
		private String name;
		private String date;
		private String timeLeft;
		private String description;
		
		private Activity(String name, String date, String timeLeft, String description){
			this.name = name;
			this.date = date;
			this.timeLeft = timeLeft;
			this.description = description;
		}

	}
	
	private static final Map<String,Activity> activities = new HashMap<String,Activity>(); 
	
	private static Activity getActivity(String name) {
		return activities.get(name);
	}
	
	private static void printActivity(Activity thisActivity) {
		System.out.println();
		System.out.printf("%-20s", "Name: " + thisActivity.name);
		System.out.printf("%-20s", "Date: " + thisActivity.date);
		System.out.printf("%-20s", "Time left: " + thisActivity.timeLeft);
		System.out.println();
		for(int i = 0;i<60;i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("Describtion: ");
		System.out.println(thisActivity.description);
		for(int i=1;i<3;i++) {
			System.out.println();
		}
		System.out.println("Commands: ");
		System.out.println("Name [name] - change name");
		System.out.println("Date [date] - change date");
		System.out.println("Description [describtion] - change description");
		System.out.println("Back - exit editing");
		System.out.println();
	}
	
	public static void printList() {
		System.out.println();
		System.out.printf("%-15s","Name");
		System.out.printf("%-15s","Date");
		System.out.printf("%-15s","Time Left");
		System.out.println();
		for(int i = 0;i<45;i++) {
			System.out.print("-");
		}
		System.out.println();
		if(!activities.isEmpty()) {
			for (Activity var : activities.values()) {
			    System.out.printf("%-15s", var.name);
			    System.out.printf("%-15s", var.date);
			    System.out.printf("%-15s", var.timeLeft);
			    System.out.println();
			}
		}
		for(int i=1;i<=3;i++) {
			System.out.println();
		}
		System.out.println("Commands: ");
		System.out.println("Add [name] - add activity");
		System.out.println("Delete [name] - delete activity");
		System.out.println("Edit [name] - edit activity");
		System.out.println("Refresh - refresh activity list");
		System.out.println("Exit - stop programm");
		System.out.println();
	}
	
	public static void addActivity(String name) {
		if (activities.containsKey(name)) {
	        System.out.println("Error: Name already exists");
	        printList();
	        return;
	    }
		curDate.format(formatter);
		System.out.print("Enter accomplished date[dd.MM.yyyy]: ");
		String thisDate = sc.nextLine();
		System.out.print("Describtion: ");
		String thisdescribtion = sc.nextLine();
		
		LocalDate localThisDate = LocalDate.parse(thisDate, formatter);
		long daysBetween = ChronoUnit.DAYS.between(curDate, localThisDate);
		String thisTimeLeft = String.valueOf(daysBetween) + " days";
		
		Activity thisActivity = new Activity(name,thisDate,thisTimeLeft,thisdescribtion);
		
		activities.put(name, thisActivity);
		printList();
	}
		
	public static void editActivity(String name) {
		Activity thisActivity = getActivity(name);
		if(thisActivity == null) {
			System.out.println("No activity found");
			printList();
			return;
		}
		printActivity(thisActivity);
		while (true) {
	           String commandKey = sc.nextLine();
	           if(commandKey.equals("Back")) {
	        	   printList();
	        	   break;
	           }
	           Commands.applicationExecute(thisActivity,commandKey);
	       }
	}
	
	public static void changeName(Activity thisActivity,String name) {
		if (activities.containsKey(name)) {
	        System.out.println("Error: Name already exists");
	        printList();
	        return;
	    }
		activities.remove(thisActivity.name); 
		thisActivity.name = name;
		activities.put(name, thisActivity); 
		printActivity(thisActivity);
	}
	
	public static void changeDate(Activity thisActivity,String date) {
		LocalDate localThisDate = LocalDate.parse(date, formatter);
	    long daysBetween = ChronoUnit.DAYS.between(curDate, localThisDate);
	    String thisTimeLeft = daysBetween + " days";
	    thisActivity.date = date;
	    thisActivity.timeLeft = thisTimeLeft;
	    printActivity(thisActivity);
	}
	
	public static void changeDescription(Activity thisActivity, String description) {
	    thisActivity.description = description;
	    printActivity(thisActivity);
	}
	
	public static void deleteActivity(String name) {
		Activity thisActivity = getActivity(name);
		if(thisActivity == null) {
			System.out.println("No activity found");
			printList();
			return;
		}
		activities.remove(name);
		printList();
	}
	
}
