import matplotlib.pyplot as plt

def num(s):
    try:
        return int(s)
    except ValueError:
        return float(s)

n = int(input())
x = []
y = []

for i in range(n + 1):
    xi = num(input())
    x.append(xi)

for i in range(n + 1):
    yi = -num(input())
    y.append(yi)


plt.plot(x, y)
plt.show()
plt.savefig('img.jpg')