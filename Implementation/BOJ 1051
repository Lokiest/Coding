n,m = map(int, input().split())
lst = [list(map(str, input().rstrip())) for _ in range(n)]
count = 0
temp = min(n,m)
for i in range(n):
    for j in range(m):
        for k in range(temp):
            if i+k < n and j+k < m:
                if lst[i][j] == lst[i][j+k] and lst[i][j] == lst[i+k][j] and lst[i][j] == lst[i+k][j+k]:
                    count = max(count,(k+1)**2)
print(count)
