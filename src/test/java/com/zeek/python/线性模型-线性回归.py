pip install torch==2.1.2
# 首先引进相关库
import torch
import torch.nn as nn
import torch.optim as optim
import matplotlib.pyplot as plt
import numpy as np
# 生成数据
X = torch.randn(100, 1)  # 100个样本，每个样本1个特征
y = 2 * X + 1 + 0.2 * torch.randn(100, 1)  # 真实关系 y = 2x + 1 + 噪声
# 查看数据分布
# 将数据转换为numpy数组以便绘图
X_np = X.detach().numpy()
y_np = y.detach().numpy()

# 绘制散点图
plt.scatter(X, y, label='Data points')

# 添加图例
plt.legend()

# 添加轴标签
plt.xlabel('X')
plt.ylabel('y')

# 显示图表
plt.show()

# 定义模型
class LinearRegressionModel(nn.Module):
    def __init__(self):
        super(LinearRegressionModel, self).__init__()
        self.linear = nn.Linear(1, 1)

    def forward(self, x):
        return self.linear(x)

model = LinearRegressionModel()

# 定义损失函数和优化器
criterion = nn.MSELoss()
optimizer = optim.SGD(model.parameters(), lr=0.005)

# 训练模型
num_epochs = 1000
for epoch in range(num_epochs):
    model.train()
    optimizer.zero_grad()
    outputs = model(X)
    loss = criterion(outputs, y)
    loss.backward()
    optimizer.step()

    if (epoch+1) % 100 == 0:
        print(f'Epoch [{epoch+1}/{num_epochs}], Loss: {loss.item():.4f}')

# 模型参数
print('模型参数:', model.linear.weight.item(), model.linear.bias.item())
Epoch [100/1000], Loss: 0.5500
Epoch [200/1000], Loss: 0.0957
Epoch [300/1000], Loss: 0.0380
Epoch [400/1000], Loss: 0.0301
Epoch [500/1000], Loss: 0.0290
Epoch [600/1000], Loss: 0.0288
Epoch [700/1000], Loss: 0.0288
Epoch [800/1000], Loss: 0.0288
Epoch [900/1000], Loss: 0.0288
Epoch [1000/1000], Loss: 0.0288
模型参数: 2.016038656234741 0.9719976186752319
# 绘制线性回归结果
model.eval()
x_new = np.expand_dims(np.arange(np.min(X_np),np.max(X_np),0.1,dtype=np.float32),1)
y_line = model(torch.tensor(x_new))
y_np2 = y_line.detach().numpy()
plt.plot(x_new, y_np2, 'r', label='Model predict result')

# 绘制训练数据做对比
plt.scatter(X, y, label='Data points')

# 添加图例
plt.legend()

# 添加轴标签
plt.xlabel('X')
plt.ylabel('y')

# 显示图表
plt.show()
