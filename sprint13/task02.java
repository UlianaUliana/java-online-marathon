//Write a method to get the name of last day of the given month in given year.
//
//Use GregorianCalendar class to solve this exercise.
//
//The name of day must corresponds next format: Monday, Tuesday, Wednesday, Thursday, Friday,
// Saturday, Sunday.
//
//If month isn't correct then name is "Wrong Month".

public static String lastDayOfMonth(int month, int year) {
    if(month > 11) return "Wrong Month";
    Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    calendar.set(Calendar.DAY_OF_MONTH, lastDay - 1);
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    String result = "";
    switch (day) {
        case 1:
            result = "Monday";
            break;
        case 2:
            result = "Tuesday";
            break;
        case 3:
            result = "Wednesday";
            break;
        case 4:
            result = "Thursday";
            break;
        case 5:
            result = "Friday";
            break;
        case 6:
            result = "Saturday";
            break;
        case 7:
            result = "Sunday";
    }
    return result;
}
