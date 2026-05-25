class Solution {
    public boolean canReach(String a,int b,int c){
        int n=a.length();
        if(a.charAt(n-1)!='0') return false;
        boolean[] d=new boolean[n];
        d[0]=true;
        int e=0;
        for(int i=1;i<n;i++){
            if(i>=b&&d[i-b]) e++;
            if(i>c&&d[i-c-1]) e--;
            d[i]=e>0&&a.charAt(i)=='0';
        }
        return d[n-1];
    }
}