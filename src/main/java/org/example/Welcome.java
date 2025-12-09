package org.example;
import java.util.Scanner;

public class Welcome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name :\n");
        String name = sc.nextLine();

        System.out.println("Enter your goal for becoming a developer :");
        String goal = sc.nextLine();

        System.out.println(" Welcome  "+name+" You are on a track to become a great developer  ");
        System.out.println("Goal : "+goal);
    }


}