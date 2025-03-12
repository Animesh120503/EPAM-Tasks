package org.example;
import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static <T extends Employee> void processPayrollAdjustment(T employee) {
        if(employee==null) throw new IllegalArgumentException("No employee exists.");
        Class<?> clazz = employee.getClass();

        if (clazz.isAnnotationPresent(payrollAdjustment.class)) {
            payrollAdjustment classAnnotation = clazz.getAnnotation(payrollAdjustment.class);
            double taxDeduction = classAnnotation.taxDeduction();
            applyTaxDeduction(employee, taxDeduction);
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(payrollAdjustment.class)) {
                payrollAdjustment methodAnnotation = method.getAnnotation(payrollAdjustment.class);
                double taxDeduction = methodAnnotation.taxDeduction();
                applyTaxDeduction(employee, taxDeduction);
            }
        }
    }

    private static <T extends Employee> void applyTaxDeduction(T employee, double taxDeduction) {
        if(taxDeduction<0) throw new IllegalArgumentException("Tax percentage cannot be negative.");
        double baseSalary = employee.getBaseSalary();
        double adjustedSalary = baseSalary - (baseSalary * taxDeduction / 100);
        employee.setBaseSalary(adjustedSalary);

        System.out.println("Applying " + taxDeduction + "% tax deduction:");
        System.out.println("Adjusted Base Salary: " + adjustedSalary);
    }
}