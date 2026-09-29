class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==')'||grid[m-1][n-1]=='('){
            return false;
        }
        if((m+n-1)%2==1){
            return false;
        }
        Boolean[][][] memo=new Boolean[m][n][m+n+1];
        return dfs(grid,0,0,1,memo);
    }
    boolean dfs(char[][] grid,int i,int j,int bal,Boolean[][][] memo){
        if(bal<0){
            return false;
        }
        int m=grid.length;
        int n=grid[0].length;
        int rem=(m-1-i)+(n-1-j);
        if(bal>rem+1){
            return false;
        }
        if(i==m-1&&j==n-1){
            return bal==0;
        }
        if(memo[i][j][bal]!=null){
            return memo[i][j][bal];
        }
        boolean res=false;
        if(i+1<m){
            int nb=bal+(grid[i+1][j]=='('?1:-1);
            res=dfs(grid,i+1,j,nb,memo);
        }
        if(!res&&j+1<n){
            int nb=bal+(grid[i][j+1]=='('?1:-1);
            res=dfs(grid,i,j+1,nb,memo);
        }
        memo[i][j][bal]=res;
        return res;
    }
}