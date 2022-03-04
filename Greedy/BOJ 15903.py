n,m = map(int, input().split())
cards = list(map(int,input().split()))
cards.sort()

for _ in range(m):
    Sumcard = cards[0] + cards[1]
    cards[0] = Sumcard
    cards[1] = Sumcard
    cards.sort()

print(sum(cards))
