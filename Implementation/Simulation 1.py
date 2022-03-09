n = input()
lst = []
count = 0

for i in range(len(n)):
    if n[i].isalpha():
        lst.append(n[i])

    else:
        count += int(n[i])

lst.sort()
lst.append(str(count))

print(''.join(lst))
