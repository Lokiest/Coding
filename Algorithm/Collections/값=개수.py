import collections

Excounter = collections.Counter(Loki=5, Thor=2, Captain=3)
print(Excounter)
# ('Loki' x 5번) + ('Thor' x 2번) + ('Captain' x 3번) 연산을 수행한다.
print(sorted(Excounter.elements()))

>>> Counter({'Loki': 5, 'Captain': 3, 'Thor': 2})
>>> ['Loki', 'Loki', 'Loki', 'Loki', 'Loki', 'Thor', 'Thor', 'Captain', 'Captain', 'Captain']


for key, value in Excounter.items():
    print(key, '가', value, '개 존재')
    
>>> A 가 1 개 존재
>>> B 가 1 개 존재
>>> C 가 1 개 존재
>>> D 가 1 개 존재
>>> E 가 1 개 존재
>>> F 가 1 개 존재존재있음!
