package StrategyPattern;

public class SalaryCalculationContext {
    private SalaryCalculation salaryCalculation;

    public void setSalaryCalculation(SalaryCalculation salaryCalculation){
        this.salaryCalculation = salaryCalculation;
    }

    public double calculateSalary(){
        return salaryCalculation.calculateSalaryProcess();
    }
}
