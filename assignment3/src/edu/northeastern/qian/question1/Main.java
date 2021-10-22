package edu.northeastern.qian.question1;

public class Main {

    public static void main(String[] args) {
        Psychiatrist p = new Psychiatrist();

        Happy happy = new Happy();
        p.examine(happy);
        System.out.println();
        p.observe(happy);
        System.out.println();

        Sad sad = new Sad();
        p.examine(sad);
        System.out.println();
        p.observe(sad);
    }
}
