package models;

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Sphere2  {

    public Group start() {
    	
        Group root = new Group();
        
        Group group = new Group();
        Random random =  new Random();
        
        Sphere sphere1 = new Sphere(20); 
        sphere1.setTranslateX(350);
        sphere1.setTranslateY(250);

        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));
        
        Sphere sphere2 = new Sphere(20);
        sphere2.setTranslateX(450);
        sphere2.setTranslateY(350);

        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere2.setMaterial(new PhongMaterial(randomColor));
        
        Line innerLine  = new Line(sphere1.getTranslateX(),sphere1.getTranslateY(),sphere2.getTranslateX(),sphere2.getTranslateY());
        innerLine.setStroke(Color.WHITESMOKE);
        
        group.getChildren().addAll(sphere1,sphere2,innerLine);
        root.getChildren().add(group);
        
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
        
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(8.5), group);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(12));
        pathTransition.setPath(path);
        pathTransition.setNode(group);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        
        pathTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            Duration currentTime = newValue;
            double progress = currentTime.toMillis() / pathTransition.getDuration().toMillis();
            boolean movingOnX = progress >= 0.33 && progress <= 0.60;

            if (movingOnX) {
                rotateTransition.pause();
            } else {
                rotateTransition.play();
            }
        });
        
        return root;
    }
}
