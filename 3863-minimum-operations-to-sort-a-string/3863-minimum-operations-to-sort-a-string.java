class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char[] a=s.toCharArray();
        char[] t=a.clone();
        Arrays.sort(t);
        boolean sorted=true;
        for(int i=0;i<n;i++){
            if(a[i]!=t[i]){
                sorted=false;
                break;
            }
        }
        if(sorted){
            return 0;
        }
        if(n==2){
            return -1;
        }
        if(a[0]==t[0]||a[n-1]==t[n-1]){
            return 1;
        }
        boolean firstStrictMax=true;
        boolean lastStrictMin=true;
        for(int k=1;k<n;k++){
            if(a[0]<=a[k]){
                firstStrictMax=false;
                break;
            }
        }
        for(int k=0;k<n-1;k++){
            if(a[n-1]>=a[k]){
                lastStrictMin=false;
                break;
            }
        }
        if(firstStrictMax&&lastStrictMin){
            return 3;
        }
        return 2;
    }
}