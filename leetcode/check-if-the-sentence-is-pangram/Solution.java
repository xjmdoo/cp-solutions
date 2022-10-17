class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<Character>();

        char[] chars = sentence.toCharArray();

        for (char c : chars) {
            set.add(c);
        }

        return set.size() == 26;
    }
}

