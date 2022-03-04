N = int(input())
H = list(map(int, input().split()))

ans = 0
count = 0
maxH = 0

for i in H:
    if i > maxH:
        maxH = i
        count = 0
    else:
        count += 1
    ans = max(ans,count)
print(ans)
