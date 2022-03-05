from collections import deque

n, m = map(int, input().split())
G = []
for _ in range(n):
    G.append(list(map(int, input())))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x,y):
    que = deque()
    que.append((x,y))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and G[nx][ny] == 1:
                G[nx][ny] = G[x][y] + 1
                que.append((nx,ny))

    return G[n-1][m-1]

print(bfs(0,0))
