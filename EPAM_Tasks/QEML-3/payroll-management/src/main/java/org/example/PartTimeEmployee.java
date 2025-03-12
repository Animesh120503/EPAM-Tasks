package org.example;

import java.util.Scanner;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double baseSalary;
    private SalaryCalculator salaryCalculator;
    public PartTimeEmployee(String employeeId, String name, String department,
                              double baseSalary, int hoursWorked, SalaryCalculator salaryCalculator) {
        super(employeeId, name, department);
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked cannot be negative");
        if(baseSalary<0) throw new IllegalArgumentException("Base salary cannot be negative");

        this.hoursWorked = hoursWorked;
        this.baseSalary = baseSalary;
        this.salaryCalculator = salaryCalculator;
    }

    @Override
    public String getEmploymentType() {
        return "Part Time";
    }

    public double salaryCalculation(double baseSalary) throws PayrollComputationException{
        if(baseSalary<=0) throw new IllegalArgumentException("Base salary cannot be zero or negative");
        Scanner sc = new Scanner(System.in);
        int component = sc.nextInt();
        double overtime = 0;
        try {
            overtime = hoursWorked > 40 ? (hoursWorked - 40) * (baseSalary / component) : 0;
        }catch(ArithmeticException err){
            throw new PayrollComputationException("Error in computing overtime pay: Division by Zero"+err);
        }
        return baseSalary + overtime;
    }

    public String display() {
        try {
            return salaryCalculator.displaySalaryDetails(this) + "\nHours worked: " + hoursWorked + "\nGross Salary: " + salaryCalculation(baseSalary);
        } catch (PayrollComputationException e) {
            throw new RuntimeException(e);
        }
    }

}
