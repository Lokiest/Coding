from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
G = [list(map(int, input().split())) for _ in range(n)]
result = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, h):
    que = deque()
    que.append((x,y))
    visited[x][y] = 1

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                if G[nx][ny] > h and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    que.append((nx, ny))

for k in range(max(map(max, G))): #주어진 배열에서 가장 큰 값만큼 반복하게
    count = 0
    visited = [[0]*n for _ in range(n)] #매번 초기화되야하는 visited그래프

    for i in range(n):
        for j in range(n):
            if G[i][j] > k and visited[i][j] == 0:
                visited[i][j] = 1
                count += 1
                bfs(i, j, k)
    result = max(result, count)

print(result)
