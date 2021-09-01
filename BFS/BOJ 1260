from collections import deque

n,m,v = map(int, input().split())
G = [[0] * (n+1) for i in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1

def bfs(v):
    que = deque()
    que.append(v)
    visited[v] = 1

    while que:
        v = que.popleft()
        print(v,end=' ')

        for i in range(1, n + 1):
            if G[v][i] == 1 and visited[i] == 0:
                que.append(i)
                visited[i] = 1

def dfs(v):
    visited[v] = 1
    print(v, end=' ')

    for i in range(1,n+1):
        if G[v][i] == 1 and visited[i] == 0:
            dfs(i)

dfs(v)
visited = [0] * (n+1)
print()
bfs(v)
