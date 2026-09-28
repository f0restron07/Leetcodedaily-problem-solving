class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int best=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                depth++;
                best=Math.max(best,depth);
            }else if(c==')'){
                depth--;
            }
        }
        return best;
    }
}