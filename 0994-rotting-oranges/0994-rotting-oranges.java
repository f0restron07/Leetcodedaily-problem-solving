class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int[][]dir={{-1,0},{1,0},{0,1},{0,-1}};
        int count=0;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.add(new int[]{i,j});
                if(grid[i][j]==1)fresh++;
            }
        }
        while(!q.isEmpty()){
            boolean rottted=false;
            int size=q.size();
            for(int k=0;k<size;k++){
                int[]cell=q.poll();
                for(int[]d:dir){
                    int r=cell[0]+d[0];
                    int c=cell[1]+d[1];
                
                if(r>=0&&c>=0&&r<m&&c<n&&grid[r][c]==1){
                    grid[r][c]=2;
                    fresh--;
                    rottted=true;
                    q.add(new int[]{r,c});
                }}
            }
            if(rottted)count++;
        }
        return fresh==0?count:-1;
    }
}