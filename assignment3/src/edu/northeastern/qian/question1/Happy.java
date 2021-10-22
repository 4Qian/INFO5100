package edu.northeastern.qian.question1;

public class Happy extends Moody {
    public String getMood() {
        return "I feel happy Today!";
    }

    public void expressFeelings() {
        System.out.println("heeehee….hahahah…HAHAHA!!");
    }

    @Override
    public String toString() {
        return "Subject laughs a lot";
    }
}
