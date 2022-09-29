import bisect


class Solution:
    def findClosestElements(self, arr, k, x):
        n = len(arr)
        if n == 0:
            return []
        closest = bisect.bisect_right(arr, x)
        left = min(closest - 1, n - 1)
        if closest != n and arr[closest] == x:
            left = (min(closest, n - 1))
        right = min(left + 1, n)
        res = []
        while k > 0:
            k -= 1
            if left == -1 and right == n:
                return res
            elif left == -1:
                res.append(arr[right])
                right += 1
            elif right == n:
                res.append(arr[left])
                left -= 1
            else:
                left_diff = abs(arr[left] - x)
                right_diff = abs(arr[right] - x)
                if left_diff == right_diff or left_diff < right_diff:
                    res.append(arr[left])
                    left -= 1
                elif left_diff > right_diff:
                    res.append(arr[right])
                    right += 1
        return sorted(res)


s = Solution()
print(s.findClosestElements([1, 2, 3, 4, 5], 4, 3))
print(s.findClosestElements([1, 2, 3, 4, 5], 4, 1))
print(s.findClosestElements([1, 2, 4, 5, 7, 10], 2, 3))
print(s.findClosestElements([1, 2, 4, 5, 7, 10], 2, 23))
print(s.findClosestElements([0, 0, 1, 2, 3, 3, 4, 7, 7, 8], 3, 3))
