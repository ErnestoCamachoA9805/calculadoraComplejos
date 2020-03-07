import math

def add(a, b):
    # a and b are complex numbers
    if isinstance(a, tuple) and isinstance(b, tuple):
        real = a[0] + b[0]
        imag = a[1] + b[1]

        res = (real, imag)
        prettyPrinting(res)
    # a is a real number and b is a complex number
    elif (isinstance(a, int) or isinstance(a, float)) and isinstance(b, tuple):
        real = a + b[0]
        imag = 0 + b[1]

        res = (real, imag)
        prettyPrinting(res)
    # b is a real number and a is a complex number
    elif (isinstance(b, int) or isinstance(b, float)) and isinstance(a, tuple):
        real = a[0] + b
        imag = a[1] + 0

        res = (real, imag)
        prettyPrinting(res)

    return res

def substract(a, b):
    # a and b are complex numbers
    if isinstance(a, tuple) and isinstance(b, tuple):
        real = a[0] - b[0]
        imag = a[1] - b[1]

        res = (real, imag)
        prettyPrinting(res)
        return res
    # a is a real number and b is a complex number
    elif (isinstance(a, int) or isinstance(a, float)) and isinstance(b, tuple):
        real = a - b[0]
        imag = 0 - b[1]

        res = (real, imag)
        prettyPrinting(res)
        return res
    #  b is a real number and a is a complex number
    elif (isinstance(b, int) or isinstance(b, float)) and isinstance(a, tuple):
        real = a[0] - b
        imag = a[1] - 0

        res = (real, imag)
        prettyPrinting(res)
        return res

def multiply(num1, num2):
    # Both are real numbers
    if (isinstance(num1, int) or isinstance(num1, float)) and (isinstance(num2, int) or isinstance(num2, float)):
        res = (num1 * num2, 0)
        prettyPrinting(res)
        return res

    # num1 is a complex number and num2 is a real number
    elif isinstance(num1, tuple) and (isinstance(num2, int) or isinstance(num2, float)):
        real = num1[0] * num2
        imag = num1[1] * num2

        res = (real, imag)
        prettyPrinting(res)
        return res

    # num2 is a complex number and num1 is a real number
    elif isinstance(num2, tuple) and (isinstance(num1, int) or isinstance(num1, float)):
        real = num2[0] * num1
        imag = num2[1] * num1

        res = (real, imag)
        prettyPrinting(res)
        return res

    # num1 and num2  are complex numbers
    elif isinstance(num1, tuple) and isinstance(num2, tuple):
        a = num1[0]
        b = num1[1]
        c = num2[0]
        d = num2[1]

        real = ((a * c) - (b * d))
        imag = ((a * d) + (b * c))

        res = (real, imag)
        prettyPrinting(res)

        return res

def divide(num1, num2):
    a = num1[0]
    b = num1[1]
    c = num2[0]
    d = num2[1]

    real = ((a * c) + (b * d)) / ((c ** 2) + (d ** 2))
    imag = ((b * c) - (a * d)) / ((c ** 2) + (d ** 2))

    res = (real, imag)
    prettyPrinting(res)

    return res

def prettyPrinting(tupla):
    real = tupla[0]
    imag = tupla[1]

    #print( real , ' + ' ,imag , 'i')

def conjugate(num1):
    if (isinstance(num1, int) or isinstance(num1, float)):
        res = num1
    else:
        a = num1[0]
        b = num1[1]

        real = a
        imag = (b * (-1))

        res = (real, imag)
        prettyPrinting(res)

    return res

def module(num):
    a = num[0]
    b = num[1]

    res = ((a ** 2) + (b ** 2)) ** (1/2)
    print(res)

    return res
    
def polar(num):
    a = num[0]
    b = num[1]

    rho = ((a ** 2) + (b ** 2)) ** (1/2)
    angle = (b / a)
    theta = math.atan(angle)
    theta = math.degrees(theta)

    if (a > 0) and (b > 0): # Ambos números positivos (I Cuadrante)
        print()
    elif (a < 0) and (b > 0): # Solo imaginaria positiva (II Cuadrante)
        theta = 180 - abs(theta)
    elif (a < 0) and (b < 0): # Ambos números negativos (III Cuadrante)
        theta = 180 + abs(theta)
    elif (a > 0) and (b < 0): # Solo real positiva (IV Cuadrante)
        theta = 360 - abs(theta)

    res = (rho, theta)
    print(res)

    return res

def phase(num):
    a = num[0]
    b = num[1]

    angle = (b / a)
    theta = math.atan(angle)
    theta = math.degrees(theta)


    if (a > 0) and (b > 0): # Ambos números positivos (I Cuadrante)
        print()
    elif (a < 0) and (b > 0): # Solo imaginaria positiva (II Cuadrante)
        theta = 180 - abs(theta)
    elif (a < 0) and (b < 0): # Ambos números negativos (III Cuadrante)
        theta = 180 + abs(theta)
    elif (a > 0) and (b < 0): # Solo real positiva (IV Cuadrante)
        theta = 360 - abs(theta)


    print(theta)

    return theta


