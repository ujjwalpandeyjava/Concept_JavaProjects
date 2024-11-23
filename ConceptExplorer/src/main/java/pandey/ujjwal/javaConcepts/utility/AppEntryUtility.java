package pandey.ujjwal.javaConcepts.utility;
/*
 * These type of classes are used to create utilities like find displacement between to locations (lat, long)
 */

import pandey.ujjwal.javaConcepts.utility.generator.PasswordGenerator;

public class AppEntryUtility {

    static int sum(int a, int b) {
        return (a + b);
    }

    static int sub(int a, int b) {
        return (a - b);
    }

    public static void main(String args[]) {
        // System.out.println("00: " + args[0]);
        // System.out.println("01: " + args[1]);
        // System.out.println("02: " + args[2]);
        /* // Usage:
        int sum = MathUtils.add(5, 10);
        int diff = MathUtils.subtract(10, 5);
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(new MathUtils());    // throws error constructor not visible (Due to it is private)
        */
        System.out.println("Random password: " + PasswordGenerator.generateRandomPassword(5));
    }
}
