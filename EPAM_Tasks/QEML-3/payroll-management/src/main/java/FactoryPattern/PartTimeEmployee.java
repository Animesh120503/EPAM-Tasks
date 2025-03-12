package FactoryPattern;

public class PartTimeEmployee extends Employee{
    private String employeeName;
    private String employeeId;
    private String projectAssigned;

    public PartTimeEmployee(String employeeName, String employeeId, String projectAssigned){
        if(employeeName == null || employeeName.isEmpty()) throw new IllegalArgumentException("Null or empty String provided.");
        if(employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Null or empty String provided.");
        if(projectAssigned == null || projectAssigned.isEmpty()) throw new IllegalArgumentException("Null or empty String provided.");

        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.projectAssigned = projectAssigned;
    }

    @Override
    public String getEmployeeName(){
        return this.employeeName;
    }

    @Override
    public String getEmployeeId(){
        return this.employeeId;
    }

    @Override
    public String getProjectAssigned(){
        return this.projectAssigned;
    }
}
