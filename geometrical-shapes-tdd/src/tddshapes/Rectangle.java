package tddshapes;

public class Rectangle {
    private final int height;
    private final int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public double calculateArea() {
        return width*height;
    }
}
