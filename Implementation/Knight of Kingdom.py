s = input()
row = int(s[1])
column = int(ord(s[0]))-int(ord('a')) + 1
count = 0

dir = [(-2,-1),(-1,-2),(1,-2),(2,-1),(2,1),(1,2),(-1,2),(-2,1)] #이동 가능한 방향 8가지


for i in dir: #이동하고자하는 위치 확인
    nr = row + i[0]
    nc = column + i[1]

    if nr >= 1 and nr <= 8 and nc >= 1 and nc <= 8: #위치로 이동 가능하다면 count += 1
        count += 1

print(count)
