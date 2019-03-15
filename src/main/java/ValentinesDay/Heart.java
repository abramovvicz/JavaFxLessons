package ValentinesDay;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static javafx.scene.paint.Color.RED;

public class Heart extends Application {

    private Timeline timeline;
    private AnimationTimer timer;
    private Integer i = 30;
    private Integer j = 300;
    private Integer k = -1;
    private boolean flag = false;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Group group = new Group();

        Stop[] stops = new Stop[]{new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        Circle circle1 = new Circle(120, 120, 100);
        circle1.setFill(RED);
        Circle circle2 = new Circle(220, 120, 100);
        circle2.setFill(RED);
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(20.0, 120.0, 320.0, 120.0, 170.0, 320.0);
        triangle.setFill(RED);

        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(37.0, 177.0, 220.0, 120.0, 170.0, 320.0);
        triangle2.setFill(RED);

        Polygon triangle3 = new Polygon();
        triangle3.getPoints().addAll(303.0, 177.0, 220.0, 120.0, 170.0, 320.0);
        triangle3.setFill(RED);


        /** strzałka*/
        Polygon triangle4 = new Polygon();
        triangle4.getPoints().addAll(370.0, 220.0, 390.0, 200.0, 390.0, 240.0);
        triangle4.setFill(Color.BLACK);

        Rectangle rectangle = new Rectangle(200, 10, Color.YELLOW);
        rectangle.setX(390);
        rectangle.setY(215);

        Blend blend = new Blend();

        //Preparing the to input object
        ColorInput topInput = new ColorInput(66, 215, 100, 10, Color.RED);

        //setting the top input to the blend object
        blend.setTopInput(topInput);

        //setting the blend mode
        blend.setMode(BlendMode.DIFFERENCE);

        //Applying the blend effect to circle
        rectangle.setEffect(blend);

//        Polygon diamond = new Polygon();
//        diamond.getPoints().addAll(57.0, 215.0, 67.0, 215.0, 47.0, 200.0, 37.0, 200.0);
//        diamond.setFill(Color.GREEN);

        /** strzałka end*/

        Group strzalka = new Group(triangle4, rectangle);

        QuadCurve quadCurve1 = new QuadCurve(32.0, 167.0, 70.0, 250.0, 170.0, 320.0);
        quadCurve1.setFill(RED);

        QuadCurve quadCurve2 = new QuadCurve(308.0, 167.0, 270.0, 250.0, 170.0, 320.0);
        quadCurve2.setFill(RED);

        group.getChildren().addAll(circle1, circle2, triangle, triangle2, triangle3, quadCurve1, quadCurve2);
        MotionBlur mb = new MotionBlur();
        mb.setRadius(2.0f);
        mb.setAngle(4.0f);
        group.setEffect(mb);

//        strzalka.getChildren().addAll(triangle4, rectangle);

//        Rotate rotate = new Rotate();
//        rotate.setAngle(30);
//        rotate.setPivotX(57.0);
//        rotate.setPivotY(215.0);
//        strzalka.getTransforms().addAll(rotate);
//
        Text text = new Text();
        Text text1 = new Text();


        Pane root = new Pane();
        root.getChildren().addAll(group, triangle4, rectangle, text, text1);
        Scene scene = new Scene(root, 340, 340);
        scene.getStylesheets().add(getClass().getResource("/fontstyle.css").toExternalForm());

        String str = "I LOVE";
        text.setStyle("#font-face");
        text.setFont(Font.font("VERDANA", FontWeight.BOLD, 40));
        text.setText(str);
        text.setX(150);
        text.setY(150);
        text.setFill(Color.WHITE);


        String str2 = "YOU";
        text1.setStyle("#font-face");
        text1.setFont(Font.font("VERDANA", FontWeight.BOLD, 70));
        text1.setText(str2);
        text1.setX(400);
        text1.setY(240);
        text1.setFill(Color.WHITE);

//        StackPane stack = new StackPane();


        primaryStage.setScene(scene);
        primaryStage.setTitle("For My Love <3 N :)");
        primaryStage.show();


        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Random random = new Random();
                int r = random.nextInt(255) + 1;
                int g = random.nextInt(255) + 1;
                int b = random.nextInt(255) + 1;
                int r1 = random.nextInt(255) + 1;
                int g1 = random.nextInt(255) + 1;
                int b1 = random.nextInt(255) + 1;
                text1.setFill(Color.rgb(r, g, b));
                text.setFill(Color.rgb(r1, g1, b1));
                rectangle.setFill(Color.rgb(r, g1, b));
                flag = true;

            }
        };
//Adding event Filter
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);


        //create a timeline for moving the circle
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

//You can add a specific action when each frame is started.
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setX(i);
                text1.setX(j);
//                System.out.print((-i + " "));
//                System.out.print(text.getX()+", ");
                if (k == 0) {
                    i--;
                    j++;
                } else if (k == -1) {
                    i++;
                    j--;
                }

                if (flag) {
                    rectangle.setX(i);
                    triangle4.setLayoutX(i);
                }
            }

        };

        //create a keyValue with factory: scaling the circle 2times
        KeyValue keyValueX = new KeyValue(group.scaleXProperty(), 1.2);
        KeyValue keyValueY = new KeyValue(group.scaleYProperty(), 1.2);

        //create a keyFrame, the keyValue is reached at time 3s
        Duration duration = Duration.millis(3000);
        //one can add a specific action when the keyframe is reached
            EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
//                group.setTranslateX(java.lang.Math.random() * 20 - 10);
                //reset counter
                System.out.println("reset");
                if (k == 0) {
                    k = -1;
                } else if (k == -1) {
                    k = 0;
                }
            }

        };

        KeyFrame keyFrame = new KeyFrame(duration, onFinished, keyValueX, keyValueY);

        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
        timer.start();


    }
}
