package models;

import control.MainViewController;
import javafx.event.ActionEvent;

public class Answer {

	private MainViewController controller;
    
    public Answer(MainViewController controller) {
        this.controller = controller;
    }
	
	private int ThisCounter = 0;
	
    public void startTaskAction(ActionEvent event) {
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.answerPane);
    	controller.startAnswerAction();
    	controller.taskTextAnswer.setText(Task.TaskText.get(ThisCounter));
    	controller.firstTaskAnswer.setText(Task.TextA.get(ThisCounter));
    	controller.secondTaskAnswer.setText(Task.TextB.get(ThisCounter));
    	controller.thirdTaskAnswer.setText(Task.TextC.get(ThisCounter));
    	controller.fourthTaskAnswer.setText(Task.TextD.get(ThisCounter));
    }

    public void checkAnswerAction(ActionEvent event) { 
    	if(controller.checkAAnswer.isSelected()) {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('A') != -1) {
    			controller.AGreen.setVisible(true);
    		}
    		if(Task.listOfanswers.get(ThisCounter).indexOf('A') == -1) {
    			controller.ARed.setVisible(true);
    		}
    	} else {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('A') != -1) {
    			controller.ARed.setVisible(true);
    		}
    	}
    	
    	if(controller.checkBAnswer.isSelected()) {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('B') != -1) {
    			controller.BGreen.setVisible(true);
    		}
    		if(Task.listOfanswers.get(ThisCounter).indexOf('B') == -1) {
    			controller.BRed.setVisible(true);
    		}
    	} else {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('B') != -1) {
    			controller.BRed.setVisible(true);
    		}
    	}
    	
    	if(controller.checkCAnswer.isSelected()) {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('C') != -1) {
    			controller.CGreen.setVisible(true);
    		}
    		if(Task.listOfanswers.get(ThisCounter).indexOf('C') == -1) {
    			controller.CRed.setVisible(true);
    		}
    	} else {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('C') != -1) {
    			controller.CRed.setVisible(true);
    		}
    	}
    	
    	if(controller.checkDAnswer.isSelected()) {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('D') != -1) {
    			controller.DGreen.setVisible(true);
    		}
    		if(Task.listOfanswers.get(ThisCounter).indexOf('D') == -1) {
    			controller.DRed.setVisible(true);
    		}
    	} else {
    		if(Task.listOfanswers.get(ThisCounter).indexOf('D') != -1) {
    			controller.DRed.setVisible(true);
    		}
    	}
    	
    	if(ThisCounter == Task.TaskCounter-1) {
    		controller.stopAnswer.setVisible(true);
    		controller.nextQuestion.setDisable(true);
    		controller.checkAnswer.setDisable(true);
    		return;
    	}
    	controller.nextQuestion.setDisable(false);
    	controller.checkAnswer.setDisable(true);
    }
    
    public void nextQuestionAction(ActionEvent event) {
    	controller.nextQuestion.setDisable(true);
    	controller.checkAnswer.setDisable(false);
    	controller.unCheck();
    	controller.resetMarksAnswers();
    	ThisCounter++;
    	controller.taskTextAnswer.setText(Task.TaskText.get(ThisCounter));
    	controller.firstTaskAnswer.setText(Task.TextA.get(ThisCounter));
    	controller.secondTaskAnswer.setText(Task.TextB.get(ThisCounter));
    	controller.thirdTaskAnswer.setText(Task.TextC.get(ThisCounter));
    	controller.fourthTaskAnswer.setText(Task.TextD.get(ThisCounter));
    }
        
    public void stopAnswerAction(ActionEvent event) { 
    	controller.toModel();
    	Task.TaskCounter = 0;
    	ThisCounter = 0;
    	Task.listOfanswers.clear();
    	Task.TaskText.clear();
    	Task.TextA.clear();
    	Task.TextB.clear();
    	Task.TextC.clear();
    	Task.TextD.clear();
    	controller.message2.setVisible(false);
    	controller.resetTask();
    	controller.resetAnswer();
    	controller.endAnswerAction();
    }
}
