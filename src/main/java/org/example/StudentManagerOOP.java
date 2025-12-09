package org.example;
import java.util.Scanner;
import  java.util.ArrayList;
import java.util.List;



public class StudentManagerOOP {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
    private static int nextId =1;

    public static void main(String[] args){

               int choice ;

      do{
          System.out.println("\n====== Student Manager (OOP) ======");
          System.out.println("1. Add Student");
          System.out.println("2. View All Students");
          System.out.println("3. Search Student by Name");
          System.out.println("4. Update Student by ID");
          System.out.println("5. Remove Student by ID");
          System.out.println("6. Exit");
          System.out.print("Enter your choice: ");

          while (!scanner.hasNextInt()) {
              System.out.print("Please enter a valid number: ");
              scanner.next(); // discard invalid input
          }

        choice = scanner.nextInt();
          scanner.nextLine();// consume next line

          switch (choice) {
              case 1 -> addStudent();
              case 2 -> viewStudents();
              case 3 -> searchStudent();
              case 4 -> updateStudent();
              case 5 -> removeStudent();
              case 6 -> System.out.println("Exiting Student Manager... 👋");
              default -> System.out.println("Invalid choice, please try again.");
          }

      }while(choice!=6);
    }




// -----------------Menu Operations-----------

    private static void addStudent() {

        System.out.println("Enter name :");
        String name = scanner.nextLine();

        System.out.println("Enter age : ");
        int age = readInt();

        System.out.println("Enter Grade:");
        String grade = scanner.nextLine();

        Student student = new Student(nextId++, name, age,grade);
        students.add(student);

        System.out.println("Student added - "+student);

    }

    private static void viewStudents() {
        System.out.println("\n---------All Students-----------");
        if(students.isEmpty()){
            System.out.println("No Student found. ");
        }
        for(Student s : students){
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.println("Enter name to search :");
        String name = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for(Student s : students){
            if(s.getName().toLowerCase().contains(name)){
                if(!found){
                    System.out.println("\n ------Search results-------");
                }
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    private static void updateStudent(){
        System.out.println("Enter student ID to update :");
        int id = readInt();

        Student student= findById(id);

        if (student == null) {
            System.out.println("No student found with ID " + id);
            return;
        }

        System.out.println("Current details: " + student);
        System.out.println("Press Enter to skip updating a field.");

        System.out.print("New name (or Enter to keep '" + student.getName() + "'): ");
        String newName = scanner.nextLine();
        if (!newName.isBlank()) {
            student.setName(newName);
        }

        System.out.print("New age (or -1 to keep " + student.getAge() + "): ");
        int newAge = readIntAllowSkip(student.getAge());

        System.out.print("New grade (or Enter to keep '" + student.getGrade() + "'): ");
        String newGrade = scanner.nextLine();
        if (!newGrade.isBlank()) {
            student.setGrade(newGrade);
        }

        student.setAge(newAge);

        System.out.println("✅ Student updated: " + student);
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = readInt();

        Student student = findById(id);
        if (student == null) {
            System.out.println("No student found with ID " + id);
            return;
        }

        students.remove(student);
        System.out.println("🗑️ Removed student: " + student);
    }

    // ---- Helper methods ----

    private static Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // discard invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    private static int readIntAllowSkip(int currentValue) {
        while (!scanner.hasNextInt()) {
            String token = scanner.next();
            // Allow user to just press Enter (handled outside) so if token is not number, ask again
            System.out.print("Please enter a number, or -1 to keep current: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (value == -1) {
            return currentValue;
        }
        return value;

    }
}
