import Classes.BrickRuler;
import Classes.CellDistributor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // reading matrix/wall dimension
    // n-rows , m-columns , numBricks-quantity of bricks
        int[] input =  Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1], numBricks = (n*m)/2;
    // check both dimensions are even and under 100
        if(n%2!=0 || m%2!=0 || n>=100 || m>=100){
            System.out.println("-1 Invalid input!");
            return;        }
    // matrix/wall initialise
        int[][] firstWall = new int[n][m];
    // fill the matrix/build first wall
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    // check if input line has exactly m numbers
            if(temp.length!=m){
                System.out.println("-1 Invalid input!");
                return;
            }
            firstWall[i] = temp;
            for(int t: temp){
                all.add(t);
            }
        }
    // close the reader to free the resource as we don't need it anymore
        reader.close();
    // check if ani number exist exactly twice end bricks are numbered correctly (from 1 to number of bricks)
        for (int i = 1; i <= numBricks ; i++) {
            if(Collections.frequency(all,i)!=2){
                System.out.println("-1\n Invalid input!");
                return;
            }
        }
    // initialise second layer of the wall and classes
        int[][] secondLayer = new int[n][m];
        BrickRuler ruler = new BrickRuler(firstWall);
        CellDistributor distributor = new CellDistributor(n,m);
        int[] emptyCell;   // first empty sell
        String direction;
    //  End of input data, initialization and validating   !!!

    // getting first empty sell from lower left corner going from bottom to up and from left to the right
        for (int i = 1; i <= numBricks ; i++) {
            emptyCell = distributor.found(secondLayer);
            direction = ruler.showDirection( emptyCell[0],emptyCell[1]);
            switch (direction) {
                case "right":
                    secondLayer[emptyCell[0]][emptyCell[1]] = i;
                    secondLayer[emptyCell[0]][emptyCell[1] + 1] = i;
                    break;
                case "up":
                    secondLayer[emptyCell[0]][emptyCell[1]] = i;
                    secondLayer[emptyCell[0] - 1][emptyCell[1]] = i;
                    break;
                case "fails":
                    System.out.println("-1\n It is not possible to build second layer !!!");
                    break;
                default:
                    System.out.println("Something went wrong !!!");
                    break;
            }

        }


        System.out.println(Arrays.deepToString(secondLayer)
                .replace("], [","\n").replaceAll("[\\[\\],]",""));
    }
}