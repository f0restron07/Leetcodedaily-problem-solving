class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int k=0;k<4;k++){
            if(eq(mat,target))return true;
            mat=rot(mat,n);
            
        }
        return false;
    }
    boolean eq(int[][]a,int[][]b){
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++)
                 if(a[i][j]!=b[i][j])return false;
        return true;
    }
    int[][]rot(int[][]a,int n){
        int[][]r=new int[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            r[j][n+~i]=a[i][j];
        return r;
    }
}