T = int(input())
for _ in range(T):
    a, b = map(str, input().split())
    one = 0
    zero = 0

    for i in range(len(a)):
        if a[i] != b[i]:
            if b[i] == '1':
                one += 1
            else:
                zero += 1

    print(max(one, zero))
