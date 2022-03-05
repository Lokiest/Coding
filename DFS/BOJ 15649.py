n,m = map(int, input().split())
s = []
visited = [0 for _ in range(n)]


def dfs(cnt):
    if cnt == m:
        print(*s)
        return

    for i in range(n):
        if visited[i] == 0:
            visited[i] = 1
            s.append(i+1)

            dfs(cnt + 1)

            visited[i] = 0
            s.pop()

dfs(0)
