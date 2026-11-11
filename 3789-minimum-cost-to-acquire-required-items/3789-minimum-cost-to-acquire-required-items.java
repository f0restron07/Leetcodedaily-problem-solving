class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a=Long.MAX_VALUE;
        long[] b={0,Math.min(need1,need2),Math.max(need1,need2)};
        for(int i=0;i<3;i++){
            a=Math.min(a,b[i]*costBoth+Math.max(0,need1-b[i])*cost1+Math.max(0,need2-b[i])*cost2);
        }
        return a;
    }
    
}