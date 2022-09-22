class Solution:
    def reverseWords(self, s):
        return " ".join(word[::-1] for word in s.split(" "))


s = Solution()
res = s.reverseWords("Let's take LeetCode contest")
print(res)
