from collections import deque

def solution(maps):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    
    row = len(maps)
    column = len(maps[0])
    
    G = [[-1 for _ in range(column)] for _ in range(row)]
    G[0][0] = 1
    
    que = deque()
    que.append([0, 0])
    
    while que:
        x, y = que.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < row and 0 <= ny < column and maps[nx][ny] == 1:
                if G[nx][ny] == -1:
                    G[nx][ny] = G[x][y] + 1
                    que.append([nx, ny])
                    
    answer = G[-1][-1]
    return answer
