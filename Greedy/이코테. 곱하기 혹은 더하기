n = str(input())
result = int(n[0])

for i in range(1, len(n)):
    if n[i] == '0' or n[i] == '1': #i번째 수가 0or1 이라면 더해주기
        result += int(n[i])

    else:
        if result == 0: #만약 result가 0이라면 다음 값은 무조건 덧셈
            result += int(n[i])
        else:
            result = result * int(n[i]) #그 외의 경우는 모두 곱해주기


print(result)
