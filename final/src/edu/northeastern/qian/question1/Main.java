package edu.northeastern.qian.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] room = new int[][] {
                {0, 1, 0, 1},
                {-1, 0, 1, 0},
                {0, -1, 1, -1},
                {0, 0, 1, 1}
        };
        Roomba roomba = new Roomba(room);
        printRoom(room);
//        {
//            { 0, 1, 0, 1 },
//            { -1, 0, 1, 0 },
//            { 0, -1, 1, -1 },
//            { 0, 0, 1, 1 }
//        };

        roomba.clean();
        printRoom(room);
//        {
//            { 1, 1, 0, 1 },
//            { -1, 0, 1, 0 },
//            { 0, -1, 1, -1 },
//            { 0, 0, 1, 1 }
//        };
        boolean move1 = roomba.move(); // move down
        System.out.println(move1); // false

        roomba.turnRight(); // face left
        boolean move2 = roomba.move();
        System.out.println(move2); // false

        roomba.turnLeft(); // face down
        roomba.turnLeft(); // face right
        boolean move3 = roomba.move();
        System.out.println(move3); // true

        roomba.move(); // at (0, 2)
        roomba.clean();
        printRoom(room);
//        {
//            { 1, 1, 1, 1 },
//            { -1, 0, 1, 0 },
//            { 0, -1, 1, -1 },
//            { 0, 0, 1, 1 }
//        };
    }

    private static void printRoom(int[][] room) {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < room.length; i++) {
            String row = "    { " + Arrays.stream(room[i]).boxed().map(v -> String.valueOf(v)).collect(Collectors.joining(", ")) + " }";
            rows.add(row);
        }
        String roomStr = "{\n" + rows.stream().collect(Collectors.joining(",\n")) + "\n};";
        System.out.println(roomStr);
    }
}