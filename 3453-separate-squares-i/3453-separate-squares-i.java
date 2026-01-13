class Solution{
    public double separateSquares(int[][]s){
        double t=0;
        long a=Long.MAX_VALUE,b=Long.MIN_VALUE;
        for(int[]i:s){
            long y=i[1],l=i[2];
            t+=(double)l*l;
            a=Math.min(a,y);
            b=Math.max(b,y+l);
        }
        double h=t/2,x=a,z=b;
        for(int k=0;k<60;k++){
            double m=(x+z)/2;
            if(f(s,m)<h)x=m;
            else z=m;
        }
        return x;
    }
    double f(int[][]s,double m){
        double r=0;
        for(int[]i:s){
            double y=i[1],l=i[2];
            if(m<=y)continue;
            else if(m>=y+l)r+=l*l;
            else r+=l*(m-y);
        }
        return r;
    }
}
