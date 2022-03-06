#15903
n, m = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()

for _ in range(m):
    Sum = lst[0] + lst[1]
    lst[0] = Sum
    lst[1] = Sum
    lst.sort()

print(sum(lst))


#2667
from collections import deque
n = int(input())
G = []
for _ in range(n):
    G.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    que = deque()
    que.append((x, y))
    G[x][y] = 0
    count = 1

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and G[nx][ny] == 1:
                G[nx][ny] = 0
                que.append((nx, ny))
                count += 1
    return count

cnt = []
for i in range(n):
    for j in range(n):
        if G[i][j] == 1:
            cnt.append(bfs(i, j))

cnt.sort()
print(len(cnt))
for i in range(len(cnt)):
    print(cnt[i])
