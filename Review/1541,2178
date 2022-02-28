#1541
n = input().split('-')
result = 0

for i in n[0].split('+'): #첫번째 값은 무조건 양수로 뒤에 '+'든 '-' 더해주어야함 ('-' 나올때까지)
    result += int(i)

for i in n[1:]: # 첫번째 이후의 값부터는 result값을 최소화하기위해
    for j in i.split('+'): #더한 값들을 전부 result에서 빼주기
        result -= int(j)

print(result)


#2178
from collections import deque

n, m = map(int, input().split())
G = []
for i in range(n):
    G.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    que = deque()
    que.append((x, y))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and G[nx][ny] == 1:
                G[nx][ny] = G[x][y] + 1
                que.append((nx, ny))

    return G[n - 1][m - 1]

print(bfs(0, 0))
