n,m = map(int, input().split())
s = list(map(int, input().split()))
s.sort()
ans = []
visited = [0 for _ in range(n)]

def dfs(cnt):
    if cnt == m:
        print(*ans)
        return

    for i in range(n):
        if visited[i] == 0:

            ans.append(s[i])

            dfs(cnt + 1)

            ans.pop()


dfs(0)
