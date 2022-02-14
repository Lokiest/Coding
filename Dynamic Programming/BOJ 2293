n, k = map(int, input().split())
coins = []
for i in range(n):
    coins.append(int(input()))
dp = [0 for i in range(k + 1)]
dp[0] = 1 # 한 개의 동전만 사용할 경우에 대한 선언

for i in coins:
    for j in range(1, k + 1):
        if j - i >= 0:
            dp[j] += dp[j - i]

print(dp[k])
