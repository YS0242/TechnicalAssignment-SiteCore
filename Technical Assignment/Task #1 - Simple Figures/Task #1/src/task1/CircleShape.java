package task1;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class CircleShape implements ShapeInterface{
	private Point center;
    private double radius;

    public CircleShape(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // Method to move the circle
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    // Method to rotate the circle
    public void rotate(double angle, Point rotationCenter) {
        center.rotate(angle, rotationCenter);
    }

    // Getters and Setters...
    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public javafx.scene.shape.Shape getShape() {
        Circle circle = new Circle(center.getX(), center.getY(), radius);
        circle.setStroke(Color.GREEN);
        circle.setFill(Color.TRANSPARENT);
        return circle;
    }
    
    @Override
    public CircleShape clone() {
        return new CircleShape(this.center.clone(), this.radius);
    }
}
