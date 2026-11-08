class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int[] a=new int[n],b=new int[grid[0].length];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<b.length;j++){
                a[i]+=grid[i][j];
                b[j]+=grid[i][j];
                c+=grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<b.length;j++){
                if(grid[i][j]==1&&a[i]==1&&b[j]==1){
                    c--;
                }
            }
        }
        return c;
    }
}