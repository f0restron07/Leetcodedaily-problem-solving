class Solution{
    public boolean check(int[] a){
        int n=a.length;
        int b=0;
        for(int i=0;i<n;i++){
            if(a[i]>a[(i+1)%n]){
                b++;
            }
            if(b>1){
                return false;
            }
        }
        return true;
    }
}