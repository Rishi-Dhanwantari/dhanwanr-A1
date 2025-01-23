package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Maze {
    private char[][] mazeArray;

    public Maze(String mazeFilePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFilePath))) {
            mazeArray = reader.lines().map(String::toCharArray).toArray(char[][]::new);
        } catch (Exception e) {
            throw new RuntimeException("Error loading maze: " + e.getMessage());
        }
    }

    public char[][] getMazeArray(){
        return mazeArray;
    }
}
