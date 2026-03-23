class Solution {
    public int maxProductPath(int[][] g) {
        int m=g.length,n=g[0].length;
        long[][]mx=new long[m][n],mn=new long[m][n];
        mx[0][0]=mn[0][0]=g[0][0];
        for(int j=1;j<n;j++){mx[0][j]=mn[0][j]=mx[0][j-1]*g[0][j];}
        for(int i=1;i<m;i++){mx[i][0]=mn[i][0]=mx[i-1][0]*g[i][0];}
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long v=g[i][j],a=mx[i-1][j]*v,b=mn[i-1][j]*v,c=mx[i][j-1]*v,d=mn[i][j-1]*v;
                mx[i][j]=Math.max(Math.max(a,b),Math.max(c,d));
                mn[i][j]=Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        return mx[m-1][n-1]<0?-1:(int)(mx[m-1][n-1]%1000000007);
    }
}