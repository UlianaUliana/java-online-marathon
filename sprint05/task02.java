//    •Implement class User with protected fields name, surname and public method getFullName()
//      which returns name and surname with one space between them. Constructor of User define as
//      public with two parameters – for initialization name and surname
//    •Implement also class Student that is inherited from User. This class must have integer
//      protected field year – the year of entering university, and public method getCourseNumber() –
//      evaluates year of studying based on year property and current year:
//      the difference between years + 1. (If the value is not from the range from 1 to 6,
//      the method should return -1). Constructor of Student should be public and have 3 parameters:
//      year, name and surname and pass name and surname to the base class.
//      (year parameter should be the first.)

import java.util.Calendar;

class User {
    protected String name;
    protected String surname;
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String getFullName() {
        return name + " " + surname;
    }
}

class Student extends User {
    protected int year;
    public Student(int year, String name, String surname) {
        super(name, surname);
        this.year = year;
    }
    public int getCourseNumber() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int result = currentYear - year + 1;
        if(result < 1 || result > 6) {
            result = -1;
        }
        return result;
    }
}
