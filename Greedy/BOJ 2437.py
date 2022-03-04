n = int(input())
W = list(map(int, input().split()))
W.sort()
result = 0

for i in range(n):
    if result + 1 >= W[i]:
        result += W[i]
    else:
        break
        
print(result+1)
