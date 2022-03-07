import collections

Excounter1 = collections.Counter('I love you')
Excounter2 = collections.Counter(['I', 'l', 'o', 'v', 'e', 'h', 'e', 'r'])

print(Excounter1)
print(Excounter2)
print(Excounter1 + Excounter2)

>>> Counter({' ': 2, 'o': 2, 'I': 1, 'l': 1, 'v': 1, 'e': 1, 'y': 1, 'u': 1})
>>> Counter({'e': 2, 'I': 1, 'l': 1, 'o': 1, 'v': 1, 'h': 1, 'r': 1})
>>> Counter({'o': 3, 'e': 3, 'I': 2, ' ': 2, 'l': 2, 'v': 2, 'y': 1, 'u': 1, 'h': 1, 'r': 1})
