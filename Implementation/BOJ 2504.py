n = input()
lst = []
result = 0

for i in n:
    if i == ')':
        temp = 0

        if len(lst) == 0: #비어있다면 0출력 (대칭x)
            print(0)
            exit(0)
        while lst:
            x = lst.pop()
            if x == '[': #대칭 아니라면 0출력
                print(0)
                exit(0)
            elif x == '(':
                if temp == 0: #대칭 바로 완성되면 수 출력
                    lst.append(2)
                else: #대칭안 숫자라면 곱해주기
                    lst.append(2 * temp)
                break
            else: #위 경우가 아니라면 넘겨야하므로 temp += x
                temp += x

    elif i == ']':
        temp = 0
        if len(lst) == 0: #비어있다면 0출력 (대칭x)
            print(0)
            exit(0)
        while lst:
            x = lst.pop()
            if x == '(': #대칭 아니라면 0출력
                print(0)
                exit(0)
            elif x == '[':
                if temp == 0: #대칭 바로 완성되면 수 출력
                    lst.append(3)
                else: #대칭안 숫자라면 곱해주기
                    lst.append(3 * temp)
                break
            else: #위 경우가 아니라면 넘겨야하므로 temp += x
                temp += x

    elif i == '(' or i == '[': #시작괄호 만나면 lst에 추가
        lst.append(i)

    else:
        print(0)
        exit(0)

for i in lst:
    if i == '(' or i == '[': #리스트에 시작괄호가 남았다면 0 출력
        print(0)
        exit(0)
    else: #그 외의 숫자의 경우라면 result에 하나씩 더해주기 (곱셈은 이미 끝난 상황)
        result += i
print(result)
