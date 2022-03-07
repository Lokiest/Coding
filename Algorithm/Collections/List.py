import collections

lst = ['kim', 'kim', 'park', 'choi', 'kim', 'kim', 'kim', 'choi', 'park', 'choi']
counter = collections.Counter(lst)
print(counter)

>>> Counter({'kim': 5, 'choi': 3, 'park': 2})
