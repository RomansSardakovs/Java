package models;

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class Sphere3 {

    public Group start() {
    	
        Group root = new Group();

        Group group = new Group();
        Random random = new Random();

        Sphere sphere1 = new Sphere(20);
        sphere1.setTranslateX(350);
        sphere1.setTranslateY(250);
        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));

        Sphere sphere2 = new Sphere(20);
        sphere2.setTranslateX(400);
        sphere2.setTranslateY(350);
        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere2.setMaterial(new PhongMaterial(randomColor));

        Sphere sphere3 = new Sphere(20);
        sphere3.setTranslateX(300);
        sphere3.setTranslateY(350);
        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere3.setMaterial(new PhongMaterial(randomColor));

        Line line1 = new Line(sphere1.getTranslateX(), sphere1.getTranslateY(), sphere2.getTranslateX(), sphere2.getTranslateY());
        line1.setStroke(Color.WHITESMOKE);

        Line line2 = new Line(sphere2.getTranslateX(), sphere2.getTranslateY(), sphere3.getTranslateX(), sphere3.getTranslateY());
        line2.setStroke(Color.WHITESMOKE);

        Line line3 = new Line(sphere3.getTranslateX(), sphere3.getTranslateY(), sphere1.getTranslateX(), sphere1.getTranslateY());
        line3.setStroke(Color.WHITESMOKE);

        
        double line1DiffX = line1.getStartX() - line1.getEndX();
        double line1DiffY = line1.getStartY() - line1.getEndY();
        double line2DiffX = line2.getStartX() - line2.getEndX();
        double line2DiffY = line2.getStartY() - line2.getEndY();
        double line1CoordinateDiff = (Math.pow(line1.getStartX(), 2) - Math.pow(line1.getEndX(), 2)) + (Math.pow(line1.getStartY(), 2) - Math.pow(line1.getEndY(), 2));
        double line2CoordinateDiff = (Math.pow(line2.getStartX(), 2) - Math.pow(line2.getEndX(), 2)) + (Math.pow(line2.getStartY(), 2) - Math.pow(line2.getEndY(), 2));

        double centerX = (line2DiffY * line1CoordinateDiff - line1DiffY * line2CoordinateDiff) / (2 * line1DiffX * line2DiffY - 2 * line1DiffY * line2DiffX);
        double centerY = (line1DiffX * line2CoordinateDiff - line2DiffX * line1CoordinateDiff) / (2 * line1DiffX * line2DiffY - 2 * line1DiffY * line2DiffX);
        double radius = Math.sqrt(Math.pow(centerX - sphere1.getTranslateX(), 2) + Math.pow(centerY - sphere1.getTranslateY(), 2));

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.TRANSPARENT);

        group.getChildren().addAll(sphere1, sphere2, sphere3, line1, line2, line3, circle);
        root.getChildren().add(group);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(10), group);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        group.setRotate(45);

        
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
        pathTransition.setNode(group);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pathTransition.play();

        return root;
    }
}
