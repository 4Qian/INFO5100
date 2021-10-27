package edu.northeastern.qian.question2;

public class Main {
    public static void main(String[] args) {
        Printer p1;
        // refers to the only object of Database
        p1= Printer.getInstance();

        p1.getConnection();
    }
}
