def solution(priorities, location):
    idx = [i for i in range(len(priorities))]
    answer = []

    while len(priorities) != 0:
        if priorities[0] == max(priorities):
            answer.append(idx.pop(0))
            priorities.pop(0)

        else:
            priorities.append(priorities.pop(0))
            idx.append(idx.pop(0))

    return answer.index(location) + 1
