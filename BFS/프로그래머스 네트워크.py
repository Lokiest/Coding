def solution(n, computers):
    visited = [0 for _ in range(n)]
    answer = 0
    for i in range(n):
        if visited[i] == 0:
            bfs(n, computers, i, visited)
            answer += 1
    return answer

def bfs(n, computers, i, visited):
    visited[i] = 1
    que = []
    que.append(i)
    
    while que:
        i = que.pop(0)
        visited[i] = 1
        
        for j in range(n):
            if j != i and computers[i][j] == 1 and visited[j] == 0:
                que.append(j)
