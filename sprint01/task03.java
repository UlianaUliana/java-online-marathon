public static int century(int year) {
    if(year%100 == 0) return year/100;
    return (int) year/100 + 1;
}
