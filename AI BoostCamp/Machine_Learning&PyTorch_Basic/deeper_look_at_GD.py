# 데이터
x_train = torch.FloatTensor([[1], [2], [3]])
y_train = torch.FloatTensor([[1], [2], [3]])

# 모델 초기화
W = torch.zeros(1)

# learning rate 설정
lr = 0.1
epochs = 10
for i in range(epochs + 1):
  # H(x) 계산
  hypothesis = x_train * W

  # cost gradient 계산
  cost = torch.mean((hypothesis - y_train) ** 2)
  gradient = torch.sum((W * x_train - y_train) * x_train)
  print('Epoch {:4d}/{} W: {:.3f}, Cost: {:.6f}'.format(
  i, epochs, W.item(), cost.item()))

  # cost gradient로 H(x) 개선
  W -= lr * gradient
  
#with pytorch
import torch
from torch import optim

# 데이터
x_train = torch.FloatTensor([[1], [2], [3]])
y_train = torch.FloatTensor([[1], [2], [3]])

# 모델 초기화
W = torch.zeros(1, requires_grad=True)

# optimizer 설정
optimizer = optim.SGD([W], lr=0.15)
nb_epochs = 10

for epoch in range(nb_epochs + 1):
  # H(x) 계산
  hypothesis = x_train * W

  # cost 계산
  cost = torch.mean((hypothesis - y_train) ** 2)
  print('Epoch {:4d}/{} W: {:.3f} Cost: {:.6f}'.format(
  epoch, nb_epochs, W.item(), cost.item()))
  # cost로 H(x) 개선
  optimizer.zero_grad()
  cost.backward()
  optimizer.step()
