public sealed class Employee permits FullTimeEmployee, ContractorEmployee{
    private String name;
    public enum Role{
      ENGINEER,
      MANAGER,
    }
    private Role role;
    private String department;
    private double salary;

    public Employee(String name, Role role, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        if(role == null) throw new IllegalArgumentException("Role cannot be null");
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department == null || department.isEmpty()) throw new IllegalArgumentException("Department cannot be null or empty");
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary <= 0) throw new IllegalArgumentException("Salary cannot be zero or negative.");
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee:[Name: "+name+
                        ", Role: "+role+
                        ", Department: "+department+
                        ", Salary: "+salary+"]";
    }
}
non-sealed class FullTimeEmployee extends Employee {
    double workingHours;
    public FullTimeEmployee(String name, Role role, String department, double salary, double workingHours){
        super(name, role, department, salary);
        this.workingHours = workingHours;
    }
}
final class ContractorEmployee extends Employee {
    double contractHours;
    public ContractorEmployee(String name, Role role, String department, double salary, double contractHours){
        super(name, role, department, salary);
        this.contractHours = contractHours;
    }
}