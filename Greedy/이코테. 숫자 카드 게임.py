n, m = map(int, input().split())
result = 0

for i in range(n):
    lst = list(map(int, input().split()))
    min_v = min(lst)

    result = max(result, min_v)

print(result)
