package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Maze class to represent the maze text file as an actual maze.
 * Determines where it is possible to pass, along with the entry and exit points.
 */

class Maze {
    private char[][] mazeArray;
    private int[] entryPoint;
    private int[] exitPoint;

    //constructor method for Maze
    public Maze(String mazeFilePath){

        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFilePath))) {
            this.mazeArray = reader.lines().map(String::toCharArray).toArray(char[][]::new);

        } catch (Exception e) {
            throw new RuntimeException("Error loading maze: " + e.getMessage());
        }
        
        findEntryExit();
    }

    //method that locates the entry and exit points in the maze file and assigns them.
    private void findEntryExit(){
        for (int i = 0; i < mazeArray.length; i++){
            if (mazeArray[i][0] == ' '){
                this.entryPoint = new int[]{i, 0};
            }

            if (mazeArray[i][mazeArray[0].length - 1] == ' '){
                this.exitPoint = new int[]{i, mazeArray[0].length - 1};
            }
        }
    }

    //method that determines if a certain point in the maze is a wall.
    public boolean isWall(int x, int y) {
        return mazeArray[x][y] == '#';
    }

    //method that determines if a certain point in the maze is a pass.
    public boolean isPass(int x, int y) {
        return mazeArray[x][y] == ' ';
    }

    //accessor method for the entry point.
    public int[] getEntryPoint(){
        return new int[]{this.entryPoint[0], this.entryPoint[1]};
    }

    //accessor method for the exit point.
    public int[] getExitPoint(){
        return new int[]{this.exitPoint[0], this.exitPoint[1]};
    }
}