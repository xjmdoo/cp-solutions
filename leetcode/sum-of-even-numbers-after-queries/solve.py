class Solution:
    def sumEvenAfterQueries(self, nums, queries):
        res = []

        even_sum = 0
        for i in range(len(nums)):
            if nums[i] % 2 == 0:
                even_sum += nums[i]

        for i in range(len(queries)):
            val = queries[i][0]
            idx = queries[i][1]
            new_val = nums[idx] + val

            if nums[idx] % 2 == 0:
                even_sum -= nums[idx]
            if new_val % 2 == 0:
                even_sum += new_val
            res.append(even_sum)
            nums[idx] = new_val

        return res


s = Solution()
print(s.sumEvenAfterQueries([5, 5, 4], [[0, 1], [1, 0], [4, 1]]))
