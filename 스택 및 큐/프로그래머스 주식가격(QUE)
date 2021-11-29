from collections import deque

def solution(prices):
    answer = []
    que = deque(prices)
    
    while que:
        price = que.popleft()
        sec = 0
        
        for i in que:
            sec += 1
            
            if price > i:
                break
        answer.append(sec)
    return answer
