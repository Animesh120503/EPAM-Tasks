import org.example.com.EmployeeBusinessLogic;
import org.example.com.EmployeeDetails;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestEmployeeDetails {
    EmployeeDetails employeeDetails = new EmployeeDetails();
    EmployeeBusinessLogic employeeBusinessLogic = new EmployeeBusinessLogic();

    @Test
    public void testYearlySalary(){
        System.out.println("Thread Method 1: "+Thread.currentThread().getId());
        employeeDetails.setSalary(34560);

        double yearlySalary = employeeBusinessLogic.calculateYearlySalary(employeeDetails);

        assertEquals(yearlySalary, 34560*12);
    }

    @Test(dependsOnMethods = "testYearlySalary")
    public void testAppraisal(){
        System.out.println("Thread Method 2: "+Thread.currentThread().getId());
        employeeDetails.setSalary(40000);

        double actualAppraisalValue = employeeBusinessLogic.calculateAppraisal(employeeDetails);

        assertEquals(actualAppraisalValue, 3000);
    }
    @Test(dependsOnMethods = "testYearlySalary")
    public void testAppraisal1(){
        System.out.println("Thread Method 3: "+Thread.currentThread().getId());
        employeeDetails.setSalary(40000);

        double actualAppraisalValue = employeeBusinessLogic.calculateAppraisal(employeeDetails);

        assertEquals(actualAppraisalValue, 3000);
    }
    @Test(dependsOnMethods = "testYearlySalary")
    public void testAppraisal2(){
        System.out.println("Thread Method 4: "+Thread.currentThread().getId());
        employeeDetails.setSalary(40000);

        double actualAppraisalValue = employeeBusinessLogic.calculateAppraisal(employeeDetails);

        assertEquals(actualAppraisalValue, 3000);
    }

    @Test
    @Parameters({"num1", "num2"})
    public void testParameters(int num1, int num2){
        System.out.println("Thread Method 5: "+Thread.currentThread().getId());
//        System.out.println(num1+num2);
    }
    @Test
    @Parameters({"num1", "num2"})
    public void testParameters1(int num1, int num2){
        System.out.println("Thread Method 6: "+Thread.currentThread().getId());
//        System.out.println(num1+num2);
    }
}
