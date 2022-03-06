m = [0] * 100

def fibo(x):
    if x == 1 or x == 2:
        return 1

    if m[x] != 0:
        return m[x]

    m[x] = fibo(x - 1) + fibo(x - 2)
    return m[x]

print(fibo(99))
