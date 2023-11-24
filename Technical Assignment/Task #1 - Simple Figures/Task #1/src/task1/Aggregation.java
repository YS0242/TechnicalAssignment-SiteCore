package task1;

import java.util.List;
import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class Aggregation {
	private List<ShapeInterface> figures = new ArrayList<>(); 
	private List<ShapeInterface> initialState = new ArrayList<>();

    public void addFigure(ShapeInterface figure) {
        figures.add(figure);
    }

    public void move(double dx, double dy) {
        for (ShapeInterface figure : figures) {
            figure.move(dx, dy);
        }
    }

    public void rotate(double angle, Point center) {
        for (ShapeInterface figure : figures) {
            figure.rotate(angle, center);
        }
    }

    public void draw(Pane shapesPane) {
        shapesPane.getChildren().clear(); // Clear the canvas before redrawing
        for (ShapeInterface figure : figures) {
            shapesPane.getChildren().add(figure.getShape()); 
        }
    }
    
    public void update(Pane shapesPane) {
    	draw(shapesPane);
    }
    
//    public void reset(List<ShapeInterface> initialState) {
//        figures.clear(); // Clear the current figures
//        figures.addAll(initialState); // Add all the figures from the initial state
//    }
    
    public void saveInitialState() {
        // Clear any previous initial state and save a new one
        initialState.clear();
        for (ShapeInterface figure : figures) {
            initialState.add(figure.clone());
        }
    }

    public void reset() {
        figures.clear();
        for (ShapeInterface figure : initialState) {
            figures.add(figure.clone()); // Create a new instance based on the saved state
        }
    }
}
