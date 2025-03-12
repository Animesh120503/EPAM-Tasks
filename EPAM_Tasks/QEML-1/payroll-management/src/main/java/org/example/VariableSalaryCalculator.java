package org.example;

@FunctionalInterface
public interface VariableSalaryCalculator {
    public double calculate(double baseSalary, double percentage);
}
