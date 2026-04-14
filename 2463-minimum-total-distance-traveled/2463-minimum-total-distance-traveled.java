class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));
        
        int n=robot.size(),m=factory.length;
        long INF=(long)1e15;
        long[][] f=new long[n+1][m+1];
    
        for(int i=0;i<n;i++){
            f[i][m]=INF;
        }

        for(int j=m-1;j>=0;j--){
            for(int i=n;i>=0;i--){
                f[i][j]=f[i][j+1];
                
                long c=0;

                for(int k=1;k<=factory[j][1]&&i+k<=n;k++){
                    c+=Math.abs((long)robot.get(i+k-1)-factory[j][0]);
                    f[i][j]=Math.min(f[i][j],c+f[i+k][j+1]);
                }
            }
        }
        
        return f[0][0];
    }
}