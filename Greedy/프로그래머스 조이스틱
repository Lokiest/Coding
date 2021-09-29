def solution(name):
    change = [min(ord(i) - ord('A'), ord('Z') - ord(i) + 1) for i in name]
    index = 0
    answer = 0
    
    while True:
        answer += change[index]
        change[index] = 0
        
        if sum(change) == 0:
            return answer
    
        left, right = 1, 1
        while change[index - left] == 0:
            left += 1
        while change[index + right] == 0:
            right += 1
            
        if left < right:
            answer += left
            index += -left
        else:
            answer += right
            index += right
