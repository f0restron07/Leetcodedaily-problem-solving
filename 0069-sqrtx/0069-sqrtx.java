class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1)return x;
        int low=1;
        int high=x/2;
        int ans=0;
        while(low<=high){
            int mid = low + (high - low) / 2;
            long sq = (long) mid * mid;
            if(x==sq){
                return mid;
            }
            if(sq<x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}