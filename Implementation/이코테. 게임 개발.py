n, m = map(int, input().split())
d = [[0]*m for _ in range(n)] #방문위치 저장하기 위한 맵 생성
x, y, direction = map(int, input().split())
d[x][y] = 1

lst = [] #맵 받기
for i in range(n):
    lst.append(list(map(int, input().split())))

dx = [1, -1 ,0, 0]
dy = [0, 0, 1, -1]

def turn_left(): #반시계 방향으로 회전
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

count = 1
turn_time = 0

while True:
    turn_left() #반시계로 회전
    nx = x + dx[direction]
    ny = y + dy[direction]

    if d[nx][ny] == 0 and lst[nx][ny] == 0: #갈 수 있다면
        d[nx][ny] = 1 #들림 처리
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue

    else:
        turn_time += 1 #갈 수 없다면 turn_time += 1

    if turn_time == 4: #네방향 모두 갈 수 없다면
        nx = x - dx[direction]
        ny = y - dy[direction]

        if lst[nx][ny] == 0: #뒤로 갈 수 있다면 이동
            x = nx
            y = ny
        else: #뒤로 이동도 못한다면 break
            break
        turn_time = 0

print(count)
