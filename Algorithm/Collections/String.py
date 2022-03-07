import collections

Excounter = collections.Counter()
Excounter.update('ABCDEFGGGGG')
print(Excounter)

>>> Counter({'G': 5, 'A': 1, 'B': 1, 'C': 1, 'D': 1, 'E': 1, 'F': 1})
