class Solution{
    public int[][]reverseSubmatrix(int[][]g,int x,int y,int k){
        for(int i=0;i<k/2;i++){
            for(int j=y;j<y+k;j++){
                int t=g[x+i][j];
                g[x+i][j]=g[x+k-1-i][j];
                g[x+k-1-i][j]=t;
            }
        }
        return g;
    }
}