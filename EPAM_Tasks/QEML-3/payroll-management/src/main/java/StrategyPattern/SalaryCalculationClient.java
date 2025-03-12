package StrategyPattern;

public class SalaryCalculationClient {
    public static void main(String[] args) {
        SalaryCalculationContext salaryCalculationContext = new SalaryCalculationContext();

        salaryCalculationContext.setSalaryCalculation(new FullTimeSalaryCalculation(20, 300));
        System.out.println("Salary: "+salaryCalculationContext.calculateSalary());

        salaryCalculationContext.setSalaryCalculation(new PartTimeSalaryCalculation(8));
        System.out.println("Salary: "+salaryCalculationContext.calculateSalary());
    }
}
