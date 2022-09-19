class Solution:
    def smallestSubarrays(self, nums):
        n = len(nums)
        num_bits = 30
        bit_array = [0] * num_bits
        res = [1] * n

        for i in range(n - 1, -1, -1):
            current = nums[i]
            for b in range(num_bits):
                if current % 2 > 0:
                    bit_array[b] = i
                current //= 2
                res[i] = max(res[i], bit_array[b] - i + 1)
        return res


s = Solution()
print(s.smallestSubarrays([1, 0, 2, 1, 3]))
