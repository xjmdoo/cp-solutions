class Solution:
    def concatenatedBinary(self, n):
        s = ""
        for i in range(1, n + 1):
            s += format(i, "b")
        return int(s, 2) % 1000000007

    def faster(self, n):
        s = 0
        length = 0
        for i in range(1, n + 1):
            if i & (i - 1) == 0:
                length += 1
            s = ((s << length) | i) % 1000000007
        return s
