package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main{
    public static boolean found = false;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int value;
        while(true) {
            System.out.println("What do you want to do? \n" +
                    "1)Search\n" +
                    "2)Insert\n" +
                    "3)Delete\n" +
                    "4)Exit");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter number to Search:\n");
                value = sc.nextInt();
                bt.search(bt.root, value);
                found = false;
            } else if (choice == 2) {
                System.out.println("Enter number to Insert:\n");
                value = sc.nextInt();
                bt.insert(bt.root, value);
                System.out.print("root " + bt.root.value + "\n");  //PROBLEM
            } else if (choice == 3) {
                System.out.println("Enter number to Delete:\n");
                value = sc.nextInt();
                bt.delete(bt.root, value);
            }
            else {
                exit(0);
            }

        }
    }
}