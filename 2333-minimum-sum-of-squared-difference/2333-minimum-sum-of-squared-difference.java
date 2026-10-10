class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        long k=(long)k1+k2;
        long[] d=new long[n];
        long total=0;
        for(int i=0;i<n;i++){
            d[i]=Math.abs(nums1[i]-nums2[i]);
            total+=d[i];
        }
        if(k>=total){
            return 0;
        }
        long lo=0;
        long hi=100000;
        while(lo<hi){
            long mid=(lo+hi)/2;
            long cost=0;
            for(long x:d){
                if(x>mid){
                    cost+=x-mid;
                }
            }
            if(cost<=k){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        long level=lo;
        long cost=0;
        for(long x:d){
            if(x>level){
                cost+=x-level;
            }
        }
        long rem=k-cost;
        long ans=0;
        for(long x:d){
            long v=Math.min(x,level);
            ans+=v*v;
        }
        for(long x:d){
            if(rem>0&&Math.min(x,level)==level&&level>0){
                ans-=level*level;
                ans+=(level-1)*(level-1);
                rem--;
            }
        }
        return ans;
    }
}