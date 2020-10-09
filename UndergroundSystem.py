class UndergroundSystem:

    def __init__(self):
        
        # 10:23am
        # 10:43am
        # (starts, ends) -> [[guest1, start_time, end_time],[g2, st, et]]
        # start -> [g1, g2]
        self.data = collections.defaultdict(list)
        self.guest2startstime = {}
        
    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.guest2startstime[id] = (stationName, t)
        
    def checkOut(self, id: int, stationName: str, t: int) -> None:
        self.data[(self.guest2startstime[id][0], stationName)].append([id, self.guest2startstime[id][1], t])

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        travels = self.data[(startStation, endStation)]
        if travels:
            return sum(map(lambda x: x[2]-x[1], travels)) / len(travels)
        return -1
        


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)