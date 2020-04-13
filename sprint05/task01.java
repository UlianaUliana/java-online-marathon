//Create the abstract base class Employee with protected string variable employeelD and
// public getFullInfo() method without an implementation. Create public constructor
// with one string parameter for this class.
//Create two classes SalariedEmployee and ContractEmployee, which are inherited
// from the Employee class.
//  •Describe protected string field socialSecurityNumber in the class SalariedEmployee.
//  •Include a description of string protected federalTaxIDMember field
//      in the class of ContractEmployee.
//  •Describe constructors with two parameters for ContractEmployee class and
//      for SalariedEmployee class for initializing corresponding fields.
//  •getFullInfo should return String containing:
//     • employeelD and socialSecurityNumber for SalariedEmployee
//     • employeelD and federalTaxIDMember for ContractEmployee

abstract class Employee {
    protected String employeeID;
    public Employee (String employeeID) {
        this.employeeID = employeeID;
    }
    public abstract String getFullInfo();
}

class SalariedEmployee extends Employee {
    protected String socialSecurityNumber;

    public SalariedEmployee (String employeeID, String socialSecurityNumber) {
        super(employeeID);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String getFullInfo() {
        return "Employee ID: " + employeeID + ", Social Security Number: " + socialSecurityNumber;
    }
}

class ContractEmployee extends Employee {
    protected String federalTaxIDMember;
    public ContractEmployee (String employeeID, String federalTaxIDMember) {
        super(employeeID);
        this.federalTaxIDMember = federalTaxIDMember;
    }
    @Override
    public String getFullInfo() {
        return "Employee ID: " + employeeID + ", Federal Taxi ID Member: " + federalTaxIDMember;
    }
}
