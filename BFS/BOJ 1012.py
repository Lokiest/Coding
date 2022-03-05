from collections import deque
T = int(input())

def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    que = deque()
    que.append((x, y))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if G[nx][ny] == 1:
                    G[nx][ny] = 0
                    que.append((nx, ny))

for i in range(T):
    m, n, k = map(int, input().split())

    G = [[0]*m for _ in range(n)]

    for i in range(k):
        a, b= map(int, input().split())
        G[b][a] = 1

    count = 0

    for i in range(n):
        for j in range(m):
            if G[i][j] == 1:
                bfs(i, j)
                count += 1

    print(count)
