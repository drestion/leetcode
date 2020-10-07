class BrowserHistory:
    
    # 9:43AM
    # 10:09am

    def __init__(self, homepage: str):
        self.visited = [homepage]
        self.current_ind = 0
        self.visited_len = 1
        
    def visit(self, url: str) -> None:
        while self.current_ind < len(self.visited) - 1: # if current_ind is the last pointer, do not do this
            self.visited.pop()
        self.visited.append(url)
        self.visited_len = len(self.visited)
        self.current_ind = self.visited_len - 1

    def back(self, steps: int) -> str:
        if self.current_ind >= steps:
            self.current_ind -= steps
        else:
            self.current_ind = 0
        
        return self.visited[self.current_ind]

    def forward(self, steps: int) -> str:
        if self.visited_len - self.current_ind > steps:
            self.current_ind += steps
        else:
            self.current_ind = self.visited_len - 1
        
        return self.visited[self.current_ind]
        
    # leet, g, f, y,l

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)


