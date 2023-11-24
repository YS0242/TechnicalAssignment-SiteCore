package task1;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Point implements ShapeInterface{
	private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method to move the point
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Method to rotate the point around a given center
    public void rotate(double angle, Point center) {
        double radians = Math.toRadians(angle);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double nx = cos * (x - center.x) - sin * (y - center.y) + center.x;
        double ny = sin * (x - center.x) + cos * (y - center.y) + center.y;
        x = nx;
        y = ny;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public javafx.scene.shape.Shape getShape() {
        Circle circle = new Circle(x, y, 3);
        circle.setFill(Color.RED);
        return circle;
    }
    
    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }
}
