import java.util.Scanner;
import java.util.Random;

public class IsaacUIV1{
    public static void main(String[] args){
        //The code for Isaac's first version of the UI
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no of rows >>> ");
        int rows = input.nextInt();
        System.out.print("Enter columns >>> ");
        int columns = input.nextInt();
        
        System.out.println(displayMaze(rows, columns));
        input.close();
    }

    public static String displayMaze(int rows, int columns){
        Random generator = new Random();
        char[][] map = new char[rows][columns];
        char EMPTY = '.';
        char NON_EMPTY = '□';
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                 map[i][j] = EMPTY;
            }
        }
        int k = 0;
        while(k < ((columns*rows)/3)){
            int L = generator.nextInt(0,rows);
            int M = generator.nextInt(0, columns);
            map[L][M] = NON_EMPTY;
            k++;
            int R = generator.nextInt(0,4);
            if(R == 0 && L < rows - 1){map[L + 1][M] = NON_EMPTY; k++;} 
            else if(R == 1 && M < columns - 1){map[L][M + 1] = NON_EMPTY; k++;}
            else if(R == 2 && L > rows + 1){map[L - 1][M] = NON_EMPTY; k++;}
            else if(R == 3 && M > columns + 1){map[L][M - 1] = NON_EMPTY; k++;}
        }
        String output = "";
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                output = output + map[i][j] + " ";
            }
            output = output + "\n";
        }
        return output;
    }
}