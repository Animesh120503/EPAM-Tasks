package FactoryPattern;

public class EmployeeFactory {
    public static Employee getEmployee(String type, String employeeName, String employeeId,
                                       String projectAssigned){
        if("Part-Time".equalsIgnoreCase(type))
            return new PartTimeEmployee(employeeName, employeeId, projectAssigned);
        else if("Full-time".equalsIgnoreCase(type))
            return new FullTimeEmployee(employeeName, employeeId, projectAssigned);
        else
            throw new IllegalArgumentException("Mentioned type is invalid.");
    }
}
