from collections import deque

m, n, k = map(int, input().split())
visited = [list([0] * n) for _ in range(m)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            visited[i][j] = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = []

for i in range(m):
    for j in range(n):
        if visited[i][j] == 0:
            count = 1
            que = deque()
            que.append((i, j))
            visited[i][j] = 1

            while que:
                y, x = que.popleft()
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if 0 <= nx < n and 0 <= ny < m and visited[ny][nx] == 0:
                        visited[ny][nx] = 1
                        que.append((ny, nx))
                        count += 1

            result.append(count)

result.sort()
print(len(result))
for i in result:
    print(i, end=' ')
