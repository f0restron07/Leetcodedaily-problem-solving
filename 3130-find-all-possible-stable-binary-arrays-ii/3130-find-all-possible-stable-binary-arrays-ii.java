class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M=1_000_000_007;
        long[][] d0=new long[zero+1][one+1];
        long[][] d1=new long[zero+1][one+1];
        
        for(int i=1;i<=Math.min(zero,limit);i++)d0[i][0]=1;
        for(int j=1;j<=Math.min(one,limit);j++)d1[0][j]=1;
        
        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                d0[i][j]=(d0[i-1][j]+d1[i-1][j])%M;
                if(i>limit)d0[i][j]=(d0[i][j]-d1[i-1-limit][j]%M+M)%M;
                
                d1[i][j]=(d0[i][j-1]+d1[i][j-1])%M;
                if(j>limit)d1[i][j]=(d1[i][j]-d0[i][j-1-limit]%M+M)%M;
            }
        }
        return (int)((d0[zero][one]+d1[zero][one])%M);
    }
}