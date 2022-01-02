import hashlib


# 해시 함수 생성
def sha1_hash(input_str):
    hash_obj = hashlib.sha1(input_str.encode())
    hash_value = hash_obj.hexdigest()

    return hash_value


hash_value_apple = sha1_hash('Apple')
print(hash_value_apple)
print(len(hash_value_apple))

print()

hash_value_banana = sha1_hash('Banana')
print(hash_value_banana)
print(len(hash_value_banana))

print()

hash_value_melon = sha1_hash('Melon')
print(hash_value_melon)
print(len(hash_value_melon))
print()

hash_value_strawberry = sha1_hash('Strawberry')
print(hash_value_strawberry)
print(len(hash_value_strawberry))

>>> 476432a3e85a0aa21c23f5abd2975a89b6820d63
>>> 40

>>> fc6fae10db2bd0b625077d7c6d1b9a96925fd2b7
>>> 40

>>> 26e65e893ae5535d32cd0105721177c58a22b962
>>> 40

>>> 393d46da8467a9e4437aa15a2eef178693e18f06
>>> 40
