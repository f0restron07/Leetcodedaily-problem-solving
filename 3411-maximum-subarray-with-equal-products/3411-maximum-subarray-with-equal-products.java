class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length,a=0;
        for(int i=0;i<n;i++){
            int b=1,c=0,d=1;
            for(int j=i;j<n;j++){
                b*=nums[j];
                c=gcd(c,nums[j]);
                d=d/gcd(d,nums[j])*nums[j];
                if(b>c*d){
                    break;
                }
                if(b==c*d){
                    a=Math.max(a,j-i+1);
                }
            }
        }
        return a;
    }
    int gcd(int e,int f){
        return f==0?e:gcd(f,e%f);
    }
}