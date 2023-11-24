package task1;

import javafx.scene.shape.Shape;

public interface ShapeInterface {
	void move(double dx, double dy);
    void rotate(double angle, Point center);
    Shape getShape();
    ShapeInterface clone();
}
