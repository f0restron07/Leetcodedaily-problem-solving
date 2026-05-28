class Solution{
 int[][] a;
 int[] b;
 String[] c;
 public int[] stringIndices(String[] wordsContainer,String[] wordsQuery){
  c=wordsContainer;
  int m=1;
  for(String s:c)m+=s.length();
  a=new int[m][26];
  b=new int[m];
  for(int[] r:a)Arrays.fill(r,0);
  Arrays.fill(b,-1);
  int p=1;
  for(int i=0;i<c.length;i++){
   int u=0;
   b[0]=d(b[0],i);
   String s=c[i];
   for(int j=s.length()-1;j>=0;j--){
    int k=s.charAt(j)-'a';
    if(a[u][k]==0){
     a[u][k]=p++;
    }
    u=a[u][k];
    b[u]=d(b[u],i);
   }
  }
  int[] r=new int[wordsQuery.length];
  for(int i=0;i<wordsQuery.length;i++){
   int u=0,e=b[0];
   String s=wordsQuery[i];
   for(int j=s.length()-1;j>=0;j--){
    int k=s.charAt(j)-'a';
    if(a[u][k]==0){
     break;
    }
    u=a[u][k];
    e=b[u];
   }
   r[i]=e;
  }
  return r;
 }
 int d(int e,int i){
  if(e==-1){
   return i;
  }
  if(c[i].length()<c[e].length()){
   return i;
  }
  return e;
 }
}