n = int(input())
lst = list(map(int, input().split()))
lst.reverse()
dp = [1] * 2001

for i in range(1, n):
    for j in range(i):
        if lst[i] > lst[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
