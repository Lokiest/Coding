N = int(input())

temp = 1
ans = 0

while True:
    N -= temp
    if N >= 0:
        temp += 1
        ans += 1
    else:
        print(ans)
        break
