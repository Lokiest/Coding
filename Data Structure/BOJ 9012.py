t = int(input())
for i in range(t):
    ps = input()
    lst = []

    for j in ps:
        if j == '(':
            lst.append(j)
        elif j == ')':
            if lst:
                lst.pop()
            else:
                print('NO')
                break
    else:
        if not lst:
            print('YES')
        else:
            print('NO')
