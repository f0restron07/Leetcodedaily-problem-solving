class Solution {
    public int numberOfSubstrings(String s) {
        int[] a=new int[3];
        int b=0,i=0,j,n=s.length();
        for(j=0;j<n;j++){
            a[s.charAt(j)-'a']++;
            while(a[0]>0&&a[1]>0&&a[2]>0){
                a[s.charAt(i)-'a']--;
                i++;
            }
            b+=i;
        }
        return b;
    }
}