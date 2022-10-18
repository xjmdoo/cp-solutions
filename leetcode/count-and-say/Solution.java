class Solution {
    public String countAndSay(int n) {
        String current = "1";
        while (n > 1) {
            n--;
            current = calc(current);
        }

        return current;
    }

    public String calc(String nums) {
        char current = 'a';
        boolean first = true;
        int count = 1;
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < nums.length(); i++) {
            current = nums.charAt(i);
            if (i == nums.length() - 1) {
                res.append(count);
                res.append(current);
            } else if (current == nums.charAt(i + 1)) {
                count++;
                continue;
            } else {
                res.append(count);
                res.append(current);
                count = 1;
            }
        }
        return res.toString();

    }
}

