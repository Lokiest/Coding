def check():
    for i in range(len(lst) - 1):
        if lst[i] == lst[i+1][0:len(lst[i])]:
            print('NO')
            return
    print('YES')

t = int(input())
for _ in range(t):
    n = int(input())
    lst = []

    for i in range(n):
        lst.append(input())

    lst.sort()
    check()
