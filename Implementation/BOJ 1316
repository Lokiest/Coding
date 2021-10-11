n = int(input())
result = 0

for _ in range(n):
    word = input()
    error = 0

    for index in range(len(word) - 1):
        if word[index] != word[index + 1]: #연속된 문자가 다를 때
            new_group = word[index + 1:] #새로운 그룹으로 생성

            if new_group.count(word[index]) > 0: #남은 문자열에 그룹의 문자가 있었다면
                error += 1 #에러 발생
    if error == 0:
        result += 1
print(result)
