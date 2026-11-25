class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length,a=1,b=n;
        while(a<b){
            int c=(a+b)/2;
            if(ok(nums,c)){
                b=c;
            }else{
                a=c+1;
            }
        }
        return a;
    }
    boolean ok(int[] nums,int c){
        long d=1000000007,e=1000000009,f=0,g=0,h=1,l=1;
        for(int i=0;i<c;i++){
            h=h*100003%d;
            l=l*100003%e;
        }
        HashMap<Long,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            f=(f*100003+nums[i])%d;
            g=(g*100003+nums[i])%e;
            if(i>=c){
                f=(f-nums[i-c]*h%d+d)%d;
                g=(g-nums[i-c]*l%e+e)%e;
            }
            if(i>=c-1){
                m.merge(f*e+g,1,Integer::sum);
            }
        }
        return m.containsValue(1);
    }
}