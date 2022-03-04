n,l,k = map(int, input().split())
result = 0
easy, hard = 0, 0

for i in range(n):
    arr1, arr2 = map(int,input().split())
    if arr2 <= l:
        hard += 1
    elif arr1 <= l:
        easy += 1
        
result += min(k, hard) * 140

if hard < k:
    result += min(easy, k-hard) * 100
print(result)
