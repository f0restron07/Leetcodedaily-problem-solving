class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] d=new int[m][n];
        for(int[] r:d){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        d[0][0]=grid.get(0).get(0);
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.addFirst(new int[]{0,0});
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int[] c=q.pollFirst();
            int x=c[0];
            int y=c[1];
            for(int k=0;k<4;k++){
                int a=x+dx[k];
                int b=y+dy[k];
                if(a<0||a>=m||b<0||b>=n){
                    continue;
                }
                int w=grid.get(a).get(b);
                if(d[x][y]+w<d[a][b]){
                    d[a][b]=d[x][y]+w;
                    if(w==0){
                        q.addFirst(new int[]{a,b});
                    }else{
                        q.addLast(new int[]{a,b});
                    }
                }
            }
        }
        return d[m-1][n-1]<health;
    }
}