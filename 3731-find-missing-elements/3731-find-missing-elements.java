class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int lo=Integer.MAX_VALUE;
        int hi=Integer.MIN_VALUE;
        boolean[] seen=new boolean[101];
        for(int x:nums){
            seen[x]=true;
            lo=Math.min(lo,x);
            hi=Math.max(hi,x);
        }
        List<Integer> res=new ArrayList<>();
        for(int v=lo;v<=hi;v++){
            if(!seen[v]){
                res.add(v);
            }
        }
        return res;
    }
}