import torch
from torch import optim

x_train = torch.FloatTensor([[1], [2], [3]])
y_train = torch.FloatTensor([[2], [4], [6]])

W = torch.zeros(1, requires_grad=True)
b = torch.zeros(1, requires_grad=True)

optimizer = optim.SGD([W, b], lr=0.01)

epochs = 1000
for epoch in range(1, epochs + 1):
 hypothesis = x_train * W + b
 cost = torch.mean((hypothesis - y_train) ** 2)
 optimizer.zero_grad()
 cost.backward()
 optimizer.step()
