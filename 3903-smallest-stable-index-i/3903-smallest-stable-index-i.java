class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] a=new int[n];
        int[] b=new int[n];
        a[0]=nums[0];
        for(int i=1;i<n;i++){
            a[i]=Math.max(a[i-1],nums[i]);
        }
        b[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            b[i]=Math.min(b[i+1],nums[i]);
        }
        for(int i=0;i<n;i++){
            if((long)a[i]-b[i]<=k){
                return i;
            }
        }
        return -1;
    }
}