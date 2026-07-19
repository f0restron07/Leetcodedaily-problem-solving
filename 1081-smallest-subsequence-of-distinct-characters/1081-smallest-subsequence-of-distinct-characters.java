class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        int[] a=new int[26];
        for(int i=0;i<n;i++){
            a[s.charAt(i)-'a']=i;
        }
        boolean[] b=new boolean[26];
        StringBuilder c=new StringBuilder();
        for(int i=0;i<n;i++){
            char d=s.charAt(i);
            int e=d-'a';
            if(b[e]){
                continue;
            }
            while(c.length()>0&&c.charAt(c.length()-1)>d&&a[c.charAt(c.length()-1)-'a']>i){
                b[c.charAt(c.length()-1)-'a']=false;
                c.deleteCharAt(c.length()-1);
            }
            c.append(d);
            b[e]=true;
        }
        return c.toString();
    }
}