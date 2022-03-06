n = int(input())

G = []
for _ in range(n):
    G.append(list(map(int, input().split())))

for i in range(1,n):
    for j in range(i+1):
        if j == 0:
            G[i][j] = G[i][j] + G[i - 1][j]

        elif i == j:
            G[i][j] = G[i][j] + G[i - 1][j - 1]

        else:
            G[i][j] = max(G[i][j] + G[i - 1][j], G[i][j] + G[i - 1][j - 1])

print(max(G[n-1]))
