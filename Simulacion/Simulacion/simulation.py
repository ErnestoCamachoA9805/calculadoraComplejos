from library import *
from matplotlib import pyplot as plt

def lets_graph(vector):
    x = [i + 1 for i in range(len(vector))]
    heights = vector
    labels = [f"Estado {i}" for i in range(len(vector))]

    plt.bar(x, heights,tick_label = labels,width=0.8)
    plt.xlabel('Estados')
    plt.ylabel('Probabilidad')
    plt.title('Probabilidad por estado')
    plt.show()
    print(x)
    print(labels)

def requirements(matrix):
    if isinstance(matrix[0][0], tuple):
        if is_unitary(matrix):
            return False
    else:
        cols = len(matrix[0])
        rows = len(matrix)
        res = []
        sum = 0

        for col in range(cols):
            for row in range(rows):
                sum += matrix[row][col]
            res.append(sum)
            sum = 0

        for el in res:
            if el <= 1:
                continue
            else:
                return True
    return False

def simulation(matrix, state, clicks):
    probabilities = [0 for i in range(len(matrix))]
    if not requirements(matrix):
        contador = 2

        result = multiply_mx(matrix, matrix)

        while contador < clicks:
            contador += 1
            result = multiply_mx(result, matrix)

        vector = action(result, state)
        norm = sim_norm(vector)
        print(vector)
        print("Norm: ", sim_norm(vector))
        for i in range(len(probabilities)):
            probabilities[i] = ((module(vector[i]))**2)/ norm

        lets_graph(probabilities)
        return vector
    else:
        print("No los cumple!")

msim = [[(0,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0)],
        [(1/math.sqrt(2),0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0)],
        [(1/math.sqrt(2),0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0)],
        [(0,0),(-1/math.sqrt(6),1/math.sqrt(6)),(0,0),(1,0),(0,0),(0,0),(0,0),(0,0)],
        [(0,0),(-1/math.sqrt(6),-1/math.sqrt(6)),(0,0),(0,0),(1,0),(0,0),(0,0),(0,0)],
        [(0,0),(1/math.sqrt(6),-1/math.sqrt(6)),(-1/math.sqrt(6),1/math.sqrt(6)),(0,0),(0,0),(1,0),(0,0),(0,0)],
        [(0,0),(0,0),(-1/math.sqrt(6),-1/math.sqrt(6)),(0,0),(0,0),(0,0),(1,0),(0,0)],
        [(0,0),(0,0),(1/math.sqrt(6),-1/math.sqrt(6)),(0,0),(0,0),(0,0),(0,0),(1,0)],]

sim_state = [(1,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0),(0,0)]

simulation(msim, sim_state, 15700)