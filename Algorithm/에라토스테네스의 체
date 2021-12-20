import math

n = 1000
lst = [True for i in range(n + 1)]

for i in range(2, int(math.sqrt(n)) + 1): #2부터 n의 제곱근까지의 모든 수 돌면서
    if lst[i] == True: #i가 소수인 경우
        #i 제외한 i의 배수 다 
        j = 2

        while i * j <= n:
            lst[i * j] = False
            j += 1
