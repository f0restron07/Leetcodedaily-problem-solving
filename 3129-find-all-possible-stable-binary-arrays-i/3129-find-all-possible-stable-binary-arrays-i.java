class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long M=1_000_000_007;
        long[][][] d=new long[zero+1][one+1][2];
        for(int i=1;i<=Math.min(zero,limit);i++) d[i][0][0]=1;
        for(int j=1;j<=Math.min(one,limit);j++) d[0][j][1]=1;
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                d[i][j][0]=(d[i-1][j][0]+d[i-1][j][1])%M;
                if(i>limit) d[i][j][0]=(d[i][j][0]-d[i-1-limit][j][1]+M)%M;
                d[i][j][1]=(d[i][j-1][0]+d[i][j-1][1])%M;
                if(j>limit) d[i][j][1]=(d[i][j][1]-d[i][j-1-limit][0]+M)%M;
            }
        }
        return (int)((d[zero][one][0]+d[zero][one][1])%M);
    }
}