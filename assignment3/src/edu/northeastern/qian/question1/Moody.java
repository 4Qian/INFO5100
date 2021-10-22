package edu.northeastern.qian.question1;

public abstract class Moody {

    public abstract String getMood();

    public abstract void expressFeelings();

    public void queryMood() {
        System.out.println(getMood());
    }
}
