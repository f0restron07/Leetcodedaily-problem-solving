class Solution{
    public char[][] rotateTheBox(char[][] a){
        int b=a.length;
        int c=a[0].length;
        for(int d=0;d<b;d++){
            int e=c-1;
            for(int f=c-1;f>=0;f--){
                if(a[d][f]=='*'){
                    e=f-1;
                }else if(a[d][f]=='#'){
                    a[d][f]='.';
                    a[d][e]='#';
                    e--;
                }
            }
        }
        char[][] g=new char[c][b];
        for(int d=0;d<b;d++){
            for(int f=0;f<c;f++){
                g[f][b-1-d]=a[d][f];
            }
        }
        return g;
    }
}