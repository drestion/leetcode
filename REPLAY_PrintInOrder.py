class Foo:
    def __init__(self):
        # 2:23pm
        # you need to use python library
        # but your idea is good
        self.q = []
        self.seenFirst, self.seenSecond, self.seenThird = False, False, False
    
    def first(self, printFirst: 'Callable[[], None]') -> None:
        self.seenFirst = True
        self.q.append((1, printFirst))
        if all([self.seenFirst, self.seenSecond, self.seenThird]):
            self.adjustAndPrint()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.seenSecond = True
        self.q.append((2, printSecond))
        if all([self.seenFirst, self.seenSecond, self.seenThird]):
            self.adjustAndPrint()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.seenThird = True
        self.q.append((3, printThird))
        if all([self.seenFirst, self.seenSecond, self.seenThird]):
            self.adjustAndPrint()
        
    def adjustAndPrint(self):
        
        self.q.sort(key=lambda x: x[0])
        
        for i in self.q:
            i[1]()
        
        
        