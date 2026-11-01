class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>>adj=new ArrayList<>();
        int n=isConnected.length;
        boolean[]b=new boolean[n];
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1&&i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            
            if(!b[i]){
                count++;
                dfs(i,adj,b);
            }
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>>a,boolean[]b){
        b[node]=true;
        for(int i:a.get(node)){
            if(!b[i]){
                dfs(i,a,b);
            }
        }
    }

    
}