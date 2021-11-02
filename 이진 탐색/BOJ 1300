n = int(input())
k = int(input())
left, right = 1, k
answer= 0

while left <= right:
    mid = (left + right) // 2
    t = 0

    for i in range(1, n+1):
        t += min(n, mid//i)

    if t >= k:
        answer = mid
        right = mid - 1

    else:
        left = mid + 1

print(answer)
