from itertools import combinations

l, c = map(int, input().split())
AEIOU  = ['a', 'e', 'i', 'o', 'u']

lst = input().split()
lst.sort()

for password in combinations(lst, l):
    count = 0

    for i in password:
        if i in AEIOU:
            count += 1

    if count >= 1 and count <= l - 2:
        print(''.join(password))
