n, c = map(int, input().split())
lst = []
for _ in range(n):
    lst.append(int(input()))

lst.sort()

start = 1
end = lst[-1] - lst[0]
result = 0

while start <= end:
    mid = (start + end) // 2
    first = lst[0]
    count = 1

    for i in range(1,len(lst)):
        if lst[i] >= first + mid:
            first = lst[i]
            count += 1

    if count < c:
        end = mid - 1

    else:
        result = mid
        start = mid + 1

print(result)
