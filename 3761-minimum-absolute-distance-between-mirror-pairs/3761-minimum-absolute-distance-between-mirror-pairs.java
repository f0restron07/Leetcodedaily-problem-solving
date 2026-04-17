class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            int v=nums[j];
            if(map.containsKey(v)){
                ans=Math.min(ans,j-map.get(v));
            }
            int r=reverse(v);
            map.put(r,j);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private int reverse(int x){
        int r=0;
        while(x>0){
            r=r*10+x%10;
            x/=10;
        }
        return r;
    }
}