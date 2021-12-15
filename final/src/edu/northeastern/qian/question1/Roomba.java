package edu.northeastern.qian.question1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Roomba implements iRobot{

    private final int[][] room;
    private final int M;
    private final int N;
    private int directionIndex;
    private int x;
    private int y;

    private static final Map<Direction, int[]> directionMappings = Map.of(
            Direction.DOWN, new int[]{1, 0},
            Direction.UP, new int[]{-1, 0},
            Direction.LEFT, new int[]{0, -1},
            Direction.RIGHT, new int[]{0, 1});

    private static final int NUMBER_OF_DIRECTIONS = 4;
    private static final List<Direction> directionList =
            Arrays.asList(Direction.DOWN, Direction.RIGHT, Direction.UP, Direction.LEFT);

    public Roomba(int[][] room) {
        this.room = room;
        M = room.length;
        N = room[0].length;
        directionIndex = 0; // Direction.DOWN;
        x = 0;
        y = 0;
    }

    private boolean isOutOfBoundary(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }

    @Override
    public boolean move() {
        int[] dir = directionMappings.get(directionList.get(directionIndex));
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (isOutOfBoundary(newX, newY) || room[newX][newY] == -1) {
            return false;
        }
        x = newX;
        y = newY;
        return true;
    }

    @Override
    public void turnLeft() {
        directionIndex = (directionIndex + 1) % NUMBER_OF_DIRECTIONS;
    }

    @Override
    public void turnRight() {
        directionIndex = (directionIndex + NUMBER_OF_DIRECTIONS - 1) % NUMBER_OF_DIRECTIONS;
    }

    @Override
    public void clean() {
        room[x][y] = 1;
    }
}