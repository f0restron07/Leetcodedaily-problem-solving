class Solution {
    public int minElement(int[] a) {
        int b=Integer.MAX_VALUE;
        for(int c:a){
            int d=0;
            while(c>0){
                d+=c%10;
                c/=10;
            }
            if(d<b) b=d;
        }
        return b;
    }
}