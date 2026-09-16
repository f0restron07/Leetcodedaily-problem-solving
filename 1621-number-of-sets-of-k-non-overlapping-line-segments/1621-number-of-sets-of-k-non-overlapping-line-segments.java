class Solution {
    public int numberOfSets(int n, int k) {
        final long MOD=1000000007;
        int N=n+k-1;
        int r=2*k;
        long[] fact=new long[N+1];
        fact[0]=1;
        for(int i=1;i<=N;i++){
            fact[i]=fact[i-1]*i%MOD;
        }
        long num=fact[N];
        long den=fact[r]*fact[N-r]%MOD;
        return (int)(num*power(den,MOD-2,MOD)%MOD);
    }
    long power(long a,long b,long m){
        long res=1;
        a%=m;
        while(b>0){
            if((b&1)==1){
                res=res*a%m;
            }
            a=a*a%m;
            b>>=1;
        }
        return res;
    }
}