#7576
from collections import deque

m, n = map(int, input().split())
G = [list(map(int, input().split())) for _ in range(n)]

que = deque()

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while que:
        x, y= que.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m and G[nx][ny] == 0:
                G[nx][ny] = G[x][y] + 1
                que.append((nx, ny))
                
for i in range(n):
    for j in range(m):
        if G[i][j] == 1:
            que.append((i, j))
bfs()

count = -1
check = 0
for i in G:
    for j in i:
        if j == 0:
            check = 1
        count = max(count, j)
        
if check == 1:
    print(-1)
elif count == -1:
    print(0)
else:
    print(count - 1)
    
    
#1012
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

            if 0 <= nx < n and 0 <= ny < m and G[nx][ny] == 1:
                G[nx][ny] = 0
                que.append((nx, ny))

for i in range(T):
    m, n, k = map(int, input().split())
    G = [[0] * m for _ in range(n)]

    for _ in range(k):
        a, b = map(int, input().split())
        G[b][a] = 1

    count = 0
    for i in range(n):
        for j in range(m):
            if G[i][j] == 1:
                bfs(i, j)
                count += 1

    print(count)
    
    
#1931
n = int(input())
lst = []
for i in range(n):
    start, end = map(int, input().split())
    lst.append((start, end))

meeting = sorted(lst, key = lambda x : x[0])
meeting = sorted(meeting, key = lambda x : x[1])

start_time = 0
count = 0

for i in meeting:
    if i[0] >= start_time:
        start_time = i[1]
        count += 1

print(count)
