def is_prime_number(x):
    for i in range(2, x): #1제외 2부터 확인
        if x % i == 0:
            return False #소수 x
        return True #소수 o
