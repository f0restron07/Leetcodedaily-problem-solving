class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int[] a=new int[2002];
        int b=0;
        for(int i:arr2){
            a[i+1001]++;
        }
        for(int i=1;i<2002;i++){
            a[i]+=a[i-1];
        }
        for(int i:arr1){
            if(a[Math.min(i+d+1001,2001)]-a[Math.max(i-d+1000,0)]==0){
                b++;
            }
        }
        return b;
    }
}