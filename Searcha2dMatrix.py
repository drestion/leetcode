class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        m, n = len(matrix), len(matrix[0])
        
        matrix1d = []
        
        for i in range(m): 
            for j in range(n): matrix1d.append(matrix[i][j])
                
        li, hi = 0, m*n-1
        
        while li <= hi:
            mid = (li + hi)//2
            if matrix1d[mid] == target:
                return True
            elif matrix1d[mid] < target:
                li = mid + 1
            else:
                hi = mid - 1
        
        return False
    
    
    # notice how to do this without using the 1d matrix:
    
# 	int begin = 0, end = row_num * col_num - 1;
	
# 	while(begin <= end){
# 		int mid = (begin + end) / 2;
# 		int mid_value = matrix[mid/col_num][mid%col_num];
		