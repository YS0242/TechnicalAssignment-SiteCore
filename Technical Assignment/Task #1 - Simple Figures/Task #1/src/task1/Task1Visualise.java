package task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;

public class Task1Visualise extends Application {

    private Pane canvas, shapesPane;
    private Aggregation aggregation;

    @Override
    public void start(Stage primaryStage) {
    	shapesPane = new Pane();
        canvas = new Pane();
        canvas.getChildren().add(shapesPane);
        Scene scene = new Scene(canvas, 800, 800);

        // Creating sample figures and adding them to the canvas
        //        Point point = new Point(Math.random() * 500, Math.random() * 500);
        //        Line line = new Line(new Point(Math.random() * 300, Math.random() * 300), new Point(Math.random() * 500, Math.random() * 500));
        //        CircleShape circle = new CircleShape(new Point(Math.random() * 500, Math.random() * 500), 50);
        
        int pointNum = (int) (Math.random() * 5) + 1; // Max num of geometries can be modified
        int lineNum = (int) (Math.random() * 5) + 1;
        int circleNum = (int) (Math.random() * 5) + 1;
        
        aggregation = new Aggregation();
        
        // Save the initial state for reset (so that reset button can be used again and again
        List<ShapeInterface> initialState = new ArrayList<>();
        
        // Add geometries to aggregation
        for (int i = 0; i < pointNum; i++) {
            Point randomPoint = new Point(Math.random() * 500, Math.random() * 500);
            initialState.add(randomPoint.clone());
            aggregation.addFigure(randomPoint);
        }

        for (int j = 0; j < lineNum; j++) {
            Line randomLine = new Line(new Point(Math.random() * 300, Math.random() * 300), new Point(Math.random() * 500, Math.random() * 500));
            initialState.add(randomLine.clone());
            aggregation.addFigure(randomLine);
        }

        for (int k = 0; k < circleNum; k++) {
            CircleShape randomCircle = new CircleShape(new Point(Math.random() * 500, Math.random() * 500), 50);
            initialState.add(randomCircle.clone());
            aggregation.addFigure(randomCircle);
        }
        
        aggregation.saveInitialState();
        
        
//        aggregation.addFigure(line);
//        aggregation.addFigure(circle);
        
     
        
        
//        initialState.add(new Point(point.getX(), point.getY()));
//        initialState.add(new Line(new Point(line.getStart().getX(), line.getStart().getY()),
//                                  new Point(line.getEnd().getX(), line.getEnd().getY())));
//        initialState.add(new CircleShape(new Point(circle.getCenter().getX(), circle.getCenter().getY()),
//                                             circle.getRadius()));

        // Draw the aggregation
        aggregation.draw(shapesPane);

        // Button for moving the figures
        Button btnMove = new Button("Move");
        btnMove.setOnAction(event -> {
            aggregation.move(10, 10); // Move a little bit
            aggregation.update(shapesPane); // Update the canvas after move
        });
        btnMove.setLayoutX(650); // Set button position
        btnMove.setLayoutY(550);

        // Button for rotating the figures
        Button btnRotate = new Button("Rotate");
        btnRotate.setOnAction(event -> {
            aggregation.rotate(10, new Point(300, 300)); // Rotate a little bit
            aggregation.update(shapesPane); // Update the canvas after rotate
        });
        btnRotate.setLayoutX(650); // Set button position
        btnRotate.setLayoutY(580);

        // Button to reset the figures to their initial state
        Button btnReset = new Button("Reset");
        btnReset.setOnAction(event -> {
            // Reset figures to their initial state
            aggregation.reset();
            aggregation.update(shapesPane);
        });
        btnReset.setLayoutX(650); // Set button position
        btnReset.setLayoutY(610);

        canvas.getChildren().addAll(btnMove, btnRotate, btnReset); // Add button to canvas

        primaryStage.setTitle("Geometric Figures Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

