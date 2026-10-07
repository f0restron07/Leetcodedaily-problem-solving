class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found=false;
        while(!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                String cur=queue.poll();
                if(isValid(cur)){
                    res.add(cur);
                    found=true;
                }
                if(found){
                    continue;
                }
                for(int j=0;j<cur.length();j++){
                    char c=cur.charAt(j);
                    if(c!='('&&c!=')'){
                        continue;
                    }
                    String next=cur.substring(0,j)+cur.substring(j+1);
                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            if(found){
                break;
            }
        }
        return res;
    }
    boolean isValid(String s){
        int open=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                open++;
            }else if(c==')'){
                open--;
                if(open<0){
                    return false;
                }
            }
        }
        return open==0;
    }
}