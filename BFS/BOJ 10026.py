from collections import deque

n = int(input())
visited = [[0]*n for _ in range(n)]
G = [list(map(str, input())) for _ in range(n)]
que = deque()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    que.append((x, y))
    visited[x][y] = 1

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and G[nx][ny] == G[x][y] and visited[nx][ny] == 0:
                que.append((nx, ny))
                visited[nx][ny] = 1

count = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            bfs(i, j)
            count += 1
print(count, end=' ')

for i in range(n):
    for j in range(n):
        if G[i][j] == 'R':
            G[i][j] = 'G'

visited = [[0]*n for _ in range(n)]

count = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            bfs(i, j)
            count += 1

print(count)
