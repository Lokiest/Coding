from collections import deque

def solution(n, edge):
    answer = 0
    G = [[]*n for _ in range(n + 1)]
    for n1, n2 in edge:
        G[n1].append(n2)
        G[n2].append(n1)
        
    visited = [0] * (n + 1)
    visited[1] = 1
    que = deque()
    que.append(1)
    
    while que:
        n = que.popleft()
        
        for i in G[n]:
            if visited[i] == 0:
                visited[i] = visited[n] + 1
                que.append(i)
                
    answer = visited.count(max(visited))
    return answer
