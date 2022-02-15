import torch
from torch import optim

# 데이터
x_train = torch.FloatTensor([[73, 80, 75],
 [93, 88, 93],
 [89, 91, 90],
 [96, 98, 100],
 [73, 66, 70]])
y_train = torch.FloatTensor([[152], [185], [180], [196], [142]])

# 모델 초기화
W = torch.zeros((3, 1), requires_grad=True)
b = torch.zeros(1, requires_grad=True)

# optimizer 설정
optimizer = optim.SGD([W, b], lr=1e-5)

epochs = 20
for i in range(epochs + 1):

 # H(x) 계산
 hypothesis = x_train.matmul(W) + b # or .mm or @

 # cost 계산
 cost = torch.mean((hypothesis - y_train) ** 2)

 # cost로 H(x) 개선
 optimizer.zero_grad()
 cost.backward()
 optimizer.step()
 print('Epoch {:4d}/{} hypothesis: {} Cost: {:.6f}'.format(
 i, epochs, hypothesis.squeeze().detach(),
 cost.item()
 ))
 
#with pytorch
import torch
from torch import optim
import torch.nn.functional as F
import torch.nn as nn

class MultivariateLinearRegressionModel(nn.Module):
  def __init__(self):
    super().__init__()
    self.linear = nn.Linear(3, 1)
    
  def forward(self, x):
    return self.linear(x)


# 데이터
x_train = torch.FloatTensor([[73, 80, 75],
  [93, 88, 93],
  [89, 91, 90],
  [96, 98, 100],
  [73, 66, 70]])
y_train = torch.FloatTensor([[152], [185], [180], [196], [142]])

# 모델 초기화
model = MultivariateLinearRegressionModel()

# optimizer 설정
optimizer = optim.SGD([W, b], lr=1e-5)

epochs = 20

for i in range(epochs + 1):

  # H(x) 계산
  Hypothesis = model(x_train)

  # cost 계산
  cost = F.mse_loss(Hypothesis, y_train)

  # cost로 H(x) 개선
  optimizer.zero_grad()
  cost.backward()
  optimizer.step()
  print('Epoch {:4d}/{} hypothesis: {} Cost: {:.6f}'.format(
  i, epochs, Hypothesis.squeeze().detach(), cost.item()))
