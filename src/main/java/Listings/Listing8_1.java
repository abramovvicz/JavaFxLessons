package Listings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Listing8_1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Circle circle1 = new Circle(100, 100, 50);
            circle1.setFill(Color.BLUE);
            Circle circle2 = new Circle(150, 100, 30);
            circle2.setFill(Color.ORANGE);

            Pane root = new Pane();
            root.getChildren().addAll(circle1, circle2);
            Scene scene = new Scene(root, 400, 200);
            stage.setScene(scene);
            stage.setTitle("Scena");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}