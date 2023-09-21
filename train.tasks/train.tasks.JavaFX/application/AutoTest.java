package application;
import control.MainViewController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
public class AutoTest {
	private MainViewController controller;
    public AutoTest(MainViewController controller) {
        this.controller = controller;
    }
	public Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.ToModel.fire();
                	controller.circle1.fire();
                	controller.launch.fire();
                }
            }),
            new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.circle2.fire();
                	controller.launch.fire();
                }
            }),
            new KeyFrame(Duration.seconds(20), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.circle3.fire();
                	controller.launch.fire();
                }
            }),
            new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.theoryBtn.fire();
                }
            }),
            new KeyFrame(Duration.seconds(32), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.toSecondLpp.fire();
                }
            }),
            new KeyFrame(Duration.seconds(34), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.toThirdLpp.fire();
                }
            }),
            new KeyFrame(Duration.seconds(36), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.toFourthLpp.fire();
                }
            }),
            new KeyFrame(Duration.seconds(38), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.toFifthLpp.fire();
                }
            }),
            new KeyFrame(Duration.seconds(40), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.taskBtn.fire();
                	controller.taskText.setText("test");
                	controller.firstTask.setText("test");
                	controller.secondTask.setText("test");
                	controller.thirdTask.setText("test");
                	controller.fourthTask.setText("test");
                	controller.checkA.setSelected(true);
                	controller.checkB.setSelected(true);
                }
            }),
            new KeyFrame(Duration.seconds(42), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.ready.fire();
                	controller.startTask.fire();
                }
            }),
            new KeyFrame(Duration.seconds(44), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.checkAAnswer.setSelected(true);
                	controller.checkCAnswer.setSelected(true);
                	controller.checkAnswer.fire();
                }
            }),
            new KeyFrame(Duration.seconds(46), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.stopAnswer.fire();
                }
            }),
            new KeyFrame(Duration.seconds(48), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                	controller.exit.fire();
                }
            })
        );
}
