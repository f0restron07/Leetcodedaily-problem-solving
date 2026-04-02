class Solution{
    public int maximumAmount(int[][]a){
        int m=a.length;
        int n=a[0].length;
        int[][][]d=new int[m][n][3];
        int N=Integer.MIN_VALUE/2;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    d[i][j][k]=N;
                }
            }
        }
        d[0][0][0]=a[0][0];
        if(a[0][0]<0){
            d[0][0][1]=0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    continue;
                }
                for(int k=0;k<3;k++){
                    int p=N;
                    if(i>0){
                        p=Math.max(p,d[i-1][j][k]);
                    }
                    if(j>0){
                        p=Math.max(p,d[i][j-1][k]);
                    }
                    d[i][j][k]=Math.max(d[i][j][k],p+a[i][j]);
                    if(a[i][j]<0&&k>0){
                        int q=N;
                        if(i>0){
                            q=Math.max(q,d[i-1][j][k-1]);
                        }
                        if(j>0){
                            q=Math.max(q,d[i][j-1][k-1]);
                        }
                        d[i][j][k]=Math.max(d[i][j][k],q);
                    }
                }
            }
        }
        return Math.max(d[m-1][n-1][0],Math.max(d[m-1][n-1][1],d[m-1][n-1][2]));
    }
}