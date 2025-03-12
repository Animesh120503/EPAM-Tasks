package org.example;

public abstract class EmployeeContract<T extends Employee> {
    public abstract void defineWorkHours(T employee);
    public abstract void assignProject(T employee);
}