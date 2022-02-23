#1129
n = int(input())
lst = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, len(lst)):
    lst[i][0] = lst[i][0] + min(lst[i - 1][1], lst[i - 1][2])
    lst[i][1] = lst[i][1] + min(lst[i - 1][0], lst[i - 1][2])
    lst[i][2] = lst[i][2] + min(lst[i - 1][0], lst[i - 1][1])

print(min(lst[n - 1][0], lst[n - 1][1], lst[n - 1][2]))


#2805
n, m = map(int, input().split())
lst = list(map(int, input().split()))

start = 1
end = max(lst)

while start <= end:
    mid = (start + end) // 2
    rest = 0

    for i in lst:
        if i >= mid:
            rest += i - mid

    if rest < m:
        end = mid - 1
    else:
        start = mid + 1

print(end)
