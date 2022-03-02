#완주하지 못한 선수
#collections를 이용한 다른 풀이법
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    #Counter : key값과 value값으로 나누서 개수를 세줌
    #결국 중복되는 것들은 사라지고 completion에 없는 값만 1의 value값을 가지고 살아남으므로
    #그 값에 대한 key값을 도출
    return list(answer.keys())[0]
    
    
#기능 개발
def solution(progresses, speeds):
    answer = []
    time = 0
    count = 0
    
    while len(progresses) > 0:
        if progresses[0] + (time * speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
            
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
            
    answer.append(count)
    
    return answer
    
