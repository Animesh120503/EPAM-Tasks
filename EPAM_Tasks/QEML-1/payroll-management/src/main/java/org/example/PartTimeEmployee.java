package org.example;

@payrollAdjustment
public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    public PartTimeEmployee(String employeeId, String name, String department, double baseSalary, int hoursWorked) {
        super(employeeId, name, department, baseSalary);
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked cannot be negative");
        this.hoursWorked = hoursWorked;

    }

    @Override
    public String getEmploymentType() {
        return "Part Time";
    }

    @Override
    @payrollAdjustment(taxDeduction = 6)
    public double salaryCalculation(double baseSalary) throws PayrollComputationException{
        if(baseSalary<=0) throw new IllegalArgumentException("Base salary cannot be zero or negative");
        double overtime = 0;
        try {
            overtime = hoursWorked > 40 ? (hoursWorked - 40) * (baseSalary / 0) : 0;
        }catch(ArithmeticException err){
            throw new PayrollComputationException("Error in computing overtime pay: Division by Zero"+err);
        }
        return baseSalary + overtime;
    }

    public String display() {
        try {
            return displaySalaryDetails() + "\nHours worked: " + hoursWorked + "\nGross Salary: " + salaryCalculation(getBaseSalary());
        } catch (PayrollComputationException e) {
            throw new RuntimeException(e);
        }
    }

}