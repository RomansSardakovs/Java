package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
          Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
            primaryStage.setTitle("Romāns Šardakovs");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
    
    public static void main(String[] args) {
    	 long startTime = System.nanoTime();
         launch(args);
         long endTime = System.nanoTime();
         double executionTimeInSeconds = (endTime - startTime) / 1000000000.0;
         System.out.println("Execution time: " + executionTimeInSeconds + " seconds");
    }
    
}
