n, k = map(int, input().split())
C = sorted([int(input()) for _ in range(n)], reverse = True)
count = 0

for i in range(n):
    count += k // C[i]
    k %= C[i]

print(count)
