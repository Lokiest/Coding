from collections import deque

m, n = map(int, input().split())
G= []
for _ in range(n):  #그래프 받아주기
    G.append(list(map(int, input().split())))

que = deque()

def bfs():
    dx = [-1, 1, 0, 0] #상하좌우
    dy = [0, 0, -1, 1]

    while que:
        x, y= que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and G[nx][ny] == 0: #범위 내에 존재하고 토마토 존재
                que.append([nx, ny])
                G[nx][ny] = G[x][y] + 1

for i in range(n):
    for j in range(m):
        if G[i][j] == 1:  #익은 토마토 존재할 시
            que.append([i, j])

bfs()

count = -1
check = 0

for rows in G:
    for r in rows:
        if r == 0:
            check = 1
        count = max(count, r)
        
if check == 1:
    print(-1)
elif count == -1:
    print(0)
else:
    print(count - 1)
