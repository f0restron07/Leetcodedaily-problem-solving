class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        java.util.HashSet<Long> s=new java.util.HashSet<>();
        for(int[] p:obstacles){
            s.add(((long)p[0])*100000L+p[1]);
        }
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int d=0,x=0,y=0,r=0;
        for(int c:commands){
            if(c==-2){
                d=(d+3)&3;
            }else if(c==-1){
                d=(d+1)&3;
            }else{
                for(int i=0;i<c;i++){
                    int nx=x+dx[d];
                    int ny=y+dy[d];
                    if(s.contains(((long)nx)*100000L+ny)){
                        break;
                    }
                    x=nx;
                    y=ny;
                    int t=x*x+y*y;
                    if(t>r)r=t;
                }
            }
        }
        return r;
    }
}