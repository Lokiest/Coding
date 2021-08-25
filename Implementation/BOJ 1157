word = input().upper()
word_list = list(set(word))
count_list = []

for i in word_list:
    cnt = word.count(i)
    count_list.append(cnt)
    
if count_list.count(max(count_list)) > 1:
    print('?')
else:
    max_index = count_list.index(max(count_list))
    print(word_list[max_index])
