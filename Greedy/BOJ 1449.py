N, l = map(int, input().split())
location = list(map(int,input().split()))
location.sort()

tape = 1
start = location[0]
end = start + l - 0.5

for i in location:
    if end >= i:
        continue
    else:
        tape += 1
        end = i + l - 0.5
print(tape)
