n = int(input())
lst = list(map(int, input().split()))
m = int(input())
left, right = 0, max(lst)

while left <= right:
    mid = (left + right) // 2
    t = 0

    for i in lst:
        t += min(mid, i)

    if t > m:
        right = mid - 1
    else:
        left = mid + 1

print(right)
