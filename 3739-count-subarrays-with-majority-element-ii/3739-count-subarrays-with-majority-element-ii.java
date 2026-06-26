class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int size=2*n+2;
        int[] bit=new int[size+1];
        long ans=0;
        int pre=0;
        int idx=pre+n+1;
        update(bit,idx,size);
        for(int j=0;j<n;j++){
            pre+=(nums[j]==target)?1:-1;
            int cur=pre+n+1;
            ans+=query(bit,cur-1);
            update(bit,cur,size);
        }
        return ans;
    }
    void update(int[] bit,int i,int size){
        for(;i<=size;i+=i&(-i)){
            bit[i]++;
        }
    }
    int query(int[] bit,int i){
        int s=0;
        for(;i>0;i-=i&(-i)){
            s+=bit[i];
        }
        return s;
    }
}