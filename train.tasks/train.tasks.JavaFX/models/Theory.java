package models;

import control.MainViewController;
import javafx.event.ActionEvent;

public class Theory {
	
	private MainViewController controller;
    
    public Theory(MainViewController controller) {
        this.controller = controller;
    }
	
	public void theoryBtnAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.disableRightLabels();
		controller.disableModelButtons();
		controller.stackPane.getChildren().add(controller.theoryPane1);
    }
	
	public void backFirstLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane1);
    }
    
	public void backSecondLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane2);
    }
    
	public void backThirdLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane3);
    }
    
	public void backFourthLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane4);
    }
    
	public void toSecondLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane2);
    }
    
	public void toThirdLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane3);
    }
    
	public void toFourthLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane4);
    }
    
	public void toFifthLppAction(ActionEvent event) {
		controller.stackPane.getChildren().clear();
		controller.stackPane.getChildren().add(controller.theoryPane5);
    }
}
