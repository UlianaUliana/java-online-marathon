//Create classes Employee (fields String name, int experience and BigDecimal basePayment)
// and Manager (field double coefficient) with methods which return the general working
// experience and payment for work done.
//A getter methods of class Employee return value of all fields: getName(), getExperience()
// and getPayment().
//Classes Manager is derived from class Employee and override getPayment() method
// to return multiplication of a coefficient and base payment.
//Create a largestEmployees() method of the MyUtils class to return a List of unique
// employees with maximal working experience and payment without duplicate objects.
//The original list must be unchanged.
//For example, for a given list
// [Employee [name=Ivan, experience=10, basePayment=3000.00],
// Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
// Employee [name=Stepan, experience=8, basePayment=4000.00],
// Employee [name=Andriy, experience=7, basePayment=3500.00],
// Employee [name=Ihor, experience=5, basePayment=4500.00],
// Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
//you should get
//[Employee [name=Ivan, experience=10, basePayment=3000.00],
// Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
// Employee [name=Ihor, experience=5, basePayment=4500.00]].

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;
    
    public Employee (String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Employee employee = (Employee) obj;
        return name.equals(employee.getName()) && experience == employee.getExperience() && basePayment.equals(employee.getPayment());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName() == null ? 0 : getName().hashCode();
        result = prime * result + getExperience();
        result = prime * result + getPayment().hashCode();
        return result;
    }
     @Override
    public String toString() {
        return "[Employee [name=" + name + ", experience=" + experience + ", basePayment=" + basePayment + "]";
    }
}

class Manager extends Employee {
    private double coefficient;
    public Manager (String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }
     public double getCoefficient() {
        return coefficient;
    }
    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }
     @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Employee employee = (Employee) obj;
        return getName().equals(employee.getName()) && getExperience() == employee.getExperience()
                && getPayment().equals(employee.getExperience()) && coefficient == getCoefficient();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long coefficientBits = Double.doubleToLongBits(getCoefficient());
        result = prime * result + (int)(coefficientBits ^ (coefficientBits >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return "Manager [name=" + getName() + ", experience=" + getExperience() +
        ", basePayment=" + getPayment() + ", coefficient=" + getCoefficient() + "]";
    }
}
public class MyUtils {
    class ExperienceComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return e2.getExperience() - e1.getExperience();
        }
    }
    class PaymentComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return e2.getPayment().compareTo(e1.getPayment());
        }
    }
    public List<Employee> largestEmployees(List<Employee> workers) {
        Set<Employee> resultSet = new HashSet<>();
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();

        for (Employee worker : workers) {
            if (worker instanceof Manager) {
                managers.add((Manager)worker);
            } else {
                employees.add(worker);
            }
        }


        if(employees.size() > 0) {
            Collections.sort(employees, new ExperienceComparator());
            resultSet.add(employees.get(0));
            for(int i = 1; i < employees.size(); i++) {
                if(employees.get(i).getExperience() != employees.get(0).getExperience()) {
                    break;
                }
                resultSet.add(employees.get(i));
            }
            Collections.sort(employees, new PaymentComparator());
           resultSet.add(employees.get(0));
            for(int i = 1; i < employees.size(); i++) {
                if(employees.get(i).getPayment() != employees.get(0).getPayment()) {
                    break;
                }
                resultSet.add(employees.get(i));
            }
        }


        if(managers.size() > 0) {
            Collections.sort(managers, new ExperienceComparator());
            resultSet.add(managers.get(0));
            for(int i = 1; i < managers.size(); i++) {
                if(managers.get(i).getExperience() != managers.get(0).getExperience()) {
                    break;
                }
                resultSet.add(managers.get(i));
            }
            Collections.sort(managers, new PaymentComparator());
            resultSet.add(managers.get(0));
            for(int i = 1; i < managers.size(); i++) {
                if(managers.get(i).getPayment() != managers.get(0).getPayment()) {
                    break;
                }
                resultSet.add(managers.get(i));
            }
        }
        return new ArrayList<Employee>(resultSet);
    }
}
