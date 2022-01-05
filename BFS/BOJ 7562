from collections import deque
dx = [1, 2, 1, 2, -1, -2 , -1, -2]
dy = [2, 1, -2, -1, 2, 1, -2, -1]
n = int(input())

for _ in range(n):
    T = int(input())
    G = [[0] * T for i in range(T)]

    que = deque()
    Cx, Cy = map(int, input().split())
    Fx, Fy = map(int, input().split())
    que.append((Cx, Cy))

    while que:
        Cx, Cy = que.popleft()
        if Cx == Fx and Cy == Fy:
            break

        for i in range(8):
            nx = Cx + dx[i]
            ny = Cy + dy[i]

            if 0 <= nx < T and 0 <= ny < T and G[nx][ny] == 0:
                que.append((nx, ny))
                G[nx][ny] = G[Cx][Cy] + 1

    print(G[Fx][Fy])
