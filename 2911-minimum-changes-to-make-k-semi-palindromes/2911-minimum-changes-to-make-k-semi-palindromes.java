class Solution {
    public int minimumChanges(String s, int k) {
        int n=s.length();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                a[i][j]=cost(s,i,j);
            }
        }
        int[][] b=new int[k+1][n+1];
        for(int[] c:b){
            Arrays.fill(c,1000);
        }
        b[0][0]=0;
        for(int i=1;i<=k;i++){
            for(int j=2*i;j<=n;j++){
                b[i][j]=best(a,b[i-1],j);
            }
        }
        return b[k][n];
    }
    int cost(String s,int d,int e){
        int n=e-d+1,f=n;
        for(int i=1;i<n;i++){
            if(n%i==0){
                int g=0;
                for(int j=0;j<n;j++){
                    int h=j%i+(n/i-1-j/i)*i;
                    if(j<h&&s.charAt(d+j)!=s.charAt(d+h)){g++;}
                }
                f=Math.min(f,g);
            }
        }
        return f;
    }
    int best(int[][] a,int[] b,int c){
        int d=1000;
        for(int i=0;i<=c-2;i++){
            d=Math.min(d,b[i]+a[i][c-1]);
        }
        return d;
    }
}