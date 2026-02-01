class Solution {
    public int minimumCost(int[] arr) {
        //Start with first element, which is our first value
        int sum = arr[0];

        int smallest = Integer.MAX_VALUE; 
        int secondSmallest = Integer.MAX_VALUE;
        // find the first and second smalleset value,
        //Already first value have takenx so we have to find from index 1.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) { 
                secondSmallest = smallest; 
                smallest = arr[i]; 
            } else if (arr[i] <= secondSmallest) {
                secondSmallest = arr[i]; 
            } 
        }
        return sum + smallest +  secondSmallest;
    }
}