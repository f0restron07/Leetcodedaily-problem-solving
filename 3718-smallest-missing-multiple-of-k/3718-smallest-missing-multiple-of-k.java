class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s=new HashSet<>();
        for(int x:nums){
            s.add(x);
        }
        int m=k;
        while(s.contains(m)){
            m+=k;
        }
        return m;
    }
}