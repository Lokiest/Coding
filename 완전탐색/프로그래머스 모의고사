def solution(answers):
    answer = []
    SPJ1 = [1,2,3,4,5]
    SPJ2 = [2,1,2,3,2,4,2,5]
    SPJ3 = [3,3,1,1,2,2,4,4,5,5]
    C1, C2, C3 = 0, 0, 0
    
    for i in range(len(answers)):
        if answers[i] == SPJ1[i % 5]:
            C1 += 1
        if answers[i] == SPJ2[i % 8]:
            C2 += 1
        if answers[i] == SPJ3[i % 10]:
            C3 += 1
            
    Max = max(C1, C2, C3)
    
    if Max == C1:
        answer.append(1)
    if Max == C2:
        answer.append(2)
    if Max == C3:
        answer.append(3)
            
    return answer
