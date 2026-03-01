import java.util.HashSet;
import java.util.List;

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> startingCities = new HashSet<>();
        
        // Step 1: store all cityA
        for(List<String> path : paths) {
            startingCities.add(path.get(0));
        }
        
        // Step 2: find cityB not in startingCities
        for(List<String> path : paths) {
            String destination = path.get(1);
            if(!startingCities.contains(destination)) {
                return destination;
            }
        }
        
        return "";
    }
}