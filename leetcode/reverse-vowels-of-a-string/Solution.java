class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        Stack<Character> vowelsInStr = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                vowelsInStr.push(chars[i]);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                chars[i] = vowelsInStr.pop();
            }
        }

        return new String(chars);
    }
}

