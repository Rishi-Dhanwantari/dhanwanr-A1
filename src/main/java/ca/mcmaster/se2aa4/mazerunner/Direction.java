package ca.mcmaster.se2aa4.mazerunner;

enum Direction {
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    private int row_direction;
    private int col_direction;

    Direction(int row_direction, int col_direction){
        this.row_direction = row_direction;
        this.col_direction = col_direction;
    }

    public int[] getCurrentDirection(){
        return new int[]{row_direction, col_direction};
    }

    public Direction turnRight(){
        return values()[(this.ordinal() + 1) % 4];
    }

    public Direction turnLeft(){
        return values()[(this.ordinal() + 3) % 4];
    }
}