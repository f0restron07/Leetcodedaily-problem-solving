class Solution{
    public boolean isGood(int[] nums){
        int n=nums.length-1;
        int[] c=new int[n+1];
        for(int x:nums){
            if(x<1||x>n){
                return false;
            }
            c[x]++;
        }
        if(c[n]!=2){
            return false;
        }
        for(int i=1;i<n;i++){
            if(c[i]!=1){
                return false;
            }
        }
        return true;
    }
}