//Suppose we have the next class hierarchy:
// class Person {
//    protected String name;
//    protected int age;
//    public Person(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//    public String getName(){
//        return name;
//    }
//    public int getAge(){
//        return age;
//    }
//    public String toString(){
//        return "Name: " + name + ", Age: " + age;
//    }
// }
// class Employee extends Person {
//    private double salary;
//    public Employee(String name, int age, double salary){
//        super(name, age);
//        this.salary = salary;
//    }
//    public double getSalary(){
//        return salary;
//    }
//    public String toString(){
//        return super.toString() + ", Salary: " + salary;
//    }
// }
// class Developer extends Employee {
//    private Level level;
//    public Developer(String name, int age, double salary, Level level){
//        super(name, age, salary);
//        this.level = level;
//    }
//    public Level getLevel(){
//        return level;
//    }
//    public String toString(){
//        return super.toString() + ", Level: " + level;
//    }
// }
//
// enum Level {
//    JUNIOR, MIDDLE, SENIOR
// }
//
//Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the Comparator<Type> generic interface.
//
//In the Utility class create public static method named sortPeople(...) that takes an array of Person type and derivative from it types, and comparator as input, and returns the value of void type.
//
//Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.
//
//The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)
//
//As implementation of sortPeople(...) method use the next code:
//   /return type/ sortPeople( /people/, /comparator/ ) {
//      Arrays.sort( /people/, /comparator/ );
//   }


// Write PersonComparator, EmployeeComparator and DeveloperComparator here
class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.equals(o2.name) ? o1.age - o2.age : o1.name.compareTo(o2.name);
    }
}

class EmployeeComparator implements Comparator<Employee> {
    PersonComparator personComparator = new PersonComparator();
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = 0;
        if((result = personComparator.compare(o1, o2)) != 0){
            return result;
        } else {
            return Double.compare(o1.getSalary(), o2.getSalary());
        }
    }
}
class DeveloperComparator implements Comparator<Developer> {
    EmployeeComparator employeeComparator = new EmployeeComparator();
    @Override
    public int compare(Developer o1, Developer o2) {
        int result = 0;
        if((result = employeeComparator.compare(o1, o2)) != 0){
            return result;
        } else {
            if(o1.getLevel().equals(o2.getLevel())){
                return 0;
            } else if(o1.getLevel().equals(Level.SENIOR) || o2.getLevel().equals(Level.JUNIOR)){
                return 1;
            } else {
                return -1;
            }
        }
    }
}

class Utility {
    // Write sortPeople mentod here
    public static <T extends Person> void sortPeople (T[] people, Comparator<? super T> comparator) {
        Arrays.sort(people, comparator);
    }
}
