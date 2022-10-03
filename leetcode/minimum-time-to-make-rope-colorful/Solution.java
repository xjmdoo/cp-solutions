class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        char currentColor = ' ';
        int sum = 0;
        PriorityQueue<Integer> currentTime = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == currentColor) {
                currentTime.add(neededTime[i]);
            } else {
                sum += calcTimeTakes(currentTime);
                currentTime.clear();
                currentColor = chars[i];
                currentTime.add(neededTime[i]);
            }
        }

        return sum + calcTimeTakes(currentTime);
    }

    public int calcTimeTakes(PriorityQueue<Integer> time) {
        int sum = 0;
        while(time.size() > 1) {
            sum += time.poll();
        }
        return sum;
    }
}

