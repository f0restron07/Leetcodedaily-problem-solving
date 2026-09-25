class Solution {
    String s;
    int pos;
    public List<String> braceExpansionII(String expression) {
        s=expression;
        pos=0;
        return new ArrayList<>(parseUnion());
    }
    TreeSet<String> parseUnion(){
        TreeSet<String> result=parseConcat();
        while(pos<s.length()&&s.charAt(pos)==','){
            pos++;
            result.addAll(parseConcat());
        }
        return result;
    }
    TreeSet<String> parseConcat(){
        TreeSet<String> result=new TreeSet<>();
        result.add("");
        while(pos<s.length()&&s.charAt(pos)!=','&&s.charAt(pos)!='}'){
            TreeSet<String> factor=parseFactor();
            TreeSet<String> next=new TreeSet<>();
            for(String a:result){
                for(String b:factor){
                    next.add(a+b);
                }
            }
            result=next;
        }
        return result;
    }
    TreeSet<String> parseFactor(){
        if(s.charAt(pos)=='{'){
            pos++;
            TreeSet<String> r=parseUnion();
            pos++;
            return r;
        }
        TreeSet<String> r=new TreeSet<>();
        r.add(String.valueOf(s.charAt(pos)));
        pos++;
        return r;
    }
}