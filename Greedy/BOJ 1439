s = input()
change0 = 0
change1 = 0

if s[0] == '0':
    change1 = 1
else:
    change0 = 1
    
for i in range(len(s)-1):
    if s[i] != s[i+1]:
        if s[i+1] == '1':
            change0 += 1
        else:
            change1 += 1
            
print((min(change0,change1)))
