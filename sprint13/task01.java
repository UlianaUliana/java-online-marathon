//Write a method to convert date and time, represented via Date object to object of Calendar type.

public static Calendar convertDateToCalendar(Date date) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    return calendar;
}
