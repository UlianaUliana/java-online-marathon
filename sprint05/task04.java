//Please, make refactoring of the code.
//
//We know that adult  doesn't have childIDNumber
//child doesn't have passportNumber.
//
//Create a public constructor in each class to initialize all their fields
// (make the first parameter of type int).

class Person{
    int age;
    String name;
    String healthInfo;
    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }
    String getHealthStatus(){
        return name + " " + healthInfo;
    }
}

class Child extends Person{
    String childIDNumber;
    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }
    @Override
    String getHealthStatus(){
        return name + " " + childIDNumber + " " + healthInfo;
    }
}

class Adult extends Person{
    String passportNumber;
    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }
     @Override
    String getHealthStatus(){
        return name + " " + passportNumber + " " + healthInfo;
    }
}
