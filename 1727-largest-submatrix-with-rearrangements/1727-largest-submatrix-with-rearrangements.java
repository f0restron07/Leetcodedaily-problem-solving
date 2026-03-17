import java.util.*;
class Solution {
    public int largestSubmatrix(int[][] matrix) {
       int r = matrix.length;
       int c = matrix[0].length;
       int max = 0;

       for(int i=0;i<r;i++){
        for(int j = 0;j<c;j++){
            if(matrix[i][j] == 1 && i > 0){
                matrix[i][j] += matrix[i-1][j];
            }
        }
        int[] arr = matrix[i].clone();
        Arrays.sort(arr);
        for(int k = 0;k<c;k++){
            max = Math.max(max,arr[k] * (c-k));
        }
       }
       return max;
    }
}