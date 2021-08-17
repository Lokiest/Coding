T = int(input())

P = [0,1]

for i in range(2,46):
    P.append(P[i-1] + P[i-2])
    
for _ in range(T):
    n = int(input())
    lst = []
    
    for j in range(45,0,-1):
        if P[j] <= n:
            lst.append(P[j])
            n -= P[j]
            
            if n == 0:
                lst.sort()
                for result in lst:
                    print(result, end = " ")
                break
