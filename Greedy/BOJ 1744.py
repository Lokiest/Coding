n = int(input())
positive = []
negative = []
Sum = 0

for _ in range(n):
    i = int(input())

    if i > 1:
        positive.append(i)
    elif i == 1: #1은 어짜피 무조건 더해야 최대가 커지므로 1만 모아두기
        Sum += 1
    else:
        negative.append(i)

positive.sort(reverse = True)
negative.sort()

if len(positive) % 2 == 0:
    for i in range(0, len(positive), 2): #건너뛰어가며 곱해야하므로 (건너뛰지않고 곱하면 중복발생)
        Sum += positive[i] * positive[i + 1]
else:
    for i in range(0, len(positive) - 1, 2):
        Sum += positive[i] * positive[i + 1]
    Sum += positive[-1] #마지막 수만 따로 더해주기

if len(negative) % 2 == 0:
    for i in range(0, len(negative), 2):
        Sum += negative[i] * negative[i + 1]
else:
    for i in range(0, len(negative) - 1, 2):
        Sum += negative[i] * negative[i + 1]
    Sum += negative[-1]

print(Sum)
