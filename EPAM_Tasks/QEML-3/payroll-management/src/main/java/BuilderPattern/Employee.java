package BuilderPattern;

public class Employee {
    String employeeName;
    String employeeId;
    String department;
    int employeeAge;

    public String getEmployeeName(){
        return employeeName;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public String getDepartment(){
        return department;
    }

    public int getEmployeeAge(){
        return employeeAge;
    }

    private Employee(Builder builder){
        this.employeeName = builder.employeeName;
        this.employeeId = builder.employeeId;
        this.department = builder.department;
        this.employeeAge = builder.employeeAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", employeeAge=" + employeeAge +
                '}';
    }

    public static class Builder{
        String employeeName;
        String employeeId;
        String department;
        int employeeAge;

        public Builder setEmployeeName(String employeeName){
            if(employeeName == null || employeeName.isEmpty()) throw new IllegalArgumentException("Null or empty String");
            this.employeeName = employeeName;
            return this;
        }

        public Builder setEmployeeId(String employeeId){
            if(employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Null or empty String");
            this.employeeId = employeeId;
            return this;
        }

        public Builder setDepartment(String department){
            if(department == null || department.isEmpty()) throw new IllegalArgumentException("Null or empty String");
            this.department = department;
            return this;
        }

        public Builder setEmployeeAge(int employeeAge){
            if(employeeAge < 0) throw new IllegalArgumentException("Null or negative age");
            this.employeeAge = employeeAge;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
