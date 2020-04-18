//Let the code given.
//
//Please create class Shape with abstract method to calculate area of figure and field name.
// Replace code in method getArea() according to principles of polymorphism i.e.
// Circle and Rectangle classes extends Shape class and override double getArea() method.
// Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.
//The original list must be unchanged.
//For example, for a given list
//[Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00],
// Rectangle [height=3.00, width=2.00],  Circle [radius=0.50],
// Rectangle [height=1.00, width=2.00]]
//you should get
//[Circle [radius=2.00], Rectangle [height=2.00, width=3.00],
// Rectangle [height=3.00, width=2.00]]

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Shape {
    private String name;
    public Shape(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double getArea();
}
class Circle extends Shape {
    private double radius;
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Circle circle = (Circle) obj;
        return radius == circle.getRadius();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long radiusBits = Double.doubleToLongBits(getRadius());
        result = prime * result + (int)(radiusBits ^ (radiusBits >>> 32));
        return result;
    }
}
class Rectangle extends Shape {
    private double height;
    private double width;
    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    @Override
    public double getArea() {
        return height * width;
    }
    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", width=" + width + "]";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return height == rectangle.getHeight() && width == rectangle.getWidth();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long heightBits = Double.doubleToLongBits(getHeight());
        result = prime * result + (int)(heightBits ^ (heightBits >>> 32));
        long widthBits = Double.doubleToLongBits(getHeight());
        result = prime * result + (int)(widthBits ^ (widthBits >>> 32));
        return result;
    }
}
public class MyUtils {
    class ShapeAriaComparator implements Comparator<Shape>{
        public int compare(Shape c1, Shape c2) {
            return (int) (c2.getArea() - c1.getArea());
        }
    }
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> result = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();

        for(Shape shape : shapes) {
            if (shape instanceof Circle && !circles.contains(shape)) {
                circles.add((Circle)shape);
            }
            if (shape instanceof Rectangle && !rectangles.contains(shape)) {
                rectangles.add((Rectangle) shape);
            }
        }
        Collections.sort(circles, new ShapeAriaComparator());
        Collections.sort(rectangles, new ShapeAriaComparator());
        if(circles.size() > 0) {
            result.add(circles.get(0));
            for(int i = 1; i < circles.size(); i++) {
                if(circles.get(i).getArea() != circles.get(0).getArea()) {
                    break;
                }
                result.add(circles.get(i));
            }
        }
        if(rectangles.size() > 0) {
            result.add(rectangles.get(0));
            for(int i = 1; i < rectangles.size(); i++) {
                if(rectangles.get(i).getArea() != rectangles.get(0).getArea()) {
                    break;
                }
                result.add(rectangles.get(i));
            }
        }
        return result;
    }
}
