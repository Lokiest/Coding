def solution(nums):
    Max = len(nums) // 2
    lst = list(set(nums))
    answer = 0

    for i in lst:
        if (answer < Max):
            answer += 1
    return answer
