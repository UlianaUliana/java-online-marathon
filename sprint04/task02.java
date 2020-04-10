//1. Create an instances of Employee class named 'emp1' and 'emp2'.
//2. Set values for 'fullName' and 'salary' properties.
//3. Create array of Employee type with name 'employees' and add two objects
// created before.
//4. Create variable with name 'employeesInfo' of String type.
//5. Using a loop, iterrate across array and write to variable named
// 'employeesInfo' info about each employee in next fommat:
//[{fullName: "<Full Name>", salary: <Salary>},
// {fullName: "<Full Name>", salary: <Salary>}]
//You don't need to create any classes and describe the main(...) method. Just write the code!
//For correct passing of all tests don't use print and println methods in your code.

Employee emp1 = new Employee();
Employee emp2 = new Employee();
emp1.fullName = "Ivan";
emp1.salary = 100.5f;
emp2.fullName = "Petro";
emp2.salary = 250.4f;
Employee[] employees = {emp1, emp2};
String employeesInfo = "[";
for(Employee employee : employees){
    employeesInfo += "{fullName: \"" + employee.fullName + "\", salary: " + employee.salary + "}, ";
}
employeesInfo = employeesInfo.substring(0, employeesInfo.length()-2);
employeesInfo += "]";
