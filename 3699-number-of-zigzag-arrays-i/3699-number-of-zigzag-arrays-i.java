class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int M=1000000007;
        int m=r-l+1;
        long[] up=new long[m+2];
        long[] down=new long[m+2];
        for(int j=1;j<=m;j++){
            up[j]=1;
            down[j]=1;
        }
        for(int i=2;i<=n;i++){
            long[] nu=new long[m+2];
            long[] nd=new long[m+2];
            long pre=0;
            for(int j=1;j<=m;j++){
                nu[j]=pre;
                pre=(pre+down[j])%M;
            }
            long suf=0;
            for(int j=m;j>=1;j--){
                nd[j]=suf;
                suf=(suf+up[j])%M;
            }
            up=nu;
            down=nd;
        }
        long ans=0;
        for(int j=1;j<=m;j++){
            ans=(ans+up[j]+down[j])%M;
        }
        return (int)ans;
    }
}