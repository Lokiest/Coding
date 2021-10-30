n = int(input())
lst = []

for i in range(n):
    start, end = map(int, input().split())
    lst.append((start, end))

lst.sort()
pre_start, pre_end = lst[0][0], lst[0][1]
count = 0

for i in range(1, n):
    start, end = lst[i][0], lst[i][1]

    if start <= pre_end:
        pre_end = max(pre_end, end)

    else:
        count += pre_end - pre_start
        pre_start, pre_end = start, end

count += pre_end - pre_start

print(count)
