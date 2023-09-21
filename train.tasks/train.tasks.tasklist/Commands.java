package train.tasks.tasklist;

import java.util.HashMap;
import java.util.Map;
import train.tasks.tasklist.Application.Activity;

interface MainCommand{
	void execute(String name);
}

interface ApplicationCommand{
	void execute(Activity thisActivity,String name);
}

public final class Commands {

	private Commands() {
	       // Private constructor to prevent creating instance of Commands class
	   }
	
	private static final Map<String, MainCommand> mainCommands = new HashMap<>();
	private static final Map<String, ApplicationCommand> applicationCommands = new HashMap<>();
	
	private static String cmdArguments;
	private static String[] cmdSplit;
	
	static {
		mainCommands.put("Add", new Add());
		mainCommands.put("Edit", new Edit());
		mainCommands.put("Delete", new Delete());
		applicationCommands.put("Name", new ChangeName());
		applicationCommands.put("Date", new ChangeDate());
		applicationCommands.put("Description", new ChangeDescription());
	}
	
	private static final void generateComands(String cmdKey) {
		cmdArguments = cmdKey;
		cmdSplit = cmdKey.split(" ",2);
		cmdArguments = cmdArguments.replaceAll(cmdSplit[0], "");
		cmdArguments = cmdArguments.replaceFirst("^\\s+", "");
	}
	
	public static void mainExecute(String cmdKey) {
		generateComands(cmdKey);
		MainCommand command = mainCommands.get(cmdSplit[0].trim());
	        if (command != null) {
	            command.execute(cmdArguments);
	        } else {
	            System.out.println("Unknown command: " + cmdKey);
	        }
	    }
	
	public static void applicationExecute(Activity thisActivity,String cmdKey) {
		generateComands(cmdKey);
		ApplicationCommand command = applicationCommands.get(cmdSplit[0].trim());
	        if (command != null) {
	            command.execute(thisActivity,cmdArguments);
	        } else {
	            System.out.println("Unknown command: " + cmdKey);
	        }
	    }
	
	private static final class Add implements MainCommand {
	    @Override
	    public void execute(String name) {
	        Application.addActivity(name);
	    }
	}
	
	private static final class Edit implements MainCommand {
        @Override
        public void execute(String name) {
        	Application.editActivity(name);
        }
    }

	private static final class Delete implements MainCommand {
        @Override
        public void execute(String name) {
        	Application.deleteActivity(name);
        }
    }
	
	private static final class ChangeName implements ApplicationCommand {
        @Override
        public void execute(Activity thisActivity,String name) {
        	Application.changeName(thisActivity, name);
        }
    }
	
	private static final class ChangeDate implements ApplicationCommand {
        @Override
        public void execute(Activity thisActivity,String date) {
        	Application.changeDate(thisActivity, date);
        }
    }
	
	private static final class ChangeDescription implements ApplicationCommand {
        @Override
        public void execute(Activity thisActivity,String description) {
        	Application.changeDescription(thisActivity, description);
        }
    }

}

