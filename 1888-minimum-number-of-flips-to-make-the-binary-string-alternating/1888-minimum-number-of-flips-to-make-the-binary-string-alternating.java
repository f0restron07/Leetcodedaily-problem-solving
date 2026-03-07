class Solution {
    public int minFlips(String s) {
        int n=s.length();
        String t=s+s;
        int a=0;
        for(int i=0;i<n;i++){
            if((t.charAt(i)-'0')!=(i&1))a++;
        }
        int r=Math.min(a,n-a);
        for(int k=1;k<n;k++){
            if((t.charAt(k-1)-'0')!=((k-1)&1))a--;
            if((t.charAt(k+n-1)-'0')!=((k+n-1)&1))a++;
            int m=(k&1)==0?a:n-a;
            r=Math.min(r,Math.min(m,n-m));
        }
        return r;
    }
}