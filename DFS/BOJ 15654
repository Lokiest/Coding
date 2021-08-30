n,m = map(int,input().split())
s = list(map(int, input().split()))
s.sort()
visited = [0 for _ in range(n)]
ans = []

def dfs(cnt):
    if cnt == m:
        print(*ans)
        return

    for i in range(n):
       if visited[i] == 0:
           visited[i] = 1
           ans.append(s[i])

           dfs(cnt + 1)

           ans.pop()
           visited[i] = 0

dfs(0)
