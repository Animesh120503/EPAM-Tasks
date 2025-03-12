public class RegularSalaryCalculator implements SalaryCalculator{
    @Override
    public double calculate(double baseSalary) {
        if(baseSalary<=0) throw new IllegalArgumentException("Salary cannot be zero or negative.");
        return baseSalary+baseSalary*0.03;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
