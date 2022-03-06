import torch
import torch.nn as nn
import torch.nn.functional as F
import torch.optim as optim

z = torch.FloatTensor([1, 2, 3])

hypothesis = F.softmax(z, dim = 0)
print(hypothesis)

hypothesis.sum()

z = torch.rand(3, 5, requires_grad = True)
hypothesis = F.softmax(z, dim = 1)
print(hypothesis)

y = torch.randint(5, (3,)).long()
print(y)

y_one_hot = torch.zeros_like(hypothesis)
y_one_hot.scatter_(1, y.unsqueeze(1), 1)

cost = (y_one_hot * -torch.log(hypothesis)).sum(dim = 1).mean()
print(cost)

#low level
torch.log(F.softmax(z, dim = 1))
#high level
F.log_softmax(z, dim = 1)

#low level
(y_one_hot * -torch.log(hypothesis)).sum(dim = 1).mean()
#high level
F.nll_loss(F.log_softmax(z, dim = 1), y)

F.cross_entropy(z, y)


x_train = [[1, 2, 1, 1],
           [2, 1, 3, 2],
           [3, 1, 3, 4],
           [4, 1, 5, 5],
           [1, 7, 5, 5],
           [1, 2, 5, 6],
           [1, 6, 6, 6],
           [1, 7, 7, 7]]
y_train = [2, 2, 2, 1, 1, 1, 0, 0]

x_train = torch.FloatTensor(x_train)
y_train = torch.LongTensor(y_train)

#모델 초기화
W = torch.zeros((4, 3), requires_grad = True)
b = torch.zeros(1, requires_grad = True)

#optimizer 설정
optimizer = optim.SGD([W, b], lr = 0.1)

nb_epochs = 1000
for epoch in range(nb_epochs + 1):

  #cost 계산 (1)
  hypothesis = F.softmax(x_train.matmul(W) + b, dim = 1)
  y_one_hot = torch.zeros_like(hypothesis)
  y_one_hot.scatter_(1, y.unsqueeze(1), 1)
  cost = (y_one_hot * -torch.log(hypothesis)).sum(dim = 1).mean()

  #cost로 H(x) 개선
  optimizer.zero_grad()
  cost.backward()
  optimizer.step()

  # 100번마다 로그 출력
  if epoch % 100 == 0:
    print('Epoch {:4d}/{} cost : {:.6f}'.format(
    epoch, nb_epochs, cost.item()
    ))
    

#모델 초기화
W = torch.zeros((4, 3), requires_grad = True)
b = torch.zeros(1, requires_grad = True)

#optimizer 설정
optimizer = optim.SGD([W, b], lr = 0.1)

nb_epochs = 1000
for epoch in range(nb_epochs + 1):

  #cost 계산 (2)
  z = x_train.matmul(W) + b
  cost = F.cross_entropy(z, y_train)

  #cost로 H(x) 개선
  optimizer.zero_grad()
  cost.backward()
  optimizer.step()

  # 100번마다 로그 출력
  if epoch % 100 == 0:
    print('Epoch {:4d}/{} cost : {:.6f}'.format(
    epoch, nb_epochs, cost.item()
    ))
    
class SofxmaxClassifiermodel(nn.Module):
  def __init__(self):
    super().__init__()
    self.linear = nn.Linear(4, 3)

  def forward(self, x):
    return self.linear(x)

model = SofxmaxClassifiermodel()

#optimizer 설정
optimizer = optim.SGD(model.parameters(), lr = 0.1)

nb_epochs = 1000
for epoch in range(nb_epochs + 1):

  #H(x) 계산
  prediction = model(x_train)

  #cost 계산
  cost = F.cross_entropy(prediction, y_train)

  #cost로 H(x) 개선
  optimizer.zero_grad()
  cost.backward()
  optimizer.step()

  # 100번마다 로그 출력
  if epoch % 100 == 0:
    print('Epoch {:4d}/{} cost : {:.6f}'.format(
    epoch, nb_epochs, cost.item()
    ))
    
