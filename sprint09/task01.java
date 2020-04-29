//Create a String intToRoman(int number) method of the MyUtils class to convert integer
// to Roman numerals. The "number" must be positive and do not exceed 3999.
// Otherwise, throw an IllegalArgumentException.
//For example, for a given sequence of integer numbers
//5 9 19 91 3999
//you should get
//V IX XIX XCI MMMCMXCIX
//For more information, see https://en.wikipedia.org/wiki/Roman_numerals and
// http://www.onlineconversion.com/roman_numerals_advanced.htm

public class MyUtils {
    public String intToRoman(int number) {
        if(number > 3999 || number < 1){
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        int ones = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = (number / 100) % 10;
        int thousands = (number / 1000) % 10;
        for(int i = 0; i < thousands; i++) {
            sb.append("M");
        }
        if(hundreds != 0){
            switch(hundreds){
                case 1:
                case 2:
                case 3:
                    for(int i = 0; i < hundreds; i++){
                        sb.append("C");
                    }
                    break;
                case 4:
                    sb.append("CD");
                    break;
                case 5:
                    sb.append("D");
                    break;
                case 6:
                case 7:
                case 8:
                    sb.append("D");
                    for(int i = 0; i < hundreds - 5; i++){
                        sb.append("C");
                    }
                    break;
                case 9:
                    sb.append("CM");
            }
        }
        if(tens != 0){
            switch(tens){
                case 1:
                case 2:
                case 3:
                    for(int i = 0; i < tens; i++){
                        sb.append("X");
                    }
                    break;
                case 4:
                    sb.append("XL");
                    break;
                case 5:
                    sb.append("L");
                    break;
                case 6:
                case 7:
                case 8:
                    sb.append("L");
                    for(int i = 0; i < tens - 5; i++){
                        sb.append("X");
                    }
                    break;
                case 9:
                    sb.append("XC");
            }
        }
        if(ones != 0){
            switch(ones){
                case 1:
                case 2:
                case 3:
                    for(int i = 0; i < ones; i++){
                        sb.append("I");
                    }
                    break;
                case 4:
                    sb.append("IV");
                    break;
                case 5:
                    sb.append("V");
                    break;
                case 6:
                case 7:
                case 8:
                    sb.append("V");
                    for(int i = 0; i < ones - 5; i++){
                        sb.append("I");
                    }
                    break;
                case 9:
                    sb.append("IX");
            }
        }

        return sb.toString();
    }
}
