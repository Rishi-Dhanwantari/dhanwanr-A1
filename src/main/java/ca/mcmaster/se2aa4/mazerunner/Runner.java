package ca.mcmaster.se2aa4.mazerunner;

/**
 * Runner class to represent the Maze Runner and traverse through the maze.
 */

class Runner {
    private int[] runnerPosition;
    private Direction runnerDirection;
    private Path path;

    //constructor method for Runner.
    public Runner(int[] entryPosition, Direction startingDirection){
        this.runnerPosition = entryPosition;
        this.runnerDirection = startingDirection;
        this.path = new Path();
    }

    //method that traverses the maze by following the right wall until the exit.
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

    //method that moves the Runner one position forward, whichever direction they are facing.
    private void moveForward(){
        int[] currentDirection = runnerDirection.getCurrentDirection();
        this.runnerPosition[0] += currentDirection[0];
        this.runnerPosition[1] += currentDirection[1];
        this.path.addMovement("F");
    }

    //method that adjusts the Runner's direction by turning it right once.
    private void runnerTurnRight(){
        this.runnerDirection = this.runnerDirection.turnRight();
        this.path.addMovement("R");
    }

    //method that adjusts the Runner's direction by turning it left once.
    private void runnerTurnLeft(){
        this.runnerDirection = this.runnerDirection.turnLeft();
        this.path.addMovement("L");
    }

    //accessor method for the Runner's path.
    public Path getPath(){
        Path copy = new Path();
        copy.addMovement(this.path.getCanonicalPath());
        return copy;
    }
}