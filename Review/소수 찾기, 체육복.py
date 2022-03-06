#소수 찾기
import math
from itertools import permutations

def solution(numbers):
    n = [i for i in numbers]
    
    def check(x):
        if x <= 1:
            return False
        else:
            for i in range(2, int(math.sqrt(x)) + 1):
                if x % i == 0:
                    return False
            return True
        
    answer = []
    
    for i in range(1, len(n) + 1):
        count = set(list(permutations(n, i)))
        
        for j in count:
            if check(int(''.join(j))) == True:
                answer.append(int(''.join(j)))
    return len(set(answer))
  
  
#체육복
def solution(n, lost, reserve):
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)
    
    for i in set_reserve:
        if (i - 1) in set_lost:
            set_lost.remove(i - 1)
        elif (i + 1) in set_lost:
            set_lost.remove(i + 1)
            
    return n - len(set_lost)
