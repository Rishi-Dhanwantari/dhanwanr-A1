package ca.mcmaster.se2aa4.mazerunner;

/**
 * Direction enum to represent the compass directions.
 */

enum Direction {
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    private int row_direction;
    private int col_direction;

    //constructor method for Direction.
    Direction(int row_direction, int col_direction){
        this.row_direction = row_direction;
        this.col_direction = col_direction;
    }

    //accessor method that returns the current row and column directions in an array.
    public int[] getCurrentDirection(){
        return new int[]{row_direction, col_direction};
    }

    //method that rotates Direction right once.
    public Direction turnRight(){
        return values()[(this.ordinal() + 1) % 4];
    }

    //method that rotates Direction left once.
    public Direction turnLeft(){
        return values()[(this.ordinal() + 3) % 4];
    }
}