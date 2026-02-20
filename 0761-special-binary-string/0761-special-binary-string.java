class Solution {
    public String makeLargestSpecial(String s) {
        int count=0,start=0;
        List<String> chunks = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            count += s.charAt(i)=='1' ? 1 : -1;
            if(count==0){
                String inner = s.substring(start+1,i);
                String processed = makeLargestSpecial(inner);
                chunks.add("1"+processed+"0");
                start = 1+i;
            }
        }

        Collections.sort(chunks,Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String chunk : chunks) {
            result.append(chunk);
        }
        return result.toString();
    }
}