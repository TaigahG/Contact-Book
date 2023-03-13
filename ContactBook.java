package com.JavaCal;
import java.util.*;

public class ContactBook {


    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        LList lst = new LList<>();
        boolean run = true;

        String opt;

        do{
            System.out.println();
            System.out.format("****************************************************************************************************************%n");
            System.out.format("(A)dd  \n(D)elete \n(E)mail Search \n(P)rint List \n(S)earch \n(Q)uit");
            System.out.format("****************************************************************************************************************%n");
            System.out.format("Please Enter a command: ");
            opt = sc.nextLine().toUpperCase();

            switch (opt){
                case "A":
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter email: ");
                    String email = sc.nextLine();

                    System.out.println("Enter phone number: ");
                    String PhoneNum = sc.nextLine();

                    lst.add(name, email, PhoneNum);
                    break;

                case "D":
                    System.out.println("Enter the index number you want to delete: ");
                    int index = sc.nextInt();
                    lst.Delete(index);
                    break;

                case "E":
                    System.out.println("Enter email you want to search: ");
                    String e = sc.nextLine();

                    lst.EmailSearch(e);
                    break;

                case "P":
                    System.out.println(lst.toString());
                    break;

                case "S":
                    System.out.println("Enter name you want to search: ");
                    String nm = sc.nextLine();

                    lst.NameSearch(nm);
                    break;

                case "Q":
                    run = false;
                    break;

            }
        }while (run);
    }
}
