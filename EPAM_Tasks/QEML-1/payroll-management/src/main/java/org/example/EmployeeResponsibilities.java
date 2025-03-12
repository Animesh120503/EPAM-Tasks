package org.example;

public class EmployeeResponsibilities<T extends Employee> extends EmployeeContract<T> {
    @Override
    public void defineWorkHours(T employee) {
        System.out.println(employee.displaySalaryDetails());
        if (employee instanceof PartTimeEmployee) {
            System.out.println("Minimum Working hours are: 3 hours/day\n");
        } else if (employee instanceof FullTimeEmployee) {
            System.out.println("Minimum Working hours are: 8 hours/day\n");
        }
    }

    @Override
    public void assignProject(T employee) {
        System.out.println(employee.displaySalaryDetails());
        if (employee instanceof PartTimeEmployee) {
            System.out.println("You will be assigned to a part-time project.\n");
        } else if (employee instanceof FullTimeEmployee) {
            System.out.println("You will be assigned to a full-time project.\n");
        }
    }
}