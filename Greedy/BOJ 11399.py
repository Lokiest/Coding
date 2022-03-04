n = int(input())
a = list(map(int,input().split()))
ans = 0
a.sort()

for i in range(n):
    ans += a[i] * (n-i)

print(ans)
