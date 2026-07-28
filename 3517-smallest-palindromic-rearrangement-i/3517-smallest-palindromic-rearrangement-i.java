class Solution {
    public String smallestPalindrome(String s) {
        int[] f=new int[26];
        for(int i=0;i<s.length();i++){
            f[s.charAt(i)-'a']++;
        }
        StringBuilder h=new StringBuilder();
        char m=0;
        for(int i=0;i<26;i++){
            if(f[i]%2==1){
                m=(char)('a'+i);
            }
            for(int j=0;j<f[i]/2;j++){
                h.append((char)('a'+i));
            }
        }
        StringBuilder r=new StringBuilder(h);
        r.reverse();
        StringBuilder res=new StringBuilder(h);
        if(m!=0){
            res.append(m);
        }
        res.append(r);
        return res.toString();
    }
}