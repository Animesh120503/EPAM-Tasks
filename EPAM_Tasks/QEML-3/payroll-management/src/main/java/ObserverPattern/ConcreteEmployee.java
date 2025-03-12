package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteEmployee implements Employee {
    private double salary;
    List<SalaryObserver> observers = new ArrayList<>();

    public void setSalary(double salary){
        if(salary<0) throw new IllegalArgumentException("Provided input is negative.");
        this.salary = salary;
        notifyObservers();
    }

    @Override
    public void addObserver(SalaryObserver salaryObserver){
        observers.add(salaryObserver);
    }

    @Override
    public void removeObserver(SalaryObserver salaryObserver){
        observers.remove(salaryObserver);
    }

    @Override
    public void notifyObservers(){
        for(SalaryObserver salaryObserver : observers){
            salaryObserver.update(salary);
        }
    }
}
