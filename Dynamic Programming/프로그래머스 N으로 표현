def solution(N, number):
    dp = [[]]
    for i in range(1, 9):
        lst = []
        
        for j in range(1, i):
            for k in dp[j]:
                for l in dp[i - j]:
                    lst.append(k + l)
                    
                    if k - l >= 0:
                        lst.append(k - l)
                        
                    lst.append(k * l)
                    
                    if k != 0 and l != 0:
                        lst.append(k // l)
        lst.append(int(str(N) * i))
        if number in lst:
            return i
        dp.append(list(set(lst)))
        
    return -1
