class Solution {
    public boolean canAliceWin(int n) {
        int a=10;
        boolean b=false;
        while(n>=a){
            n-=a;
            a--;
            b=!b;
        }
        return b;
    }
}