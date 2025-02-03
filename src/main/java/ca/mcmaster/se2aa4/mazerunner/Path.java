package ca.mcmaster.se2aa4.mazerunner;

class Path {
    private String path;

    public Path(int[] entryPosition){
        this.path = "";
    }

    public void addMovement(String movement){
        this.path = this.path+movement;
    }

    public String getCanonicalPath(){
        return this.path;
    }

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
