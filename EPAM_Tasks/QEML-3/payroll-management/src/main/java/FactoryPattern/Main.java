package FactoryPattern;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Employee partTime = EmployeeFactory.getEmployee("Part-time", "Animesh",
                "658UT", "Part-time project assigned");
        Employee fullTime = EmployeeFactory.getEmployee("full-time", "Ankit",
                "98HYT", "Full-time project assigned");

        System.out.println(partTime.toString());
        System.out.println(fullTime.toString());
    }
}
