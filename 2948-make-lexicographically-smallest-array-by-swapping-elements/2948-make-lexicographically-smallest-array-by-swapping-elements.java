class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->nums[a]-nums[b]);
        int[] res=new int[n];
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n&&nums[idx[j]]-nums[idx[j-1]]<=limit){
                j++;
            }
            List<Integer> positions=new ArrayList<>();
            for(int k=i;k<j;k++){
                positions.add(idx[k]);
            }
            Collections.sort(positions);
            for(int k=0;k<positions.size();k++){
                res[positions.get(k)]=nums[idx[i+k]];
            }
            i=j;
        }
        return res;
    }
}