class Solution {
    public int climbStairs(int n,int[] costs){
        long a=Long.MAX_VALUE/2,b=a,c=0;
        for(int i=0;i<n;i++){
            long d=costs[i]+Math.min(c+1,Math.min(b+4,a+9));
            a=b;b=c;c=d;
        }
        return (int)c;
    }
}