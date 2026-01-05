class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        long res = 0;
        int nCount = 0;
        int maxNeg = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res += Math.abs(matrix[i][j]);
                maxNeg = Math.min(maxNeg,Math.abs(matrix[i][j]));
                if(matrix[i][j]<=0){
                    nCount++;
                }
            }
        }
        return nCount%2==0?res:res-(2*maxNeg);
    }
}