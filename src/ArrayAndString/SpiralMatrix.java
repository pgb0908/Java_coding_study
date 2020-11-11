package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3,},
                          {4, 5, 6,},
                          {7, 8, 9}};
        System.out.println(solve(matrix));
    }

    private static List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix.length-1;

        int n = 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            // right
            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
                System.out.print(matrix[rowStart][i] + " ");
            }
            rowStart++;
            print(rowEnd, colEnd, rowStart, colStart);



            // down
            for(int i = rowStart; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
                System.out.print(matrix[i][colEnd] + " ");
            }
            colEnd--;
            print(rowEnd, colEnd, rowStart, colStart);



            // left
            if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    result.add(matrix[rowEnd][i]);
                    System.out.print(matrix[rowEnd][i] + " ");
                }
            }
            rowEnd--;
            print(rowEnd, colEnd, rowStart, colStart);


            // up
            if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; i--){
                    result.add(matrix[i][colStart]);
                    System.out.print(matrix[i][colStart] + " ");
                }
            }
            colStart++;
            print(rowEnd, colEnd, rowStart, colStart);


            System.out.println(n + " 회전 끝 ");
            n++;

        }

        return result;
    }

    private static void print(int rowEnd, int colEnd, int rowStart, int colStart) {
        System.out.println();
        System.out.println("rowEnd : " + rowEnd + " ");
        System.out.println("colEnd : " + colEnd);
        System.out.println("rowStart : " + rowStart);
        System.out.println("colStart : " + colStart);
    }
}
