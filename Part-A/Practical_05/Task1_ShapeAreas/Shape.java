abstract class Shape {
    abstract double area();
}
class Circle extends Shape {
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    @Override double area() { return Math.PI * radius * radius; }
}
class Rectangle extends Shape {
    private final double length, width;
    Rectangle(double length, double width) { this.length = length; this.width = width; }
    @Override double area() { return length * width; }
}
class Triangle extends Shape {
    private final double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override double area() { return 0.5 * base * height; }
}
