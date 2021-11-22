def solution(clothes):
    answer = 0
    dic = {}
    
    for name, kind in clothes:
        if kind in dic:
            dic[kind] += 1
        else:
            dic[kind] = 1
            
    answer = 1
    for val in dic.values():
        answer *= (val + 1)
        
    return answer - 1
