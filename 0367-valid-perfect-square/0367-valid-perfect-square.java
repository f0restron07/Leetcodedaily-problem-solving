class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0||num==1)return true;
        int low=1;
        int high=num/2;
        int ans=0;
        while(low<=high){
            int mid = low + (high - low) / 2;
            long sq = (long) mid * mid;
            if(num==sq){
                return true;
            }
            if(sq<num){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}