#Let's work with arrays!
A = [[(101, 10), (1, 1), (1, 1)], [(2, 2), (2, 2), (2, 2)]]
B = [[(5, 5), (5, 5), (5, 5)], [(4, 4), (4, 4), (4, 4)]]

r = 0 #Index for getting the real part of a number
i = 1 #Index for getting the imaginary part of a number

#Let's verify if we can add them
def summable(m1, m2):
    rowsA = len(m1)
    colsA = (len(m1[0]))

    rowsB = len(m2)
    colsB = len(m2[0])

    res = False
    
    if (rowsA == rowsB) and (colsA == colsB):
        res = True

    return res

def add_arrays(m1, m2):
    answer = [[0 for i in range(len(m1[0]))] for j in range(len(m1))]

    #DISCLAIMER: Arrays must have the same size
    if summable(m1, m2):
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                # Sumamos la parte real de cada matriz
                answer[row][col] = (m1[row][col][r] + m2[row][col][r], m1[row][col][i] + m2[row][col][i])

        return answer

def inverse_matrix(m1):
    answer = [[0 for i in range(len(m1[0]))] for j in range(len(m1))]

    for row in range(len(m1)):
        for col in range(len(m1[0])):
            answer[row][col] = (-1 * m1[row][col][r], -1 * m1[row][col][i])

    return answer

def scalar_product(scalar, m1):
    answer = [[0 for i in range(len(m1[0]))] for j in range(len(m1))]

    # Let's check if scalar is integer or complex
    if isinstance(scalar, int):
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                answer[row][col] = (scalar * m1[row][col][r], scalar * m1[row][col][i])

    elif isinstance(scalar, tuple):
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                answer[row][col] = multiply(scalar, m1[row][col])

    return answer

def transpose(m1):
    # If m1 is a vector
    if isinstance(m1[0], int):
        transposed = [[0 for j in range(1)] for i in range(len(m1))]

        for row in range(len(m1)):
            for col in range(1):
                transposed[row][col] = m1[row]

    # if m1 is an array
    else:
        cols = len(m1[0])
        rows = len(m1)
        transposed = [[0 for i in range(rows)] for j in range(cols)]

        for row in range(len(m1)):
            for col in range(len(m1[0])):
                transposed[col][row] = m1[row][col]

    return transposed

def conjugate_mx(m1):
    aux = [[0 for i in range(len(m1[0]))] for j in range(len(m1))]

    if isinstance(m1[0][0], tuple):
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                aux[row][col] = (m1[row][col][r], (-1) * m1[row][col][i])
    else:
        aux = m1

    return aux

def adjoint(m1):
    transposed = transpose(m1)
    conjugated = conjugate_mx(transposed)

    return conjugated

def multiply_mx(m1, m2):
    rows_1 = len(m1)
    cols_1 = len(m1[0])
    #print("rows_1: {} cols_1: {}".format(rows_1, cols_1))

    rows_2 = len(m2)
    cols_2 = len(m2[0])
    #print("rows_2: {} cols_2: {}".format(rows_2, cols_2))

    # Let's check if we can multiply them
    if cols_1 == rows_2:
        # Let's check if m1 and m2 are real arrays
        if (isinstance(m1[0][0], int) or isinstance(m1[0][0], float) and (isinstance(m2[0][0], int) or isinstance(m2[0][0], float))):
            result = [[0 for i in range(cols_2)] for j in range(rows_1)]

            for row in range(rows_1):
                for col in range(cols_2):
                    for aux in range(cols_2):
                        result[row][col] += m1[row][aux] * m2[aux][col]
            return result

        # Let's check if we are working with complex arrays
        elif (isinstance(m1[0][0], tuple) or isinstance(m2[0][0]), tuple):
            result = [[(0, 0) for i in range(cols_2)] for j in range(rows_1)]

            for row in range(rows_1):
                for col in range(cols_2):
                    for aux in range(cols_2):
                        mult = multiply(m1[row][aux], m2[aux][col])
                        result[row][col] = add(result[row][col], mult)

            return result

def trace(m1):
    if isinstance(m1[0][0], int):
        acumulador = 0
        for col in range(len(m1)):
            for row in range(len(m1[0])):
                if col == row:
                    acumulador += m1[row][col]
    if isinstance(m1[0][0], tuple):
        acumulador = (0, 0)
        for col in range(len(m1)):
            for row in range(len(m1[0])):
                if col == row:
                    acumulador = add(acumulador, m1[row][col])

    return acumulador

