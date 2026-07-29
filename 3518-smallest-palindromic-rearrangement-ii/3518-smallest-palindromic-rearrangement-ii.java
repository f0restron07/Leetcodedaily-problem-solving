class Solution {
    public String smallestPalindrome(String s, long k) {
        int[] f=new int[26];
        for(int i=0;i<s.length();i++){
            f[s.charAt(i)-'a']++;
        }
        char mid=0;
        int[] h=new int[26];
        int half=0;
        for(int i=0;i<26;i++){
            if(f[i]%2==1){
                mid=(char)('a'+i);
            }
            h[i]=f[i]/2;
            half+=h[i];
        }
        long total=multinom(h,half);
        if(k>total){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for(int pos=0;pos<half;pos++){
            for(int c=0;c<26;c++){
                if(h[c]==0){
                    continue;
                }
                h[c]--;
                long cnt=multinom(h,half-pos-1);
                if(k<=cnt){
                    sb.append((char)('a'+c));
                    break;
                }
                k-=cnt;
                h[c]++;
            }
        }
        String left=sb.toString();
        String right=new StringBuilder(left).reverse().toString();
        String m=(mid!=0)?String.valueOf(mid):"";
        return left+m+right;
    }
    long multinom(int[] cnt,int n){
        long res=1;
        int used=0;
        for(int c=0;c<26;c++){
            for(int j=1;j<=cnt[c];j++){
                used++;
                res=res*used/j;
                if(res>2000000000L){
                    return res;
                }
            }
        }
        return res;
    }
}