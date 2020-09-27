class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        
        # the key is how to send two pieces of information
        # tuple can do this
        
        return sorted(logs, key=self.customSort)
        
    def customSort(self, log):
        words = log.split(' ', 1) # return the first token in the string and do not split the rest of the string
        
        if words[1][0].isnumeric():
            return (1, None, None)
        else:
            return (0, words[1], # first sort by the records
                    words[0])    # if a tie, sort by the record tag