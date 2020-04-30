//In the class ArrayUtil write a public static generic method named "setAndReturn(...)"
// to modify and return the element in an array from the given position.
//
//Examples of usage:
//        Integer[] numbers = new Integer[3];
//        int numberFromSecondPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52,1);
//        System.out.println(numberFromSecondPosition);
//
//        String[] words = new String[3];
//        String wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words, "Hello", 1);
//        System.out.println(wordFromSecondPosition);


class ArrayUtil {
    public static <T> T setAndReturn(T[] arr, T value, int index){
        arr[index] = value;
        return value;
    }
}
