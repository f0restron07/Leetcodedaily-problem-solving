class Solution {
    public int[][] minAbsDiff(int[][] g, int k) {
        int m=g.length,n=g[0].length;
        int[][] r=new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                int[] a=new int[k*k];
                int p=0;
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        a[p++]=g[x][y];
                    }
                }
                Arrays.sort(a);
                int mn=Integer.MAX_VALUE;
                for(int t=1;t<k*k;t++){
                    if(a[t]!=a[t-1]){
                        mn=Math.min(mn,a[t]-a[t-1]);
                    }
                }
                r[i][j]=(mn==Integer.MAX_VALUE)?0:mn;
            }
        }
        return r;
    }
}