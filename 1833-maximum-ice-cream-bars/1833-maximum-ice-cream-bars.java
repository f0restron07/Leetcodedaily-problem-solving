class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] f=new int[100001];
        for(int c:costs){
            f[c]++;
        }
        int b=0;
        for(int c=1;c<=100000;c++){
            if(f[c]==0){
                continue;
            }
            int can=coins/c;
            int take=Math.min(can,f[c]);
            if(take==0){
                break;
            }
            b+=take;
            coins-=take*c;
        }
        return b;
    }
}