package edu.northeastern.qian.question2;

public class Printer {
    private static Printer instance;

    private Printer() {}

    private static Object object = new Object();

    public static Printer getInstance(){
        if (instance == null) {//double locking
            synchronized (object){
                if (instance == null) {
                    instance = new Printer();
                }
            }
        }
        return instance;
    }

    public static void getConnection() {
        System.out.println("Your Printer is working");
    }
}
