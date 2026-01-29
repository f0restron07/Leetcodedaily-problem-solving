class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ArrayList<ArrayList<Pair>>list=new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<original.length;i++){
            int node=original[i]-'a';
            int adjnode=changed[i]-'a';
            int dist=cost[i];
            list.get(node).add(new Pair(adjnode, dist));
        }
        long minCost=0;
        int [][]matrix=new int[26][26];
        floyd(list,matrix);
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                int sourcenode=source.charAt(i)-'a';
                int destnode=target.charAt(i)-'a';
                long costi=matrix[sourcenode][destnode];
                if(costi==Integer.MAX_VALUE)return -1;
                minCost+=costi;
            }
        }
        return minCost;
    }
    public void floyd(ArrayList<ArrayList<Pair>>list,int [][]matrix){
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                matrix[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<26;i++){
            for(Pair p:list.get(i)){
                int j=p.node;
                int dist=p.dist;

                matrix[i][j]=Math.min(matrix[i][j],dist);
            }
        }
        for(int via=0;via<list.size();via++){
            for(int i=0;i<list.size();i++){
                for(int j=0;j<list.size();j++){
                    if(via==i || via==j)continue;
                    if (matrix[i][via] != Integer.MAX_VALUE &&
                            matrix[via][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j],matrix[i][via] + matrix[via][j]);
                    }
                }
            }
        }
    }
}
class Pair{
    int node;
    int dist;

    Pair(int n,int d){
        node=n;
        dist=d;
    }
}