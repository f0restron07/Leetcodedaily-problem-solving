class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] a=new int[2*limit+2];
        int h=n/2;
        for(int i=0;i<h;i++){
            int b=nums[i];
            int c=nums[n-1-i];
            int d=Math.min(b,c);
            int e=Math.max(b,c);
            a[1+d]+=1;
            a[limit+e+1]-=1;
            a[b+c]+=1;
            a[b+c+1]-=1;
        }
        int f=0;
        int g=2*h;
        for(int i=2;i<=2*limit;i++){
            f+=a[i];
            int j=2*h-f;
            if(j<g){
                g=j;
            }
        }
        return g;
    }
}