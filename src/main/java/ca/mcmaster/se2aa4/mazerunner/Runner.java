package ca.mcmaster.se2aa4.mazerunner;

class Runner {
    private int[] runnerPosition;

    public Runner(int[] entryPosition){
        this.runnerPosition = entryPosition;
    }

    public int[] getRunnerPosition(){
        return this.runnerPosition;
    }
}
