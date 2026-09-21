class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result=new long[k];
        long[] cnt=new long[k];
        for(int num:nums){
            int v=num%k;
            long[] next=new long[k];
            next[v]++;
            for(int r=0;r<k;r++){
                if(cnt[r]>0){
                    next[(r*v)%k]+=cnt[r];
                }
            }
            cnt=next;
            for(int r=0;r<k;r++){
                result[r]+=cnt[r];
            }
        }
        return result;
    }
}