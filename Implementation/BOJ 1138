n = int(input())
lst = list(map(int, input().split()))
a = [0] * n

for i in range(n):
    zero_count = 0
    for j in range(n):
        if zero_count == lst[i] and a[j] == 0:
            a[j] = i + 1
            break
        elif a[j] == 0:
            zero_count += 1

print(*a)
