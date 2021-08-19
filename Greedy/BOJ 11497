T = int(input())

for i in range(T):
    N = int(input())
    L = list(map(int, input().split()))
    L.sort()
    result = 0
    for j in range(2,N):
        result = max(result,abs(L[j]-L[j-2]))
    print(result)
