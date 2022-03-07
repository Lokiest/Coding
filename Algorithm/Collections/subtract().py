import collections

Excounter1 = collections.Counter('I love you')
Excounter2 = collections.Counter('I love my family')
#Excounter2 - Excounter1
Excounter2.subtract(Excounter1)
print(Excounter2)

>>> Counter({'m': 2, ' ': 1, 'l': 1, 'y': 1, 'f': 1, 'a': 1, 'i': 1, 'I': 0, 'v': 0, 'e': 0, 'o': -1, 'u': -1})
