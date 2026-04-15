class Solution {
    public int closestTarget(String[] w, String t, int s) {
        int n=w.length;
        int r=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(w[i].equals(t)){
                int a=(i-s+n)%n;
                int b=(s-i+n)%n;
                r=Math.min(r,Math.min(a,b));
            }
        }
        return r==Integer.MAX_VALUE?-1:r;
    }
}