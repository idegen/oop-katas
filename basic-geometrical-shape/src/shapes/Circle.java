package shapes;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }

    public Rectangle boundingRectangle(){
        double diameter = radius * 2;
        return new Rectangle(diameter, diameter);
    }

}
