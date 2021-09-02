n = int(input())
m = int(input())

visited = [0]*n
G = [[0]*n for _ in range(n)]

for _ in range(m):
    n1, n2 = map(int, input().split())
    G[n1-1][n2-1] = G[n2-1][n1-1] = 1

def dfs(t):
    visited[t] = 1

    for i in range(n):
        if G[t][i] == 1 and visited[i] == 0:
            dfs(i)

dfs(0)
count = 0

for i in range(1,n):
    if visited[i] == 1:
        count += 1

print(count)
