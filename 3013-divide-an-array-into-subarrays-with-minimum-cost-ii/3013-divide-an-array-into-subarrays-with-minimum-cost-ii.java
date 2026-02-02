class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        TreeSet<Integer> sel = new TreeSet<>((a,b) -> {
            if(nums[a]==nums[b]) return a-b;
            return nums[a]-nums[b];
        });
        TreeSet<Integer> rem = new TreeSet<>((a,b) -> {
            if(nums[a]==nums[b]) return a-b;
            return nums[a]-nums[b];
        });
        k=k-1;

        long cursum =0;
        long ans = Long.MAX_VALUE;
        int last = Math.min(dist+1,n-1);
        for(int i =1;i<=last;i++){
            cursum+=nums[i];
            sel.add(i);
        }
        while(sel.size()>k){
            int idx = sel.pollLast();
            cursum-=nums[idx];
            rem.add(idx);
        }
        ans = cursum;

        for (int r = dist + 2, l= 1; r < n; r++, l++) {
            rem.add(r);

            if(sel.contains(l)){
                sel.remove(l);
                cursum-=nums[l];

                int smallest = rem.pollFirst();
                sel.add(smallest);
                cursum +=nums[smallest];
            }else{
                rem.remove(l);

                if(!sel.isEmpty() && !rem.isEmpty() && nums[sel.last()]>nums[rem.first()]){
                    int big = sel.pollLast();
                    cursum -= nums[big];
                    rem.add(big);
                    int small = rem.pollFirst();
                    sel.add(small);
                    cursum +=nums[small];
                }
            }
            ans = Math.min(ans,cursum);
        }
        return nums[0]+ans;


    }
}