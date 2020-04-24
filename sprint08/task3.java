//Suppose, we have class Person:
//
//  class Person{
//      String name;
//      String surname;
//      Person(String name, String surname){
//          this.name = name;
//          this.surname = surname;
//      }
//  }
//
//Please, add to class App static BinaryOperator field greetingOperator.
//
//greetingOperator should work with strings. It forms a new string as a result by the rule:
// "Hello " + parameter1 + " " + parameter2 + "!!!"
//
//Create a static method createGreetings that takes two parameters:
// List<Person> and BinaryOperator and generates List<String> as a result.
// We should be able to pass greetingOperator as a parameter here.
// Please, use the second parameter in creating the result.

import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

public class App {
    static BinaryOperator<String> greetingOperator = (par1, par2) -> "Hello " + par1 + " " + par2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator){
        List<String> personList = new ArrayList<String>();
        for(int i = 0; i < people.size(); i++){
            personList.add(greetingOperator.apply(people.get(i).name, people.get(i).surname));
        }
        return personList;
    }
}
