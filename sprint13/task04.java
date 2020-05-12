//Write a method to get the date n-years m-months and k-days after today using new DateTime API.
//
//Return the obtained date in the format ISO_LOCAL_DATE.

public static String getDateAfterToday(int years, int months, int days) {
    LocalDate resultDate = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
    return resultDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
}
