from collections import deque

n,k = map(int, input().split())
lst = []
virus = []
for i in range(n):
    lst.append(list(map(int, input().split())))
    for j in range(n):
        if lst[i][j] != 0:#lst안에서 [i][j]의 값이 0이 아니라면 즉 바이러스라면 값,시간,좌표 append
            virus.append((lst[i][j], 0, i,j))

virus.sort()   #낮은 번호부터 증식하는 바이러스를 위한 정렬
que = deque(virus)

dx = [-1,1,0,0]
dy = [0,0,-1,1]

Ts,Tx,Ty = map(int, input().split()) #타겟시간,타겟좌표

while que:
    V,s,x,y = que.popleft()

    if s == Ts:
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < n and nx >= 0 and ny >= 0 and ny < n: #범위안에 존재하며
            if lst[nx][ny] == 0: #좌표값이 0인 경우
                lst[nx][ny] = V
                que.append((V,s + 1,nx,ny))

print(lst[Tx - 1][Ty - 1])
