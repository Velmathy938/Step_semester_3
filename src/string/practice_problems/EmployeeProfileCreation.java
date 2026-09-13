package string.practice_problems;

public class EmployeeProfileCreation {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfileCreation(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfileCreation(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(
                empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern
        );
    }

    public static void main(String[] args) {

        EmployeeProfileCreation permanentEmployee =
                new EmployeeProfileCreation("E-101", "Divya", 65000);

        EmployeeProfileCreation internEmployee =
                new EmployeeProfileCreation("E-102", "Arjun");

        permanentEmployee.printProfile();
        internEmployee.printProfile();
    }
}