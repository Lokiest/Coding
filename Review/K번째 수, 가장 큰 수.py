#K번째 수
def solution(array, commands):
    answer = []
    for i in commands:
        lst = array[i[0] - 1 : i[1]]
        lst.sort()
        answer.append(lst[i[2] - 1])
        
    return answer
    
    
#가장 큰 수
def solution(numbers):
    str_numbers = list(map(str, numbers))
    str_numbers.sort(reverse = True, key = lambda x : x * 3)
    answer = str((int(''.join(str_numbers))))
    return answer
