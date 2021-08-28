n,m = map(int, input().split())
s = []
visited = [0 for _ in range(n)]

def dfs(cnt):
    if cnt == m:
        print(*s)
        return

    for i in range(n):
        s.append(i+1)
        dfs(cnt + 1)
        s.pop()
dfs(0)
