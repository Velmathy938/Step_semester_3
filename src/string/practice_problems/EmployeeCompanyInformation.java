package string.practice_problems;

public class EmployeeCompanyInformation {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeCompanyInformation(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeCompanyInformation employee1 =
                new EmployeeCompanyInformation("Divya", 65000);

        EmployeeCompanyInformation employee2 =
                new EmployeeCompanyInformation("Arjun", 45000);

        EmployeeCompanyInformation employee3 =
                new EmployeeCompanyInformation("Priya", 55000);

        System.out.println("3 Employee objects created");
        System.out.println();

        EmployeeCompanyInformation.printCompanyInfo();
    }
}