import collections

Excounter = collections.Counter(['IronMan', 'Thor', 'IronMan', 'IronMan', 'IronMan', 'Spidy', 'Thor', 'IronMan', 'Spidy', 'Thor'])
print(Excounter.most_common()) #전체 반환
print(Excounter.most_common(2)) #최빈값 상위 2개 반환
print(Excounter.most_common(1)) #최빈값 상위 1개 반환

>>> [('IronMan', 5), ('Thor', 3), ('Spidy', 2)]
>>> [('IronMan', 5), ('Thor', 3)]
>>> [('IronMan', 5)]
