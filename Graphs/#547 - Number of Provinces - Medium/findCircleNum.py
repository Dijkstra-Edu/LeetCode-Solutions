class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n
        provinces = 0
        
        def dfs(city):
            visited[city] = True
            for j in range(n):
                if isConnected[city][j] == 1 and not visited[j]:
                    dfs(j)
        
        for i in range(n):
            if not visited[i]:
                dfs(i)
                provinces += 1
        
        return provinces
