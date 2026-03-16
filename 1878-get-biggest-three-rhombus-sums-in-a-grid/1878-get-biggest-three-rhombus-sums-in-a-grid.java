class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        TreeSet<Integer>s=new TreeSet<>(Collections.reverseOrder());
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                s.add(grid[r][c]);
                for(int k=1;r-k>=0&&r+k<m&&c-k>=0&&c+k<n;k++){
                    int t=0;
                    for(int i=0;i<k;i++){
                        t+=grid[r-k+i][c+i];
                        t+=grid[r+i][c+k-i];
                        t+=grid[r+k-i][c-i];
                        t+=grid[r-i][c-k+i];
                    }
                    s.add(t);
                }
            }
        }
        int[]a=new int[Math.min(3,s.size())];
        int i=0;
        for(int v:s){a[i++]=v;if(i==3)break;}
        return a;
    }
}