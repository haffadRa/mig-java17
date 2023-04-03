package fr;

public class PatternMatchingForInstanceOf {

    public static void main(String[] args) {
        printStringLength("Hello");
        printStringLength(1);
    }

    private static void printStringLength(Object obj) {
        if (obj instanceof String s) {
            System.out.println("Length of string is " + s.length());
        } else {
            System.out.println("Object is not a string");
        }
    }
}
