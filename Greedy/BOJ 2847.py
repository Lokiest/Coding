n = int(input())
Level = [int(input()) for _ in range(n)]
count = 0

for i in range(n-1,0,-1):
    if Level[i] <= Level[i-1]:
        count += Level[i-1] - Level[i] + 1
        Level[i-1] = Level[i] - 1
print(count)
