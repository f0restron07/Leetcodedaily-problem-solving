class Solution {
    public int minimumPushes(String word) {
        int[] f=new int[26];
        for(int i=0;i<word.length();i++){
            f[word.charAt(i)-'a']++;
        }
        Integer[] a=new Integer[26];
        for(int i=0;i<26;i++){
            a[i]=f[i];
        }
        Arrays.sort(a,Collections.reverseOrder());
        int c=0;
        for(int i=0;i<26;i++){
            if(a[i]==0){
                break;
            }
            c+=(i/8+1)*a[i];
        }
        return c;
    }
}