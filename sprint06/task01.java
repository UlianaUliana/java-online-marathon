//Create next types: Person (field String name), Student (fields String studyPlace, int studyYears)
// and Worker (fields String workPosition, int experienceYears). Classes Student and Worker are derived
// from class Person. All classes have getters to return fields.
//Create a maxDuration() method of the MyUtils class to return a list of Students with maximum duration
// of study and Workers with maximum experience.
//For example, for a given list
//[Person [name=Ivan], Student [name=Petro, studyPlace=University, studyYears=3],
// Worker [name=Andriy, workPosition=Developer, experienceYears=12],
// Student [name=Stepan, studyPlace=College, studyYears=4],
// Worker [name=Ira, workPosition=Manager, experienceYears=8],
// Student [name=Ihor, studyPlace=University, studyYears=4]]
//you should get
//[Worker [name=Andriy, workPosition=Developer, experienceYears=12],
// Student [name=Stepan, studyPlace=College, studyYears=4],
// Student [name=Ihor, studyPlace=University, studyYears=4]]

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
   private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Person [name=" + getName() + "]";
    }
}
class Student extends Person {
   private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }
    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public String toString() {
        return "Student [name=" + getName() + ", studyPlace=" + getStudyPlace() + ", studyYears=" + getStudyYears() + "]";
    }
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return getName().equals(student.getName()) && studyPlace.equals(student.getStudyPlace())
                && studyYears == student.getStudyYears();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName() == null ? 0 : getName().hashCode();
        result = prime * result + studyPlace == null ? 0 : studyPlace.hashCode();
        result = prime * result + studyYears;
        return result;
    }
}
class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }
    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Worker [name=" + getName() + ", workPosition=" + getWorkPosition() + ", experienceYears=" + getExperienceYears() + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return getName().equals(worker.getName()) && workPosition.equals(worker.getWorkPosition()) && experienceYears == worker.getExperienceYears();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName() == null ? 0 : getName().hashCode();
        result = prime * result + getWorkPosition() == null ? 0 : getWorkPosition().hashCode();
        result = prime * result + getExperienceYears();
        return result;
    }
}
public class MyUtils {
    class StudyYearsComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.getStudyYears() - o1.getStudyYears();
        }
    }

    class ExperienceYearsComparator implements Comparator<Worker> {
        @Override
        public int compare(Worker o1, Worker o2) {
            return o2.getExperienceYears() - o1.getExperienceYears();
        }
    }
    
    public List<Person> maxDuration(List<Person> persons) {
         List<Person> resultList = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        for(Person person : persons) {
            if (person instanceof Student) {
               students.add((Student)person);
            }
            if (person instanceof Worker) {
                workers.add((Worker)person);
            }
        }
        Collections.sort(students, new StudyYearsComparator());
        Collections.sort(workers, new ExperienceYearsComparator());
        if(students.size() > 0) {
            resultList.add(students.get(0));
            for(int i = 1; i < students.size(); i++) {
                if(students.get(i).getStudyYears() != students.get(0).getStudyYears()) {
                    break;
                }
                if (!students.get(i).equals(students.get(0))) {
                    resultList.add(students.get(i));
                }
            }
        }
        if(workers.size() > 0) {
            resultList.add(workers.get(0));
            for(int i = 1; i < workers.size(); i++) {
                if(workers.get(i).getExperienceYears() != workers.get(0).getExperienceYears()) {
                    break;
                }
                if (!workers.get(i).equals(workers.get(0))) {
                    resultList.add(workers.get(i));
                }
                resultList.add(workers.get(i));
            }
        }

        return resultList;
    }
}
