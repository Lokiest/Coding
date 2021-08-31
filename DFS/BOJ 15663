n,m = map(int, input().split())
s = list(map(int, input().split()))
s.sort()
ans = []
visited = [0 for _ in range(n)]

def dfs(cnt):
    if cnt == m:
        print(*ans)
        return
    
    over = -1
    
    for i in range(n):
        if visited[i] == 0 and over != s[i]:
            visited[i] = 1
            ans.append(s[i])
            over = s[i]
        
            dfs(cnt + 1)
        
            ans.pop()
            visited[i] = 0
        
dfs(0)
