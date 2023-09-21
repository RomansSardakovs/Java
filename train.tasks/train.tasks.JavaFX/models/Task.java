package models;

import java.util.ArrayList;
import java.util.LinkedList;
import control.MainViewController;
import javafx.event.ActionEvent;

public class Task  {
	
	private MainViewController controller;
    
    public Task(MainViewController controller) {
        this.controller = controller;
    }
	
    public static ArrayList<LinkedList<Character>> listOfanswers = new ArrayList<>();
    public static ArrayList<String> TaskText = new ArrayList<>();
    public static ArrayList<String> TextA = new ArrayList<>();
    public static ArrayList<String> TextB = new ArrayList<>();
    public static ArrayList<String> TextC = new ArrayList<>();
    public static ArrayList<String> TextD = new ArrayList<>();
    public static int TaskCounter = 0;
    
	    public void taskBtnAction(ActionEvent event) {
	    	controller.stackPane.getChildren().clear();
	    	controller.disableRightLabels();
	    	controller.disableModelButtons();
	    	controller.stackPane.getChildren().add(controller.taskPane);
	    }
	   
	    public void readyAction(ActionEvent event) {
	    	String TaskTextField = controller.taskText.getText();
	    	if(TaskTextField.isEmpty()) {
	    		controller.message.setVisible(true);
	    		controller.message.setText("Definējiet uzdevuma noteikumu");
	    		return;
	    	}
	    	String FirstTask = controller.firstTask.getText();
	    	String SecondTask = controller.secondTask.getText();
	    	String ThirdTask = controller.thirdTask.getText();
	    	String FourthTask = controller.fourthTask.getText();
	    	if(FirstTask.isEmpty() || SecondTask.isEmpty() || ThirdTask.isEmpty() || FourthTask.isEmpty()) {
	    		controller.message.setVisible(true);
	    		controller.message.setText("Ne visas atbildes ir definētas");
	    		return;
	    	}
	    	if(!controller.checkA.isSelected() && !controller.checkB.isSelected() && !controller.checkC.isSelected() && !controller.checkD.isSelected()) {
	    		controller.message.setVisible(true);
	    		controller.message.setText("Definējiet kaut vienu pareizo atbildi");
	    		return;
	    	}
	    	LinkedList<Character> answers = new LinkedList<>();
	    	if(controller.checkA.isSelected()) {
	    		answers.add('A');
	    	}
	    	if(controller.checkB.isSelected()) {
	    		answers.add('B');
	    	}
	    	if(controller.checkC.isSelected()) {
	    		answers.add('C');
	    	}
	    	if(controller.checkD.isSelected()) {
	    		answers.add('D');
	    	}
	    	listOfanswers.add(answers);
	    	TaskText.add(controller.taskText.getText());
	    	TextA.add(controller.firstTask.getText());
	    	TextB.add(controller.secondTask.getText());
	    	TextC.add(controller.thirdTask.getText());
	    	TextD.add(controller.fourthTask.getText());
	    	TaskCounter++;
	    	controller.startTask.setDisable(false);
	    	controller.newQuestion.setDisable(false);
	    	controller.ready.setDisable(true);
	    	controller.message.setVisible(false);
	    }
	  
	    public void newQuestionAction(ActionEvent event) {
	    	controller.resetTask();
	    	controller.message2.setText("Jautājumu skaits: " + TaskCounter);
	    	controller.message2.setVisible(true);
	    }
}
