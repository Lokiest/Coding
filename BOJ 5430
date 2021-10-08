from collections import deque

t = int(input())

for i in range(t):
    p = input().rstrip()
    n = int(input())
    lst = input().rstrip()[1:-1].split(',') #[,와 ,] 떼어주기
    que = deque(lst)

    reverse, flag = 0, 0

    if n == 0: #n==0일 경우 "[]"만 존재하는 것을 처리
        que = []

    for j in p:
        if j == 'R':
            reverse += 1
        else:
            if len(que) < 1: #error 출력해야할 경우 즉, que에 아무것도 없는데 D일 경우
                flag = 1
                print('error')
                break

            else:
                if reverse % 2 == 0: #reverse가 짝수일 경우
                    que.popleft() #앞에서 제거
                else: #홀수일 경우
                    que.pop() #뒤에서 제거

    if flag == 0:
        if reverse % 2 == 0:
            print('[' + ','.join(que) + ']')
        else:
            que.reverse() #홀수일 경우 뒤집어주기
            print('[' + ','.join(que) + ']')
