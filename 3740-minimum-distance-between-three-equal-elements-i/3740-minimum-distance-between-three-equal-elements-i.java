class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<=n;i++)g.add(new ArrayList<>());
        for(int i=0;i<n;i++)g.get(nums[i]).add(i);
        int a=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            List<Integer> l=g.get(i);
            for(int j=0;j+2<l.size();j++){
                a=Math.min(a,l.get(j+2)-l.get(j));
            }
        }
        return a==Integer.MAX_VALUE?-1:2*a;
    }
}