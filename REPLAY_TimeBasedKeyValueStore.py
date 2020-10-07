# class TimeMap:

    
#     # 9:29pm
#     # very similar to these time-based systems
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         # index values based on timestamps
#         self.timestamp2keys = collections.defaultdict(list)
#         self.mintimestamp = 2**32
#         self.maxtimestamp = -1
#         # self.keys2vals = collections.defaultdict(list)

#     def set(self, key: str, value: str, timestamp: int) -> None:
#         self.mintimestamp = min(self.mintimestamp, timestamp)
#         self.maxtimestamp = max(self.maxtimestamp, timestamp)
#         self.timestamp2keys[timestamp].append((key, value))
#         # self.keys2vals[key].append(value)
#         print(key, value, self.timestamp2keys)
#         # print(key, value, self.keys2vals)
#     def get(self, key: str, timestamp: int) -> str:
#         if self.mintimestamp <= timestamp <= self.maxtimestamp:
#             max_t = max([t for t in self.timestamp2keys.keys() if t <= timestamp])
#             # print('max_t', max_t, self.timestamp2keys[max_t])
#             return self.timestamp2keys[max_t][0][1]
#         elif timestamp < self.mintimestamp:
#             return ''
#         else:
#             return self.timestamp2keys[self.maxtimestamp][0][1]


# # Your TimeMap object will be instantiated and called as such:
# # obj = TimeMap()
# # obj.set(key,value,timestamp)
# # param_2 = obj.get(key,timestamp)


class TimeMap:

    def __init__(self):
        self.times = collections.defaultdict(list)
        self.values = collections.defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.times[key].append(timestamp)
        self.values[key].append(value)

    def get(self, key: str, timestamp: int) -> str:
        i = bisect.bisect(self.times[key], timestamp)
        return self.values[key][i - 1] if i else ''