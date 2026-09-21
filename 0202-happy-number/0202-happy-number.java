class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        do{
            slow=sq(slow);
            fast=sq(sq(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }return false;
    }
    private int sq(int n){
        int rem=0,ans=0;
        while(n>0){
            rem=n%10;
            ans=ans+(rem*rem);
            n/=10;
        }
        return ans;
    }
}