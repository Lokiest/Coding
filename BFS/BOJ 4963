from collections import deque

dx = [1, -1, 0, 0, 1, -1, -1, 1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]

def bfs(x, y):
    graph[x][y] = 0
    
    que = deque()
    que.append([x, y])
    
    while que:
        a, b = que.popleft()
        
        for i in range(8):
            nx = a + dx[i]
            ny = b + dy[i]
            
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                que.append([nx, ny])
                
while True:
    w, h = map(int, input().split())
    
    if w == 0 and h == 0:
        break
        
    graph = []
    count = 0
    
    for i in range(h):
        graph.append(list(map(int, input().split())))
        
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                bfs(i, j)
                count += 1
                
    print(count)
