from collections import deque
def solution(numbers, target):
    answer = 0
    que = deque()
    que.append([numbers[0], 0])  #인덱스를 함께 저장
    que.append([-1 * numbers[0], 0]) #첫 수의 마이너스 경우도 저장
    n = len(numbers)
    
    while que:
        x, idx = que.popleft()
        idx += 1
        
        if idx < n: #n이 idx보다 클 경우, 즉 한바퀴 다 돌 때까지
            que.append([x + numbers[idx], idx]) #다음 인덱스의 값을 더해준 경우와 그의 인덱스
            que.append([x - numbers[idx], idx]) #다음 인덱스의 값을 빼준 경우와 그의 인덱스

        else: #한바퀴 다 돌았을 때
            if x == target:
                answer += 1
                
    return answer
