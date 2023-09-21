package models;

import control.MainViewController;
import javafx.event.ActionEvent;
import javafx.scene.Group;

public class Model {
    
	private MainViewController controller;
    
    public Model(MainViewController controller) {
        this.controller = controller;
    }
    
    public void toModelAction(ActionEvent event) {
    	controller.toModel();
    	controller.enableModelButtons();
    	controller.resetArrows();
    }
    
    public void circle1BtnAction(ActionEvent event) {
    	controller.CoordinatesPane.getChildren().clear();
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.circlePane);
    	controller.resetArrows();
        Sphere1 circle = new Sphere1();
        controller.CoordinatesPane.setStyle("-fx-background-color:transparent;");
        controller.CoordinatesPane.getChildren().add(circle.start());
        controller.rightLabel1.setVisible(true);
        controller.rightLabel1.setText("Brīvības Pakāpe: i = 3");
        controller.rightLabel2.setVisible(true);
        controller.rightLabel2.setText("Vien Atomu");
    }
    
    public void circle2BtnAction(ActionEvent event) {
    	controller.CoordinatesPane.getChildren().clear();
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.circlePane);
    	controller.resetArrows();
    	controller.ArrowSphere2();
        Sphere2 circle = new Sphere2();
        Group thisGroup = circle.start();       
        controller.CoordinatesPane.setStyle("-fx-background-color:transparent;");
        controller.CoordinatesPane.getChildren().add(thisGroup);
        controller.rightLabel1.setVisible(true);
        controller.rightLabel1.setText("Brīvības Pakāpe: i = 5");
        controller.rightLabel2.setVisible(true);
        controller.rightLabel2.setText("Div Atomu");
    }
    
    public void circle3BtnAction(ActionEvent event) {
    	controller.CoordinatesPane.getChildren().clear();
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.circlePane);
    	controller.resetArrows();
    	controller.ArrowSphere3();
        Sphere3 circle = new Sphere3();
        Group thisGroup = circle.start();       
        controller.CoordinatesPane.setStyle("-fx-background-color:transparent;");
        controller.CoordinatesPane.getChildren().add(thisGroup);
        controller.rightLabel1.setVisible(true);
        controller.rightLabel1.setText("Brīvības Pakāpe: i = 6");
        controller.rightLabel2.setVisible(true);
        controller.rightLabel2.setText("Trīs Atomu");
    }
    
    public void launchBtnAction(ActionEvent event) {
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.circlePane);
    	controller.stackPane.getChildren().add(controller.CoordinatesPane);
    }
    
    public void stopBtnAction(ActionEvent event) {
    	controller.stackPane.getChildren().clear();
    	controller.stackPane.getChildren().add(controller.circlePane);
    }
}
