package core_jdbc1;


abstract class Shape {
    public abstract double calculateArea();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class ShapeCalculator {
    public void printArea(Shape shape) {
        double area = shape.calculateArea();
        System.out.println("Area " + area);
    }
}

public class java_testQ2 {

	 public static void main(String[] args) {
	        ShapeCalculator calculator = new ShapeCalculator();

	        Shape rec = new Rectangle(7, 3);
	        calculator.printArea(rec);  

	        Shape circle = new Circle(4.5);
	        calculator.printArea(circle);     

	        Shape triangle = new Triangle(2, 6);
	        calculator.printArea(triangle);   
	    }
	
}
