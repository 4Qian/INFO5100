package edu.northeastern.qian.question1;

public class Psychiatrist {

    public void examine(Moody moody) {
        System.out.println("How are you feeling today?");
        moody.queryMood();
    }

    public void observe(Moody moody) {
        moody.expressFeelings();
        System.out.println("Observation: " + moody.toString());
    }

    public String toString() {
        return "Subject laughs a lot";
    }
}
