for i in range(int(input())):
    C = int(input())
    Coins = [25,10,5,1]
    A = C // 25
    B = (C % 25) // 10
    D = ((C % 25) % 10) // 5
    E = (((C % 25) % 10) % 5) // 1
    print(A,B,D,E)
