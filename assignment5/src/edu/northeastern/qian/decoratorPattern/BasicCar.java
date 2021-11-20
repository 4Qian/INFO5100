package edu.northeastern.qian.decoratorPattern;

public class BasicCar implements Car {

    public BasicCar () {
    }

    @Override
    public void assemble () {
        System.out.print("Basic Car.");
    }
}
