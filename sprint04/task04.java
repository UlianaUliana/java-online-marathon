//Suppose we have the next class:
//class Circle {
//    private double radius;
//    public Circle(double radius) {
//        this.radius = radius;
//    }
//    public void draw() {}
//}
//Create a new version of the Circle class where the draw method will be overloaded three times:
//Using the one parameter color of String type.
//Using the one parameter scale of float type.
//Using two parameters color and scale of String and float type.
//For correct passing of all tests don't use print and println methods in your code.


class Circle {
    private double radius;
    String color = "red";
    float scale = 1.5f;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public void draw() {}
    
    public void draw(String color) {
        this.color = color;
    }
    
    public void draw(float scale) {
        this.scale = scale;
    }
    
    public void draw(String color, float scale) {
        this.color = color;
        this.scale = scale;
    }
}
