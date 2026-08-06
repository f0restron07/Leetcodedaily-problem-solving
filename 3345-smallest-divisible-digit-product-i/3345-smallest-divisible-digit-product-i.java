class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;;i++){
            int p=1;
            int x=i;
            while(x>0){
                p*=x%10;
                x/=10;
            }
            if(p%t==0){
                return i;
            }
        }
    }
}