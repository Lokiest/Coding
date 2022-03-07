#큰 수 만들기
def solution(number, k):
    lst = []
    
    for i in number:
        while k > 0 and len(lst) > 0 and lst[-1] < i:
            k -= 1
            lst.pop()
        lst.append(i)
        
    if k != 0:
        lst = lst[:-k]
        
    answer = ''.join(lst)
    return answer


#구명보트
def solution(people, limit):
    answer = 0
    people.sort()
    left, right = 0, len(people) - 1
    
    while left <= right:
        answer += 1
        
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        
    return answer
