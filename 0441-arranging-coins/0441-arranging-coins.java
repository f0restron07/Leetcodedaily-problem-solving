class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        for(int i=1;n>=i;i++){
 
                n=n-i;
                count++;
            
        }
        return count;
    }
}