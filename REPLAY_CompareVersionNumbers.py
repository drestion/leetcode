class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        # 12:57
        def cmp(a, b):
            if a < b:
                return -1
            elif a == b:
                return 0
            return 1
        splits = (map(int, v.split('.')) for v in (version1, version2))  # int() will remove leading zeros.
        return cmp(*zip(*itertools.zip_longest(*splits, fillvalue=0)))  # the difficulty is missing values, so fill it .
    # * means unlimited number of input
    # cmp means cmp