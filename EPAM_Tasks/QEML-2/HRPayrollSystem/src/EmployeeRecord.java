public record EmployeeRecord(String name, double salary) {
    public EmployeeRecord{
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(salary <= 0) throw new IllegalArgumentException("Salary cannot be zero or negative");
    }
    public static void main(String[] args) {
        EmployeeRecord emp1 = new EmployeeRecord("Animesh", 1200);
        System.out.println(emp1.toString());
    }
}
