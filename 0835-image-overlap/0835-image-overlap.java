class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        List<int[]> a=new ArrayList<>();
        List<int[]> b=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1){
                    a.add(new int[]{i,j});
                }
                if(img2[i][j]==1){
                    b.add(new int[]{i,j});
                }
            }
        }
        HashMap<Integer,Integer> cnt=new HashMap<>();
        int best=0;
        for(int[] p:a){
            for(int[] q:b){
                int dr=q[0]-p[0];
                int dc=q[1]-p[1];
                int key=(dr+30)*61+(dc+30);
                int c=cnt.merge(key,1,Integer::sum);
                best=Math.max(best,c);
            }
        }
        return best;
    }
}