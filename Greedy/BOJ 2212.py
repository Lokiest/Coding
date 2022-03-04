n = int(input())
k = int(input())
S = list(map(int, input().split()))
S.sort()
gap = []

for i in range(n-1):
    gap.append(S[i+1]-S[i])
gap.sort(reverse = True)

if k >= n:
    print(0)
else:
    for _ in range(k-1):
        gap.pop(0)
    print(sum(gap))
