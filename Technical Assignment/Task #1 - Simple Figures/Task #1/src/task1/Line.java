package task1;

import javafx.scene.paint.Color;

public class Line implements ShapeInterface{
	private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Method to move the line
    public void move(double dx, double dy) {
        start.move(dx, dy);
        end.move(dx, dy);
    }

    // Method to rotate the line
    public void rotate(double angle, Point center) {
        start.rotate(angle, center);
        end.rotate(angle, center);
    }

    // Getters and Setters...
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public javafx.scene.shape.Shape getShape() {
    	javafx.scene.shape.Line fxLine = new javafx.scene.shape.Line(
    			start.getX(), start.getY(), end.getX(), end.getY());
    	fxLine.setStroke(Color.BLUE);
    	return fxLine;
    }
    
    @Override
    public Line clone() {
        return new Line(this.start.clone(), this.end.clone());
    }
}
