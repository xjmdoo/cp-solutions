class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mirror = new HashMap<>();
        Map<String, Integer> oneLetters = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (allSame(words[i])) {
                oneLetters.put(words[i], oneLetters.getOrDefault(words[i], 0) + 1);
            } else {
                mirror.put(words[i], mirror.getOrDefault(words[i], 0) + 1);
            }
        }

        int maxLength = 0;
        boolean hasMiddle = false;

        for (String key : oneLetters.keySet()) {
            Integer val = oneLetters.get(key);
            if (val % 2 == 0) {
                maxLength += val * 2;
            } else {
                maxLength += (val - 1) * 2;
                if (!hasMiddle) {
                    maxLength += 2;
                    hasMiddle = true;
                }
            }
        }

        Map<String, Integer> copy = new HashMap<>(mirror);

        for (String key : mirror.keySet()) {
            String rev = reverse(key);
            if (copy.containsKey(key) && copy.containsKey(rev)) {
                Integer val = copy.get(key);
                Integer reverseVal = copy.get(rev);
                int min = Math.min(val, reverseVal);
                maxLength += min * 4;
                copy.remove(key);
                copy.remove(rev);
            }
        }

        return maxLength;
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }

    private boolean allSame(String str) {
        char[] chars = str.toCharArray();
        char start = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (start != chars[i]) return false;
        }

        return true;
    }
}

