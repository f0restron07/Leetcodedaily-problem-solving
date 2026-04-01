import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            res.add(healths[0]);
            return res;
        }

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = positions[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] newHea = new int[n];
        char[] newDir = new char[n];

        for (int i = 0; i < n; i++) {
            int idx = arr[i][1];
            newHea[i] = healths[idx];
            newDir[i] = directions.charAt(idx);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (newDir[i] == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHea[i] > 0) {
                    int top = stack.peek();

                    if (newHea[top] < newHea[i]) {
                        stack.pop();
                        newHea[i]--;
                        newHea[top] = 0;
                    } else if (newHea[top] > newHea[i]) {
                        newHea[top]--;
                        newHea[i] = 0;
                        break;
                    } else {
                        stack.pop();
                        newHea[top] = 0;
                        newHea[i] = 0;
                        break;
                    }
                }
            }
        }

        int[] finalHealth = new int[n];
        for (int i = 0; i < n; i++) {
            int originalIdx = arr[i][1];
            finalHealth[originalIdx] = newHea[i];
        }

        for (int i = 0; i < n; i++) {
            if (finalHealth[i] > 0) {
                res.add(finalHealth[i]);
            }
        }

        return res;
    }
}