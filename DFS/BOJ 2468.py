import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y, h):

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < n) and (0 <= ny < n) and visited[nx][ny] == 0 and \
                G[nx][ny] > h: #범위 안에 존재하며, 들리지않았으며, 높이보다 클 경우
            visited[nx][ny] = 1
            dfs(nx, ny, h)

n = int(input())
G = [list(map(int, input().split())) for _ in range(n)]
result = 1

for k in range(max(map(max, G))): #주어진 배열에서 가장 큰 값만큼 반복하게
    count = 0
    visited = [[0]*n for _ in range(n)] #매번 초기화되야하는 visited그래프

    for i in range(n):
        for j in range(n):
            if G[i][j] > k and visited[i][j] == 0:
                visited[i][j] = 1
                count += 1
                dfs(i, j, k)
    result = max(result, count)

print(result)
