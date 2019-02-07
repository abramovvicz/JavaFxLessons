package Listings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.rgb;


public class Listing01_05 extends Application {

    public static void main(String[] args) {
        System.out.println("Uruchomiłem metodę main()");
        Application.launch(args);
        System.out.println("Wróciłem do metody main()");
    }

    @Override
    public void init() {
        System.out.println("Uruchomiłem metodę init()");
    }

    @Override
    public void start(Stage stage) {
        try {
//            System.out.println("Uruchomiłem metodę start()");
//            Label label = new Label("Witaj, świecie");
//            VBox root = new VBox();
//            Button stopButton = new Button("Żegnaj, świecie");
//            stopButton.setOnAction(e -> {
//                System.out.println("Kliknięto przycisk");
//                Platform.exit();
//
//            });
//            root.getChildren().addAll(label, stopButton);
//            Scene scene = new Scene(root, 600, 400);
//            stage.setScene(scene);
//            stage.show();


            Circle circle1 = new Circle(100, 100, 100);
            LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.REFLECT,
                    new Stop(0, rgb(215, 197, 43)), new Stop(1, rgb(179, 164, 35)
            ));
            circle1.setFill(gradient);

            Circle circle2 = new Circle(50, 80, 20);
            circle2.setFill(Color.BLACK);
            Circle circle3 = new Circle(150, 80, 20);
            circle3.setFill(Color.BLACK);
            Circle circle4 = new Circle(50, 80, 10);
            circle4.setFill(Color.WHITE);
            Circle circle5 = new Circle(150, 80, 10);
            circle5.setFill(Color.WHITE);
            Arc arc = new Arc(100, 150, 25, 25, 180, 180);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(10);
            arc.setStroke(Color.BLACK);
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setFill(null);
            Pane root = new Pane();
            root.getChildren().addAll(circle1, circle2, circle3, circle4, circle5, arc);
            Scene scene = new Scene(root, 400, 200);
            stage.setScene(scene);
            stage.setTitle("Scena");
            stage.show();
//

//            root.getChildren().add(arc);

//            KeyValue kv1 = new KeyValue(circle.radiusProperty(), 10);
//            KeyFrame kf1 = new KeyFrame(Duration.millis(0), kv1);
//            KeyValue kv2 = new KeyValue(circle.radiusProperty(), 80);
//            KeyFrame kf2 = new KeyFrame(Duration.millis(1500), kv2);
//            KeyValue kv3 = new KeyValue(circle.radiusProperty(), 10);
//            KeyFrame kf3 = new KeyFrame(Duration.millis(3000), kv3);
//            KeyValue kv4 = new KeyValue(circle.radiusProperty(), 0);
//            KeyFrame kf4 = new KeyFrame(Duration.millis(4500), kv4);
//            Timeline timeline = new Timeline(); // Tworzenie osi czasu
//            timeline.getKeyFrames().addAll(kf1, kf2, kf3, kf4); // Dodawanie klatek kluczowych do osi czasu
//            timeline.setCycleCount(4); // Liczba powtórzeń animacji
//            timeline.play(); // Uruchomienie animacji

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void stop() {
        System.out.println("Uruchomiłem metodę stop()");
    }

}
