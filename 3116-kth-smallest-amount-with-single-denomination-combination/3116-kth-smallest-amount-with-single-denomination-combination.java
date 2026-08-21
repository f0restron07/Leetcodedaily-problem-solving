class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n=coins.length;
        long lo=1;
        long hi=(long)25*k;
        while(lo<hi){
            long mid=(lo+hi)/2;
            if(count(coins,mid)>=k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    long count(int[] coins,long x){
        int n=coins.length;
        long total=0;
        for(int mask=1;mask<(1<<n);mask++){
            long lcm=1;
            int bits=0;
            boolean ok=true;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    bits++;
                    lcm=lcmVal(lcm,coins[i]);
                    if(lcm>x){
                        ok=false;
                        break;
                    }
                }
            }
            if(!ok){
                continue;
            }
            long c=x/lcm;
            if(bits%2==1){
                total+=c;
            }else{
                total-=c;
            }
        }
        return total;
    }
    long lcmVal(long a,long b){
        return a/gcd(a,b)*b;
    }
    long gcd(long a,long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}