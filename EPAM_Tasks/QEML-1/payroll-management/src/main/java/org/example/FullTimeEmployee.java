package org.example;

@payrollAdjustment(taxDeduction = 7.1)
public class FullTimeEmployee extends Employee{
    private double annualBonus;
    public FullTimeEmployee(String employeeId, String name, String department,
                            double baseSalary, double annualBonus){
        super(employeeId, name, department, baseSalary);
        if(annualBonus<0) throw new IllegalArgumentException("Bonus cannot be negative.");
        this.annualBonus = annualBonus;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        if(annualBonus<0) throw new IllegalArgumentException("Bonus cannot be null.");
        this.annualBonus = annualBonus;
    }

    @Override
    public String getEmploymentType(){
        return "Full Time";
    }

    @Override
    public double salaryCalculation(double baseSalary){
        return baseSalary+annualBonus;
    }

    public String display(){
        return displaySalaryDetails()+
        "\nAnnual bonus: "+annualBonus+"\nGross Salary: "+salaryCalculation(getBaseSalary());
    }
}
