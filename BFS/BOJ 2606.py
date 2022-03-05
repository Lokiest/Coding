from collections import deque

n = int(input())
m = int(input())

G = [[0]*(n+1) for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1

def bfs(t):
    count = 0

    que = deque()
    que.append(t)

    visited[t] = 1

    while que:
        t = que.popleft()
        count += 1
        
        for i in range(n+1):
            if G[t][i] == 1 and visited[i] == 0:
                visited[i] = 1
                que.append(i)

    return count - 1

print(bfs(1))
