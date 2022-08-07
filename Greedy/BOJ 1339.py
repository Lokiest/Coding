n = int(input())
lst = []
for i in range(n):
    lst.append(list(map(lambda x : ord(x) - 65, input())))

alphabets = [0] * 26

for word in lst:
    for idx, val in enumerate(word[::-1]):
        alphabets[val] += (10 ** idx)

alphabets.sort(reverse=True)
answer = 0
num = 9
for i in range(num):
    answer += alphabets[i] * num
    num -= 1

print(answer)
