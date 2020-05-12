//Write a method to check if a year is a leap year or not, using for this the LocalDate class.
//
//If a year is leap then method should return true, otherwise - false.

public static boolean isLeapYear(int year) {
    int month = 1;
    int day = 1;
    return LocalDate.of(year, month, day).isLeapYear();
}
