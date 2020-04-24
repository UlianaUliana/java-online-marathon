//Please, create a static Consumer implementation cons that takes an array of doubles
// as a parameter and changes it using the next rule: all values that are greater than 2
// should be multiplied by 0.8, and other values should be multiplied by 0.9.
//
//Also, please. implement a static method getChanged that takes an array of doubles
// as a first parameter and  Consumer as a second. The method should return an array
// changed by the second parameter.
//
//getChanged method should not change initial array.


import java.util.function.Consumer;

public class App {
    static Consumer<double[]> cons = (value) -> {
        for(int i = 0; i < value.length; i++){
            if(value[i] > 2) {
                value[i] *= 0.8;
            } else {
                value[i] *= 0.9;
            }
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
        double[] arr = new double[initialArray.length];
        System.arraycopy(initialArray, 0, arr, 0, initialArray.length);
        cons.accept(arr);
        return arr;
    }
}
