package Classes;

/** class will be initialised with first wall array and calculated from it
 * number of columns. It has only one method that returns to as the right direction
 * to place the next brick.It follows desired logic of wall building : from bottom
 * to up and from left to the right */

public class BrickRuler {

    private final int column;
    private final int[][] matrix;

    public BrickRuler(int[][] matrix) {
        this.matrix = matrix;
        this.column = matrix[0].length;
    }

    public String showDirection( int n, int m){
        if(n%2!=0){

                if (m < column - 1 && this.matrix[n][m] != this.matrix[n][m + 1]) {
                    return "right";
                } else if (n > 0 && this.matrix[n][m] != this.matrix[n - 1][m]) {
                    return "up";
                } else {
                    return "false";
                }

        }else{
            return "right";
        }
    }

}
