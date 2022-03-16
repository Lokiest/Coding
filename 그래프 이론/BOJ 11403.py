n = int(input())
G = []
for _ in range(n):
    G.append(list(map(int, input().split())))

for k in range(n):
    for i in range(n):
        for j in range(n):
            if G[i][j] == 1 or (G[i][k] == 1 and G[k][j] == 1):
                G[i][j] = 1

for row in G:
    for col in row:
        print(col, end=' ')
    print()
