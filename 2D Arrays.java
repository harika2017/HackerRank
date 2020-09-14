//code for the interview preparation kit for 2d arrays
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int sum(int arr[][], int start_row,int start_col){
        int sum=0;
        for(int i=0;i<3;i++)
            sum+=arr[start_row][start_col+i];
        return sum;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
          int sum;
          int res=Integer.MIN_VALUE;
          int dr=1;
          for(int i=0;i<4;i++)
          {
              int dc=1;
              for(int j=0;j<4;j++){
                  sum=0;
                  sum+=sum(arr,i,j)+arr[dr][dc]+sum(arr,i+2,j);
                  res=Math.max(res,sum);
                  dc++;
              }
              dr++;
          }
            return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
