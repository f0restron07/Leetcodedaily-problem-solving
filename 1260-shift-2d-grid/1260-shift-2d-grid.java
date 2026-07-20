class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int t=m*n;
        k%=t;
        int[] a=new int[t];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int p=i*n+j;
                a[(p+k)%t]=grid[i][j];
            }
        }
        List<List<Integer>> b=new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> c=new ArrayList<>();
            for(int j=0;j<n;j++){
                c.add(a[i*n+j]);
            }
            b.add(c);
        }
        return b;
    }
}