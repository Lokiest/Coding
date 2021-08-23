import sys

T = int(input())

for i in range(0,T):
    count = 1
    people = []
    N = int(input())
    
    for i in range(N):
        P,I = map(int, sys.stdin.readline().split())
        people.append([P,I])
    people.sort()
    M = people[0][1]
    
    for i in range(1,N):
        if M > people[i][1]:
            count += 1
            M = people[i][1]
    print(count)
