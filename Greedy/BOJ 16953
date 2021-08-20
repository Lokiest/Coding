a,b = map(int,input().split())

count = 1

while True:
    if a == b:
        break
    elif ((b % 2 != 0) and (b % 10 != 1)) or a > b:
        count = -1
        break
    else:
        if b % 10 == 1:
            b = b // 10
            count += 1
        else:
            b = b // 2
            count += 1
print(count)
