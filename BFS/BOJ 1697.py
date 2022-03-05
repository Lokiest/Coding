from collections import deque

n, k = map(int, input().split())
Max = 100000
visited = [0] * (Max + 1)

def bfs():
    que = deque()
    que.append(n)

    while que:
        x = que.popleft()
        if x == k:
            print(visited[x])
            break

        for i in (x - 1, x + 1, 2 * x):
            if 0 <= i <= Max and visited[i] == 0:
                visited[i] = visited[x] + 1
                que.append(i)

bfs()
