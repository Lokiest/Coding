def solution(numbers, target):
    answer = 0
    n = len(numbers)
    
    def dfs(idx, result): #인덱스와 결과값
        if idx == n: #인덱스가 n과 같을 때 즉, 한바퀴 돌았을 때
            if result == target: #타겟 넘버와 값이 같을 경우 answer += 1
                nonlocal answer #nonlocal : 전역변수도, 지역변수도 아닌 값
                answer += 1
            return
        
        else: #인덱스로 값 하나씩 돌면서
            dfs(idx + 1, result + numbers[idx]) 
            dfs(idx + 1, result - numbers[idx])
    dfs(0, 0)
    
            
    return answer
