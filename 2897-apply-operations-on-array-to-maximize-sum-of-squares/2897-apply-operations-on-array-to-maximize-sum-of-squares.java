class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD=1000000007;
        int[] bitCount=new int[30];
        for(int x:nums){
            for(int b=0;b<30;b++){
                if((x&(1<<b))!=0){
                    bitCount[b]++;
                }
            }
        }
        long ans=0;
        for(int i=0;i<k;i++){
            long val=0;
            for(int b=0;b<30;b++){
                if(bitCount[b]>0){
                    val|=(1L<<b);
                    bitCount[b]--;
                }
            }
            ans=(ans+val%MOD*(val%MOD))%MOD;
        }
        return (int)ans;
    }
}