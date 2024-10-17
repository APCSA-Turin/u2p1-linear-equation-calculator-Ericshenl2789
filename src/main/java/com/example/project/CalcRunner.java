package com.example.project;

public class CalcRunner {
    public static void main(String[] args) {
        LinearCalculator calc = new LinearCalculator("(10,5)","(6,-1)");
        String expectedOutput = "The two points are: (10,5)";
        expectedOutput += " and " + "(6,-1)";
        expectedOutput += "\nThe equation of the line between these points is: y=1.5x-10.0";
        expectedOutput += "\nThe slope of this line is: 1.5";
        expectedOutput += "\nThe y-intercept of the line is: -10.0";
        expectedOutput += "\nThe distance between the two points is: 7.21";
        System.out.println(expectedOutput + "\n");
        System.out.println(calc.printInfo());
    }
}