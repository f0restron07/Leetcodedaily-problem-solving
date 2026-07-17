class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx=0;
        for(int x:nums){
            mx=Math.max(mx,x);
        }
        long[] cnt=new long[mx+1];
        for(int x:nums){
            cnt[x]++;
        }
        long[] div=new long[mx+1];
        for(int g=1;g<=mx;g++){
            long c=0;
            for(int m=g;m<=mx;m+=g){
                c+=cnt[m];
            }
            div[g]=c;
        }
        long[] exact=new long[mx+1];
        for(int g=mx;g>=1;g--){
            long p=div[g]*(div[g]-1)/2;
            for(int m=2*g;m<=mx;m+=g){
                p-=exact[m];
            }
            exact[g]=p;
        }
        long[] pre=new long[mx+1];
        pre[0]=0;
        for(int g=1;g<=mx;g++){
            pre[g]=pre[g-1]+exact[g];
        }
        int q=queries.length;
        int[] ans=new int[q];
        for(int i=0;i<q;i++){
            long idx=queries[i];
            int lo=1;
            int hi=mx;
            while(lo<hi){
                int mid=(lo+hi)/2;
                if(pre[mid]>idx){
                    hi=mid;
                }else{
                    lo=mid+1;
                }
            }
            ans[i]=lo;
        }
        return ans;
    }
}