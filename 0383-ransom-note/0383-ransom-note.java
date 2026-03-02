class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();
        HashMap<Character, Integer> ranMap = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            magMap.put(c, magMap.getOrDefault(c, 0) + 1);
        }
         for(char c : ransomNote.toCharArray()) {
            ranMap.put(c, ranMap.getOrDefault(c, 0) + 1);
        }
        for(char c : ranMap.keySet()) {
            int needed = ranMap.get(c);
            int available = magMap.getOrDefault(c, 0);
            
            if(available < needed) {
                return false;
            }
        }
        
        return true;
    }
}