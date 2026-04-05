class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') ud += 1;
            else if (ch == 'D') ud -= 1;
            else if (ch == 'L') lr += 1;
            else if (ch == 'R') lr -= 1;
        }

        return ud == 0 && lr == 0;
    }
}