package models;

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Sphere1  {

    public Group start() {
        
        Group root = new Group();
           
        Random random =  new Random();
        Sphere sphere1 = new Sphere(20);

        sphere1 = new Sphere(20);
        
        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));
        root.getChildren().add(sphere1);
        
    	
        Path path = new Path();
       
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 100));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 100));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(650, 300));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(650, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(195, 450));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(195, 450));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(10));
        pathTransition.setPath(path);
        pathTransition.setNode(sphere1);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pathTransition.play();
        
        return root;
    }
}
