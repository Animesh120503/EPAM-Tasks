package org.example.com;

public class EmployeeBusinessLogic {
    public double calculateYearlySalary(EmployeeDetails employeeDetails){
        double monthlySalary = employeeDetails.getSalary();
        return monthlySalary*12;
    }

    public double calculateAppraisal(EmployeeDetails employeeDetails){
        double monthlySalary = employeeDetails.getSalary();
        if(monthlySalary<10000)
            return 5000;
        else if(monthlySalary<20000)
            return 4500;
        else
            return 3000;
    }
}
