package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", "input", true, "Input file containing the maze");
        options.addOption("p", "path", true, "Path pattern to compare (canonical or factorized)");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException pe) {
            logger.error("Error parsing command line arguments", pe);
            return;
        }

        String inputMazeFile = cmd.getOptionValue("input");
        String userPath = cmd.getOptionValue("path");

        if (inputMazeFile == null) {
            logger.error("Please use the -i flag.");
            return;
        }

        try {
            logger.info("**** Reading the maze from file {}", inputMazeFile);
            BufferedReader reader = new BufferedReader(new FileReader(inputMazeFile));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.trace("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.trace("PASS ");
                    }
                }
                logger.trace(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.info("**** Computing path");
            logger.info("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");
        }

        Maze maze = new Maze(inputMazeFile);
        Runner runner = new Runner(maze.getEntryPoint(), Direction.EAST);

        runner.traverseMaze(maze);
        
        if (userPath == null) {
            logger.info("**** Computing path");
            logger.info("FACTORIZED PATH WEST TO EAST: "+runner.getPath().getFactorizedPath());
            logger.info("** End of MazeRunner");

        } else{
            if (runner.getPath().getCanonicalPath().equals(userPath) || runner.getPath().getFactorizedPath().equals(userPath)){
                logger.info(userPath+" is a valid path for this maze.");

            } else{
                logger.info(userPath+" is not a valid path for this maze.");
            }
        }
    }
}