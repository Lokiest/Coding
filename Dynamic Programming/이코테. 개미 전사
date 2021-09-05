n = int(input())
lst = list(map(int, input().split()))

d = [0] * 100

d[0] = lst[0]
d[1] = max(lst[0], lst[1])

for i in range(2,n):
    d[i] = max(d[i - 1], d[i - 2] + lst[i])

print(d[n - 1])
