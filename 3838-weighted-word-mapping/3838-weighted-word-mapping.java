class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder b=new StringBuilder();
        for(String w:words){
            int s=0;
            for(int i=0;i<w.length();i++){
                s+=weights[w.charAt(i)-'a'];
            }
            int r=s%26;
            b.append((char)('z'-r));
        }
        return b.toString();
    }
}