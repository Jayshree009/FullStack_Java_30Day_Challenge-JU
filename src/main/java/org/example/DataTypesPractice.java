package org.example;

public class DataTypesPractice{
    public static void main(String[] args){

        String name = "Jayshree";
        int dayOfChallenge = 30;
        double targetSalary = 95000.50;
        boolean jobReady = false;
        char grade = 'A';

        System.out.println("== dayatype Practice====");;
        System.out.println(" Name : "+name);
        System.out.println("Days of challenge :"+dayOfChallenge);
        System.out.println("Target Salary : "+ targetSalary);
        System.out.println(" Job ready now ?"+jobReady );
        System.out.println("Current grade :"+grade);

        // Simple expression

        int completeDays = 1;
        int remainingDays = dayOfChallenge-completeDays;
        System.out.println("Remaining days in challenge : "+remainingDays);
    }
}