class Solution {
    public String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            int current = chars[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (current - j > 0) {
                    chars[i] = (char)(j + 'a');
                    return new String(chars);
                }
            }
        }
        for (int i = 0; i < chars.length / 2; i++) {
            int current = chars[chars.length - 1 - i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (current - j < 0) {
                    chars[chars.length - 1 - i] = (char)(j + 'a');
                    return new String(chars);
                }
            }
        }
        return "";
    }
}

