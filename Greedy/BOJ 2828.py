n, m = map(int, input().split())
j = int(input())

S = 1
E = m
D = 0

for _ in range(j):
    A = int(input())
    
    if A > E:
        D += A - E
        E = A
        S = A - m + 1
    elif A < S:
        D += S - A
        S = A
        E = A +m -1
print(D)
