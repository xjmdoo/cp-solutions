class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new TreeMap<>();
        for (String word : words) {
            m.put(word, m.getOrDefault(word, 0) + 1);
        }

        return m.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
    }
}

