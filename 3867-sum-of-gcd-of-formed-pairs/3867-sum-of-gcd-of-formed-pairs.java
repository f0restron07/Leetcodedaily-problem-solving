class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] p=new int[n];
        int mx=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            p[i]=gcd(nums[i],mx);
        }
        Arrays.sort(p);
        long s=0;
        int a=0;
        int b=n-1;
        while(a<b){
            s+=gcd(p[a],p[b]);
            a++;
            b--;
        }
        return s;
    }
    int gcd(int a,int b){
        while(b!=0){
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}