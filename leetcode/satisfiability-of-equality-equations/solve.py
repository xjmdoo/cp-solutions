class Solution:
    def equationsPossible(self, equations):
        parent = [0] * (ord('z') + 1)

        def find(x):
            if parent[x] == x or parent[x] == 0:
                return x
            else:
                return find(parent[x])

        def union(x, y):
            parent[find(y)] = find(x)

        for item in equations:
            if item[1] == "=":
                union(ord(item[0]), ord(item[3]))
        for item in equations:
            if item[1] == "!" and find(ord(item[0])) == find(ord(item[3])):
                return False
        return True


s = Solution()
print(s.equationsPossible(["b==a", "a==b", "c==a", "c==b", "d==a", "e!=b", "e==f"]))
print(s.equationsPossible(["e==d", "e==a", "f!=d", "b!=c", "a==f"]))
