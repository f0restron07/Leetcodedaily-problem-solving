import java.util.*;
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs={{0,-1},{0,1},{-1,0},{1,0}};
        int[] opp={1,0,3,2};

        boolean[][] op=new boolean[7][4];
        op[1][0]=op[1][1]=true;
        op[2][2]=op[2][3]=true;
        op[3][0]=op[3][3]=true;
        op[4][1]=op[4][3]=true;
        op[5][0]=op[5][2]=true;
        op[6][1]=op[6][2]=true;

        boolean[][] vis=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0], c=cur[1];
            if(r==m-1&&c==n-1) return true;
            for(int d=0;d<4;d++){
                if(!op[grid[r][c]][d]) continue;
                int nr=r+dirs[d][0], nc=c+dirs[d][1];
                if(nr<0||nr>=m||nc<0||nc>=n||vis[nr][nc]) continue;
                if(!op[grid[nr][nc]][opp[d]]) continue;
                vis[nr][nc]=true;
                q.offer(new int[]{nr,nc});
            }
        }
        return false;
    }
}