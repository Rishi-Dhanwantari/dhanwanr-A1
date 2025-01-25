package ca.mcmaster.se2aa4.mazerunner;

class Runner {
    private int[] runnerPosition;
    private String path;

    public Runner(int[] entryPosition){
        this.runnerPosition = entryPosition;
        this.path = "";
    }

    public int[] getRunnerPosition(){
        return this.runnerPosition;
    }

    public void moveForward(){
        runnerPosition[1] ++;
        this.path = this.path+"F";
    }

    public String getPath(){
        return path;
    }
}
