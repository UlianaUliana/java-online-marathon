public static int sumOfDigits(int number) {
       int d1 = (int) number/100;
       int d2 = (int) (number-d1*100)/10;
       int d3 = number%10;
       return d1+d2+d3;
}
