n = int(input())
meeting = []
for i in range(n):
    S,E = map(int,input().split())
    meeting.append((S,E))
    
meeting = sorted(meeting, key = lambda x : x[0])
meeting = sorted(meeting, key = lambda x : x[1])

S_time = 0
M_count = 0

for x in meeting:
    if x[0] >= S_time:
        S_time = x[1]
        M_count += 1
print(M_count)
