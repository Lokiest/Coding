n = int(input())
crane = list(map(int, input().split()))
crane.sort(reverse = True)

m = int(input())
box = list(map(int, input().split()))
box.sort(reverse= True)

if box[0] > crane[0]:
    print(-1)
    exit()
    
ans = 0

while len(box) > 0:
    ans += 1
    for i in crane:
        for j in range(len(box)):
            if i >= box[j]:
                del box[j]
                break
print(ans)
