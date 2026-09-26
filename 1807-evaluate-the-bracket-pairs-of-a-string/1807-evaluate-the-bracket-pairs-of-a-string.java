class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String> k:knowledge){
            map.put(k.get(0),k.get(1));
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=s.length();
        while(i<n){
            char c=s.charAt(i);
            if(c=='('){
                int j=i+1;
                StringBuilder key=new StringBuilder();
                while(s.charAt(j)!=')'){
                    key.append(s.charAt(j));
                    j++;
                }
                sb.append(map.getOrDefault(key.toString(),"?"));
                i=j+1;
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}