n = int(input())
L = []
ans = [0 for _ in range(1000)]

for i in range(n):
    d,w = map(int, input().split())
    L.append([d,w])
L.sort(reverse = True, key = lambda x : x[1])

for i in range(n):
    for j in range(L[i][0]-1,-1,-1):
        if ans[j] == 0:
            ans[j] = L[i][1]
            break
print(sum(ans))
