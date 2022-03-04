n = int(input())
km = list(map(int, input().split()))
L = list(map(int, input().split()))

result = 0

m = L[0]

for i in range(0,n-1):
    if m > L[i]:
        m = L[i] 
    result += m * km[i]
print(result)
