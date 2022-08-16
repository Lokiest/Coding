zero = [1, 0, 1]
one = [0, 1, 1]

def fibonacci(num):
    length = len(zero)

    if length <= num:
        for i in range(length, num + 1):
            zero.append(zero[i - 2] + zero[i - 1])
            one.append(one[i - 2] + one[i - 1])

    print("{} {}".format(zero[num], one[num]))

n = int(input())
for i in range(n):
    t = int(input())
    fibonacci(t)
