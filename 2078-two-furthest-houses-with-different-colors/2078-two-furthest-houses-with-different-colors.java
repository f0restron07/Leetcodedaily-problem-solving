class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int a=0;
        for(int i=n-1;i>=0;i--){
            if(colors[i]!=colors[0]){
                a=i;
                break;
            }
        }
        int b=0;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){
                b=n-1-i;
                break;
            }
        }
        return Math.max(a,b);
    }
}