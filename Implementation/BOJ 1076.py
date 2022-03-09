C = ['black','brown','red','orange','yellow','green','blue','violet','grey','white']
F = C.index(input())
S = C.index(input())
T = C.index(input())

FS = (str(F) + str(S))
Total = int(FS) * (10**int(T))
print(Total)
