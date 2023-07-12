package core_jdbc1;

interface Drawable {
    void draw();
}

class Circle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("drawing  circle");
    }
}

class Rectangle1 implements Drawable {
    @Override
    public void draw() {
        System.out.println("drawing  rectangle");
    }
}

public class java_testQ4 {
	 public static void main(String[] args) {
	        Drawable circle = new Circle1();
	        circle.draw();  

	        Drawable rectangle = new Rectangle1();
	        rectangle.draw();  
	    }
}
