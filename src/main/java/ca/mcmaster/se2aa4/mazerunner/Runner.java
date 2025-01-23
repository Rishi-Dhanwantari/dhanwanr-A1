package ca.mcmaster.se2aa4.mazerunner;

public class Runner {
    private int[] runnerPosition;

    public Runner(int[] entryPosition){
        runnerPosition = entryPosition;
    }

    public int[] getRunnerPosition(){
        return runnerPosition;
    }
}
