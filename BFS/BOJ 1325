from collections import deque

n, m = map(int, input().split())
G = [[] for i in range(n + 1)]
for i in range(m):
    n1, n2 = map(int, input().split())
    G[n2].append(n1)

def bfs(s):
    visited = [0 for _ in range(n + 1)]
    count = 1
    visited[s] = 1
    que = deque()
    que.append(s)

    while que:
        x = que.popleft()

        for i in G[x]:
            if visited[i] == 0:
                visited[i] = 1
                count += 1
                que.append(i)

    return count

result = []
max_value = 0

for i in range(1, n + 1):
    cnt = bfs(i)

    if cnt > max_value:
        max_value = cnt
    result.append([i, cnt])

result.sort()
for i, cnt in result:
    if cnt == max_value:
        print(i, end=' ')
