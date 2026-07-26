class Solution {
    public int maximumProduct(int[] nums) {
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        int d=Integer.MAX_VALUE;
        int e=Integer.MAX_VALUE;
        for(int x:nums){
            if(x>a){
                c=b;
                b=a;
                a=x;
            }else if(x>b){
                c=b;
                b=x;
            }else if(x>c){
                c=x;
            }
            if(x<d){
                e=d;
                d=x;
            }else if(x<e){
                e=x;
            }
        }
        return Math.max(a*b*c,a*d*e);
    }
}