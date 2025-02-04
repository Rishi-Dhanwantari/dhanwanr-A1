package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.cli.*;

/**
 * Program that outputs a factorized west-to-east path for a maze text file with the -i flag.
 * Can also verify a path using the -p flag.
 */

public class Main {

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", "input", true, "Input file containing the maze");
        options.addOption("p", "path", true, "Path pattern to compare (canonical or factorized)");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException pe) {
            System.out.println("Error parsing command line arguments");
            return;
        }

        String inputMazeFile = cmd.getOptionValue("input");
        String userPath = cmd.getOptionValue("path");

        if (inputMazeFile == null) {
            System.out.println("Please use the -i flag.");
            return;
        }

        try {
            Maze maze = new Maze(inputMazeFile);
            Runner runner = new Runner(maze.getEntryPoint(), Direction.EAST);

            runner.traverseMaze(maze);
        
            if (userPath == null) {
                System.out.println("The factorized path for this maze, from west to east, is: "+runner.getPath().getFactorizedPath());

            } else{
                if (runner.getPath().getCanonicalPath().equals(userPath) || runner.getPath().getFactorizedPath().equals(userPath)){
                    System.out.println(userPath+" is a valid path for this maze.");

                } else{
                    System.out.println(userPath+" is not a valid path for this maze.");
                }
            }
            
        } catch(Exception e) {
            System.out.println("/!\\ An error has occured /!\\");
        }

        
    }
}