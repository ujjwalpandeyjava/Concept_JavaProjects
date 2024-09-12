package org.example;

import org.example.utlilities.ReadUtils;

public class Main {
    public static void main(String[] args) {
        // To use other module here, we have to add that module dependency here
        System.out.println("From module Core: " + new ReadUtils().generateRandomPassword(7));
    }
}