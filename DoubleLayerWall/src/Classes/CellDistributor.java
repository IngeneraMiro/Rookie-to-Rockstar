package Classes;

/**  this class will be initialised with first wall dimension
 *   and the only one method that will return to us first empty sell
 *   starting from lower left corner and going to right and then up
 *   row by row*/

public class CellDistributor {

    private final int row;
    private final int column;

    public CellDistributor(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int[] found(int[][] secondLayer){

        for (int i = row-1; i >=0 ; i--) {
            for (int j = 0; j < column; j++) {
                if(secondLayer[i][j]==0){
                    return  new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
