for t in range(int(input())):
    n, m = map(int, input().split())
    lst = list(map(int, input().split()))

    d = []
    index = 0

    for i in range(n):
        d.append(lst[index:index+m]) #lst로 받은 금광 수 m씩 잘라주기
        index += m

    for j in range(1,m):
        for i in range(n):
            if i == 0: #왼쪽 위에서
                left_up = 0
            else:
                left_up = d[i - 1][j - 1]

            if i == n-1: #왼쪽 아래에서
                left_down = 0
            else:
                left_down = d[i + 1][j - 1]

            left = d[i][j - 1] #왼쪽에서

            d[i][j] = d[i][j] + max(left, left_up, left_down) #가장 큰 값 더해주기

    result = 0

    for i in range(n):
        result = max(result, d[i][m - 1])
    print(result)
