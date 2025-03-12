package org.example;

import java.util.Comparator;

public class SalaryCalculator{
    private double baseSalary;
    private double bonusPercentage;
    private SalaryStrategy salaryStrategy;

    public SalaryCalculator(double baseSalary, double bonusPercentage, SalaryStrategy salaryStrategy){
        if(baseSalary<0) throw new IllegalArgumentException("Base salary cannot be negative");
        if(bonusPercentage<0) throw new IllegalArgumentException("Bonus percentage cannot be negative.");

        this.baseSalary = baseSalary;
        this.bonusPercentage = bonusPercentage;
        this.salaryStrategy = salaryStrategy;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if(bonusPercentage<0) throw new IllegalArgumentException("Bonus percentage cannot be negative.");
        this.bonusPercentage = bonusPercentage;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary<0) throw new IllegalArgumentException("Salary cannot be less than zero.");
        this.baseSalary = baseSalary;
    }

    public double calculateSalary(double baseSalary, double bonusPercentage) throws PayrollComputationException {
        if(baseSalary<0 || bonusPercentage<0) throw new PayrollComputationException("Base salary or Percentage is negative.");
        return salaryStrategy.calculateSalary(baseSalary, bonusPercentage);
    }

    public static Comparator<SalaryCalculator> getComparatorBySalary(){
        return Comparator.comparing(SalaryCalculator::getBaseSalary);
    }

    public String displaySalaryDetails(Employee employee) {
        String maskedEmployeeId = maskedEmployeeId(employee);
        return "Employee ID: "+maskedEmployeeId+"\nEmployment Type: "+employee.getEmploymentType()+"\nName: "+employee.getName()+"\nDepartment: "
                +employee.getDepartment();
    }

    public String maskedEmployeeId(Employee employee){
        StringBuilder maskedEmployeeId = new StringBuilder();
        maskedEmployeeId.append(employee.getEmployeeId(), 0, 2);
        for(int i=2;i<employee.getEmployeeId().length();i++){
            maskedEmployeeId.append("*");
        }
        return maskedEmployeeId.toString();
    }
}
