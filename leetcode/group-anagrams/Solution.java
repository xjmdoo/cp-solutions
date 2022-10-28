class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String toStr = new String(chars);
            if (map.containsKey(toStr)) {
                map.get(toStr).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(toStr, l);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}

