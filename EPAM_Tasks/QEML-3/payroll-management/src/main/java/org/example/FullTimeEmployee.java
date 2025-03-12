package org.example;

@payrollAdjustment(taxDeduction = 7.1)
public class FullTimeEmployee extends Employee{
    private double baseSalary;
    private double annualBonus;
    private final SalaryCalculator salaryCalculator;
    public FullTimeEmployee(String employeeId, String name, String department,
                            double baseSalary, double annualBonus, SalaryCalculator salaryCalculator){
        super(employeeId, name, department);
        if(baseSalary<0) throw new IllegalArgumentException("Base Salary cannot be negative.");
        if(annualBonus<0) throw new IllegalArgumentException("Bonus cannot be negative.");

        this.baseSalary = baseSalary;
        this.annualBonus = annualBonus;
        this.salaryCalculator = salaryCalculator;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        if(annualBonus<0) throw new IllegalArgumentException("Bonus cannot be null.");
        this.annualBonus = annualBonus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary<0) throw new IllegalArgumentException("Base Salary cannot be negative.");
        this.baseSalary = baseSalary;
    }

    @Override
    public String getEmploymentType(){
        return "Full Time";
    }

    public double totalSalaryCalculation() throws PayrollComputationException {
        return salaryCalculator.calculateSalary(salaryCalculator.getBaseSalary(), salaryCalculator.getBonusPercentage()) + annualBonus;
    }

    public String display() throws PayrollComputationException {
        return salaryCalculator.displaySalaryDetails(this)+
        "\nAnnual bonus: "+annualBonus+"\nGross Salary: "+totalSalaryCalculation();
    }
}
