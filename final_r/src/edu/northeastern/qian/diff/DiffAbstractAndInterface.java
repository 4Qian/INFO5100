package edu.northeastern.qian.diff;

public class DiffAbstractAndInterface {
    // https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
    // https://www.guru99.com/interface-vs-abstract-class-java.html
    /**
     *  Basically, a class can implement multiple interfaces whereas a class can extend only one abstract class.
     *  An interface only permits you to state functionality but not to implement it while an abstract class permits you to make functionality that subclasses can implement or override.
     *
     * 1. Implementation:
     * Interface cannot provide the implementation of an abstract class.
     * Abstract class can provide the implementation of an interface.
     *
     * 2. Method type:
     * Interface can have only abstract methods.
     * Abstract class can have abstract methods, non-abstract methods, default and static methods(From Java 8).
     *
     * 3. Variable type:
     * (1)Interface has only static and final variables.
     *    In addition to static and final variables, abstract classes can also have non-final and non-static variables.
     *
     * (2) Variables declared in a Java interface are by default final.
     *     Abstract class may contain non-final variables.
     *
     * 4.Inheritance vs Abstraction:
     * Using keyword “implements” to implement the Java interface.
     * Using keyword “extends” to extend an abstract class.
     *
     * 5. Multiple implementations:
     * Interface can only extend another Java interface.
     * Abstract class can extend another Java class and implement multiple Java interfaces.
     *
     * 6.Data Members' accessibility:
     * Members of the Java interface are public by default.
     * Java abstract class can have class members like private, protected.
     *
     * 7.Usage
     * Interfaces can define the peripheral abilities of a class.
     * Abstract class can define the identity of a class.
     *
     */


}
