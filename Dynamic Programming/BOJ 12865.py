n, k = map(int, input().split())
Stuff = [[0, 0]]
dp = [[0] * (k + 1) for i in range(n + 1)]

for _ in range(n):
    Stuff.append(list(map(int, input().split())))

for i in range(1, n + 1):
    for j in range(1, k + 1):
        if j < Stuff[i][0]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max((Stuff[i][1] + dp[i - 1][j - Stuff[i][0]]), dp[i - 1][j])

print(dp[n][k])
