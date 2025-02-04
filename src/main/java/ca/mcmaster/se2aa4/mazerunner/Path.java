package ca.mcmaster.se2aa4.mazerunner;

/**
 * Path class to represent the path that will be generated
 * at the end of the maze run.
 */

class Path {
    private String path;

    //constructor method for Path.
    public Path(){
        this.path = "";
    }

    //method that appends a movement (i.e. F, R, L) to the path String.
    public void addMovement(String movement){
        this.path = this.path+movement;
    }

    //accessor method for the path String.
    public String getCanonicalPath(){
        return new String(this.path);
    }

    //method that converts the path String into factorized form and returns the resulting String.
    public String getFactorizedPath(){
        StringBuilder factorizedPath = new StringBuilder();
        int sameCount = 1;

        for (int i = 1; i < this.path.length(); i++){
            if (this.path.charAt(i) == this.path.charAt(i-1)){
                sameCount ++;
            } else{
                if (sameCount != 1){
                    factorizedPath.append(""+sameCount+"");
                }
                
                factorizedPath.append(this.path.charAt(i-1));

                sameCount = 1;
            }
        }

        if (sameCount != 1){
            factorizedPath.append(""+sameCount+"");
        }
        factorizedPath.append(this.path.charAt(this.path.length()-1));

        return factorizedPath.toString();
    }
}