def inner_product(m1, m2):
    if isinstance(m1[0][0], tuple) or isinstance(m2[0][0], tuple):
        adjointed = adjoint(m1)
        multiplied = multiply_mx(adjointed, m2)
        traced = trace(multiplied)[0]
        print(f"Traced: {traced}")
        return traced
    else:
        adjointed = adjoint(m1)
        multiplied = multiply_mx(adjointed, m2)

        result = trace(multiplied)

    print(f"Inner: {result}")
    return result

def is_hermitian(m1):
    adjointed = adjoint(m1)

    if adjointed == m1:
        print("Yes")
        return True
    else:
        print("No")
        return False

def norm(m1):
    if isinstance(m1[0][0], tuple):
        product = inner_product(m1, m1)
        root = math.sqrt(product)
        return root
    else:
        adjointed = adjoint(m1)
        multiplied = multiply_mx(adjointed, m1)
        inner = trace(multiplied)
        result = math.sqrt(inner)
        return result

def inner(v1, v2):
    result = 0
    if isinstance(v1[0], tuple) or isinstance(v2[0], tuple):
        result = (0, 0)
        if len(v1) == len(v2):
            for i in range(len(v1)):
                result = add(result, (multiply(v1[i], v2[i])))
        return result
    else:
        if len(v1) == len(v2):
            for i in range(len(v1)):
                result += v1[i] * v2[i]
        return result

def norm_vector(v1):
    result = 0
    if isinstance(v1[0], tuple):
        result = inner(v1, v1)
        result = math.sqrt(result[0])
        return result
    else:
        for i in range(len(v1)):
            result += (v1[i] * v1[i])
        result = math.sqrt(result)
        return result

def tensor(m1, m2):
    newRows = len(m1) * len(m2)
    newCols = len(m1[0]) * len(m2[0])
    result = [[] for j in range (newRows)]
    respaldo= []

    for row1 in range(len(m1)):
        for col1 in range(len(m1[row1])):
            for row2 in range(len(m2)):
                for col2 in range(len(m2[row2])):
                    dato = m1[row1][col1]*m2[row2][col2]
                    respaldo.append(dato)

    for i in range(len(result)):
        for j in range(newCols):
            result[i].append(respaldo[0])
            del respaldo[0]

    return result

def substract_by_element(v1, v2):
    if (isinstance(v1[0], tuple) or isinstance(v2[0], tuple)):
        result = [(0, 0) for i in range(len(v1))]
        for i in range(len(v1)):
            result[i] = substract(v1[i], v2[i])
        return result
    else:
        result = [0 for i in range(len(v1))]
        for i in range(len(v1)):
            result[i] = (v1[i] - v2[i])
        return result

def distance(v1, v2):
    if isinstance(v1[0], tuple) or isinstance(v2[0], tuple):
        result = substract_by_element(v1, v2)
        result = norm_vector(result)
        return result
    else:
        result = substract_by_element(v1, v2)
        result = norm_vector(result)
        return result

def action(m1, v2):
    if isinstance(m1[0][0], tuple):
        result = [(0, 0) for i in range(len(m1))]
        sum = (0, 0)
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                if isinstance(v2[0], tuple):
                    sum = add(sum, multiply(m1[row][col], v2[col]))
            result[row] = sum
            sum = (0, 0)

        return result
    else:
        result = [0 for i in range(len(m1))]
        sum = 0
        for row in range(len(m1)):
            for col in range(len(m1[0])):
                sum += m1[row][col] * v2[col]
            result[row] = sum
            sum = 0

        return result

def det(m1):
    if isinstance(m1[0][0], tuple):
        if len(m1) == len(m1[0]) == 2:
            ad = multiply(m1[0][0], m1[1][1])
            bc = multiply(m1[1][0], m1[0][1])
            result = substract(ad, bc)
            return result[0]
    else:
        if len(m1) == len(m1[0]) == 2:
            result = ((m1[0][0] * m1[1][1]) - (m1[1][0] * m1[0][1]))
            return result

def is_unitary(m1):
    if det(m1) == (1):
        return True
    else:
        return False

def IBM():
    matrix_x = [[0,1], [1,0]]
    matrix_h = [[(1 / math.sqrt(2)), (1 / math.sqrt(2))], [(1 / math.sqrt(2)), (-1 / math.sqrt(2))]]

    #Vector |00>:
    het = [[1],[0],[0],[0]]

    m1 = tensor(matrix_x, matrix_h)
    m2 = tensor(matrix_h, matrix_h)

    print(f"m1 {m1}")
    print(f"m2 {m2}")

    gamma = multiply_mx(m1, m2)
    print(f"gamma {gamma}")
    gamma = multiply_mx(gamma, het)

    print(gamma)

def sim_norm(v1):
    acum = 0

    for el in v1:
        acum += (el[0] ** 2) + (el[1] ** 2)

    print(acum)
    norm = math.sqrt(acum)
    print(norm)
    return norm


