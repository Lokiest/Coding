n,k = map(int, input().split())
Minn = k*(k+1)/2

if Minn > n:
    print(-1)
elif (n-Minn) % k == 0:
    print(k-1)
else:
    print(k)
