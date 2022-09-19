class Solution:
    def findDuplicate(self, paths):
        m = {}
        for p in paths:
            split = p.split(" ")
            files_with_content = split[1:]
            for f in files_with_content:
                content_start = f.index("(")
                content = f[content_start + 1:-1]
                full_path = split[0] + "/" + f[:content_start]
                if content not in m:
                    m[content] = [full_path]
                else:
                    m[content].append(full_path)
        res = []
        for val in m.values():
            if len(val) > 1:
                res.append(val)
        return res


s = Solution()
print(s.findDuplicate(
    ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]))
