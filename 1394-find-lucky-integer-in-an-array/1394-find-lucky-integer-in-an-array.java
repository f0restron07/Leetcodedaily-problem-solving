class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int lucky=-1;
        for(int key:map.keySet()) {
    if(key == map.get(key)) {
        lucky = Math.max(lucky, key);
    }
}
return lucky;
    }
}