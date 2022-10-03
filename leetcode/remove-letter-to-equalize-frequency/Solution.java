class Solution {
    public boolean equalFrequency(String word) {
        if (word.length() == 1) return true;
        char[] chars = word.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            m.put(chars[i], m.getOrDefault(chars[i], 0) + 1);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer c : m.values()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        if (counts.size() == 2 && counts.containsValue(1)) {
            Integer[] arr = counts.keySet().toArray(new Integer[0]);
            int diff = Math.abs(arr[0] - arr[1]);
            return diff == 1;
        }
        if (counts.size() == 1 && counts.containsKey(1)) return true;
        if (counts.size() ==1 && counts.containsKey(word.length())) return true;
        return false;
    }
}

