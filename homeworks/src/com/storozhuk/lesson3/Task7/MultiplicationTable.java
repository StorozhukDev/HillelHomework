package com.storozhuk.lesson3.Task7;

import java.util.Scanner;

/**
 * Tasks 7
 *
 * Printing multiplication table of X
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        System.out.print("Enter X:");
        x = sc.nextInt();

        for(int i = 1; i <= 10; i++) {
            System.out.println(x + " * " + i + " = " + (x*i));
        }
    }
}
