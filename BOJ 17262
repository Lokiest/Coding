n = int(input())
lst=[]
for i in range(n):
    lst.append(list(map(int, input().split())))

go = sorted(lst, key=lambda x : x[0])
back = sorted(lst, key=lambda x: x[1])

Gap = go[-1][0] - back[0][1]

if Gap >= 0:
    print(Gap)
else:
    print(0)
