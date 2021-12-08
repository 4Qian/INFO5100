package edu.northeastern.qian.question1;
import java.util.*;

public class Main {
    private static void testSortStudents(List<Student> students, Comparator<Student> comparator) {
        students.sort(comparator);
        for (Student s : students) {
            System.out.println(s.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // === 1. Prepare the test data
        Student lisa = new Student(123, "Lisa", 3.4,
                new Date (105,1,10));
        Student eva = new Student(127,"Eva", 3.5,
                new Date(100,2,5));
        Student daniel = new Student(111,"Daniel", 3.6,
                new Date(107,3,1));
        Student elen = new Student(119,"Elen", 3.7,
                new Date(101,4,7));
        Student andy = new Student(120, "Andy",3.8,
                new Date(109,5,9));
        List<Student> students = Arrays.asList(lisa, eva, daniel, elen, andy);

        // ==== 2. Sort students in three ways

        // **** Sort students in ascending order by 'name'****
        System.out.println("1. Student objects sorted in ascending order by 'name': ");
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        testSortStudents(students, nameComparator);
        System.out.println("Excepted: Andy, Daniel, Elen, Eva, Lisa");
        System.out.println("=========================================================================");
        System.out.println();

        // **** Sort students in descending order by 'gpa'****
        System.out.println("2. Student objects sorted in descending order by 'gpa': ");
        Comparator<Student> gpaComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getGpa() < s2.getGpa()) {
                    return 1;
                }else if (s1.getGpa() > s2.getGpa()) {
                    return -1;
                }else{
                    return 0;
                }
            }
        };

        testSortStudents(students, gpaComparator);
        System.out.println("Excepted: Andy, Elen, Daniel, Eva, Lisa");
        System.out.println("=========================================================================");
        System.out.println();

        // **** Sort students in ascending order by 'dateOfBirth'****
        System.out.println("3. Student objects sorted in ascending order by 'dateOfBirth': ");
        Comparator<Student> dateOfBirthComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
            }
        };
        testSortStudents(students, dateOfBirthComparator);
        System.out.println("Expected: Eva, Elen, Lisa, Daniel, Andy");
    }
}
