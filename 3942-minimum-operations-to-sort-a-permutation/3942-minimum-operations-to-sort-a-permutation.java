class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        boolean ri=true;
        boolean rr=true;
        for(int i=0;i<n;i++){
            int next=(i+1)%n;
            if(((nums[next]-nums[i])%n+n)%n!=1){
                ri=false;
            }
            if(((nums[i]-nums[next])%n+n)%n!=1){
                rr=false;
            }
        }
        if(!ri&&!rr){
            return -1;
        }
        int pos0=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                pos0=i;
                break;
            }
        }
        int posRev=n-1-pos0;
        int best=Integer.MAX_VALUE;
        if(ri){
            best=Math.min(best,pos0);
            best=Math.min(best,1+((posRev+1)%n)+1);
        }
        if(rr){
            best=Math.min(best,((pos0+1)%n)+1);
            best=Math.min(best,1+posRev);
        }
        return best;
    }
}