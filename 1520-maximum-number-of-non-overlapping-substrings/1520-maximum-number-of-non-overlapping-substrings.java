class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(first[c]==-1){
                first[c]=i;
            }
            last[c]=i;
        }
        List<int[]> intervals=new ArrayList<>();
        for(int c=0;c<26;c++){
            if(first[c]==-1){
                continue;
            }
            int l=first[c];
            int r=last[c];
            int i=l;
            boolean valid=true;
            while(i<=r){
                int ch=s.charAt(i)-'a';
                if(first[ch]<l){
                    valid=false;
                    break;
                }
                if(last[ch]>r){
                    r=last[ch];
                }
                i++;
            }
            if(valid){
                intervals.add(new int[]{l,r});
            }
        }
        intervals.sort((a,b)->a[1]-b[1]);
        List<String> res=new ArrayList<>();
        int prevEnd=-1;
        for(int[] iv:intervals){
            if(iv[0]>prevEnd){
                res.add(s.substring(iv[0],iv[1]+1));
                prevEnd=iv[1];
            }
        }
        return res;
    }
}