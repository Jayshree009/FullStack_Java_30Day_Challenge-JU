package org.example;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){

        System.out.println("This is a mini calculator program ");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first number :");
        double num1 = sc.nextDouble();

        System.out.println("Please enter second number :");
        double num2 = sc.nextDouble();

        System.out.println("Choose the operation to be performed (+,-,*,/):");
        char op = sc.next().charAt(0);

        double results;
        boolean valid = true;

        switch (op){
            case '+':
                results = num1+num2;
               break;
            case '-':
                results = num1-num2;
                break;
            case '*':
                results = num1*num2;
                break;
            case '/':
                if(num2 ==0){
                    System.out.println("Error: cannot devide by 0");
                    valid = false;
                    results = 0;

                }else {
                    results = num1 / num2;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                valid = false;
                results = 0;

        }
        if (valid){
            System.out.println(" Result :"+results);
        }
        System.out.println("====== Calculator finished =====");
    }
}
