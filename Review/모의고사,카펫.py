#모의고사
def solution(answers):
    answer = []
    SPJ1 = [1, 2, 3, 4, 5]
    SPJ2 = [2, 1, 2, 3, 2, 4, 2, 5]
    SPJ3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    count1, count2, count3 = 0, 0, 0
    
    for i in range(len(answers)):
        if SPJ1[i % 5] == answers[i]:
            count1 += 1
        if SPJ2[i % 8] == answers[i]:
            count2 += 1
        if SPJ3[i % 10] == answers[i]:
            count3 += 1
    
    Max = max(count1, count2, count3)
    
    if Max == count1:
        answer.append(1)
    if Max == count2:
        answer.append(2)
    if Max == count3:
        answer.append(3)
        
    return answer
  
  def solution(brown, yellow):
    answer = []
    total = brown + yellow
    
    for b in range(1, total + 1):
        if (total / b) % 1 == 0:
            a = total / b
            
            if a >= b: #제한사항에 가로 길이는 세로 길이보다 크거나 같다 명시
                if 2*a + 2*b - 4 == brown:
                    return [a, b]
                
    return answer
