package FactoryPattern;

public abstract class Employee {
    public abstract String getEmployeeName();
    public abstract String getEmployeeId();
    public abstract String getProjectAssigned();

    @Override
    public String toString() {
        return "Employee{Name: "+this.getEmployeeName()+", "+
                "ID: "+this.getEmployeeId() +", "+
                "Project: "+this.getProjectAssigned()+
                "}";
    }
}
