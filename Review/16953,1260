# 16953
a, b = map(int, input().split())
count = 1

while True:
    if a == b:
        break

    elif (((b % 2 != 0) and (b % 10 != 1)) or a > b):
        count = -1
        break

    else:
        if b % 2 == 0:
            b = b // 2
            count += 1

        else:
            b = b // 10
            count += 1

print(count)


#1260
from collections import deque

n, m, v = map(int, input().split())
G = [[0] * (n + 1) for i in range(n + 1)]
visited = [0] * (n + 1)

for i in range(m):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1

def dfs(v):
    visited[v] = 1
    print(v, end=' ')

    for i in range(1, n + 1):
        if G[v][i] == 1 and visited[i] == 0:
            dfs(i)

def bfs(v):
    visited = [0] * (n + 1)
    que = deque()
    que.append(v)
    visited[v] = 1

    while que:
        v = que.popleft()
        print(v, end=' ')

        for i in range(1, n + 1):
            if G[v][i] == 1 and visited[i] == 0:
                que.append(i)
                visited[i] = 1

dfs(v)
print()
bfs(v)
