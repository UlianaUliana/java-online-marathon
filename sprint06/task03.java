//Create classes Square and Rectang with method (double getPerimeter()) for calculating
// of perimeter.
//Find solution for avoiding of duplicate code.
//Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return
// a sum perimeters of all figures.
//For example, for a given list
//[[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
//you should get 46

import java.util.ArrayList;
import java.util.List;

abstract class Figure {
    public abstract double getPerimeter();
}

class Rectang extends Figure {
    private double height;
    private double width;
    public Rectang (double height, double width) {
        this.height = height;
        this.width = width;
    }
    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }
}
class Square extends Figure {
    private double width;
    public Square (double width) {
        this.width = width;
    }
    @Override
    public  double getPerimeter() {
        return width * 4;
    }
}
public class MyUtils {
    public double sumPerimeter(List<Figure> figures) {
        double sum = 0;
        for(int i = 0; i < figures.size(); i++) {
            if (figures.get(i) != null) {
                sum += figures.get(i).getPerimeter();
            }
        }
        return sum;
    }
}

