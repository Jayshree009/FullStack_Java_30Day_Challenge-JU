package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentListBasic {
    public static void main(String[] args) {

        ArrayList<String> Students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n ========= Student Manager App =======");
            System.out.println(" 1. Add Student");
            System.out.println(" 2. View All Students");
            System.out.println(" 3. Remove Student");
            System.out.println(" 4. Search Student");
            System.out.println(" 5. Exit");
            System.out.println(" Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();// to consume leftover \n so that it waits for accepting input from user

            switch (choice){
                case 1->{
                    System.out.println(" Enter student Name :");
                    String name = sc.nextLine();
                    Students.add(name);
                    System.out.println(" Student "+name+" added successfully");
                }
                case 2 ->{
                    System.out.println("----- Student list ------");
                    if(Students.isEmpty())
                        System.out.println("No students found !");
                    else
                        for(String s : Students)
                            System.out.println(s);
                }
                case 3-> {
                    System.out.println(" Enter student name to remove :");
                    String name = sc.nextLine();
                    if (Students.contains(name)) {
                        Students.remove(name);
                        System.out.println("Student " + name + " removed successfully");
                    }
                        else
                        System.out.println("Student not found!");
                }
                case 4 -> {
                    System.out.println("Enter student name to search");
                    String name = sc.nextLine();
                    if(Students.contains(name))
                        System.out.println(" Student found!");
                    else
                        System.out.println(" Student not found!");
                }
                case 5 ->
                    System.out.println("Exiting program");

                default -> System.out.println("Invalid choice, please enter the valid choice");

            }


       }while (choice!= 5);

   }
}
