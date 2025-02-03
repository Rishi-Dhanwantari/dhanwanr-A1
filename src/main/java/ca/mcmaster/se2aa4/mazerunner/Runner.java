package ca.mcmaster.se2aa4.mazerunner;

class Runner {
    private int[] runnerPosition;
    private Direction runnerDirection;
    private Path path;

    public Runner(int[] entryPosition, Direction startingDirection){
        this.runnerPosition = entryPosition;
        this.runnerDirection = startingDirection;
        this.path = new Path();
    }

    public void traverseMaze(Maze maze){
        int[] exitPoint = maze.getExitPoint();

        while (!(this.runnerPosition[0] == exitPoint[0] && this.runnerPosition[1] == exitPoint[1])){
            Direction right = this.runnerDirection.turnRight();
            int[] currentRight = right.getCurrentDirection();
            
            if (maze.isPass(this.runnerPosition[0] + currentRight[0], this.runnerPosition[1] + currentRight[1])){
                runnerTurnRight();
                moveForward();

            } else if (maze.isPass(this.runnerPosition[0] + this.runnerDirection.getCurrentDirection()[0], this.runnerPosition[1] + this.runnerDirection.getCurrentDirection()[1])){
                moveForward();

            } else{
                runnerTurnLeft();
            }
        }
    }

    private void moveForward(){
        int[] currentDirection = runnerDirection.getCurrentDirection();
        this.runnerPosition[0] += currentDirection[0];
        this.runnerPosition[1] += currentDirection[1];
        this.path.addMovement("F");
    }

    private void runnerTurnRight(){
        this.runnerDirection = this.runnerDirection.turnRight();
        this.path.addMovement("R");
    }

    private void runnerTurnLeft(){
        this.runnerDirection = this.runnerDirection.turnLeft();
        this.path.addMovement("L");
    }

    public int[] getRunnerPosition(){
        return this.runnerPosition;
    }

    public Path getPath(){
        return this.path;
    }
}