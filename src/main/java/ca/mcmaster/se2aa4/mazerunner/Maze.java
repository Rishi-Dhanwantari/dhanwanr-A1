package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

class Maze {
    private char[][] mazeArray;
    private int[] entryPoint;
    private int[] exitPoint;

    public Maze(String mazeFilePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFilePath))) {
            this.mazeArray = reader.lines().map(String::toCharArray).toArray(char[][]::new);
        } catch (Exception e) {
            throw new RuntimeException("Error loading maze: " + e.getMessage());
        }
        
        findEntryExit();
    }

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

    public char[][] getMazeArray(){
        return this.mazeArray;
    }

    public int[] getEntryPoint(){
        return this.entryPoint;
    }

    public int[] getExitPoint(){
        return this.exitPoint;
    }
}
