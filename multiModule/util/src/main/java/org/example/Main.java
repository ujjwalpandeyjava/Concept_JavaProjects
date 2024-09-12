package org.example;

import org.example.utlilities.ReadUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Random password: " + new ReadUtils().generateRandomPassword(5));
        System.out.println("Random password: " + new ReadUtils().generateRandomPassword(10));
    }
}