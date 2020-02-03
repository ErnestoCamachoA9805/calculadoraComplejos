package edu.eci.cnyt.complex;

import java.util.*;

import javafx.util.*;

import java.io.*;

public class MatrizCompleja {

    private NumeroComplejo[][] matriz;

    /**
     * Constructor de la clase ComplexMatriz
     *
     * @param n la cantidad de filas
     * @param m la cantidad de columnas
     */
    public MatrizCompleja(int n, int m) {
        matriz = new NumeroComplejo[n][m];
    }

    /**
     * Constructor de la clase ComplexMatriz
     *
     * @param matriz La matriz de numeros complejos
     */
    public MatrizCompleja(NumeroComplejo[][] matriz) {
        this.matriz = matriz;
    }

    public static MatrizCompleja transformaVector(VectorComplejo v) {
        NumeroComplejo[] c = v.getArray();
        NumeroComplejo[][] a = {c};
        return new MatrizCompleja(a);
    }

    /**
     * Invierte la matriz
     *
     * @return Una ComplexMatriz invertida
     */
    public MatrizCompleja inversa() {
        return this.escalarProduct(new NumeroComplejo(-1.0, 0.0));
    }

    /**
     * Asigna un valor a la fila,columna de la matriz
     *
     * @param fila    del valor
     * @param columna del valor
     * @param valor   el valor a asignar
     */
    public void asigna(int fila, int columna, NumeroComplejo valor) {
        matriz[fila][columna] = valor;
    }

    /**
     * Suma dos matrices
     *
     * @param other La otra matriz
     * @return Una ComplexMatriz con la suma de ambas matrices
     * @throws CalculadoraComplejosException
     */
    public MatrizCompleja sumeMatriz(MatrizCompleja other) throws CalculadoraComplejosException {
        NumeroComplejo[][] matriz2 = other.getMatriz();
        if (matriz.length != matriz2.length || matriz[0].length != matriz2[0].length) {
            throw new CalculadoraComplejosException(CalculadoraComplejosException.SIZE_ERROR);
        }
        MatrizCompleja ans = new MatrizCompleja(matriz.length, matriz[0].length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                ans.asigna(i, j, matriz[i][j].sumeComplejo(matriz2[i][j]));
            }
        }
        return ans;
    }

    /**
     * Devuelve la adjunta de una matriz
     *
     * @return la adjunta de la matriz
     */
    public MatrizCompleja adjunta() {
        MatrizCompleja ans = this.conjugada();
        return ans.transpuesta();
    }

    /**
     * Genera el conjugado de una matriz
     *
     * @return Una ComplexMatriz que es el conjugado de esta
     */
    public MatrizCompleja conjugada() {
        MatrizCompleja ans = new MatrizCompleja(matriz.length, matriz[0].length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                ans.asigna(i, j, matriz[i][j].conjugado());
            }
        }
        return ans;
    }

    /**
     * Transpone la Matriz
     *
     * @return Una ComplexMatriz que es la transpuesta de la misma
     */
    public MatrizCompleja transpuesta() {
        MatrizCompleja ans = new MatrizCompleja(matriz[0].length, matriz.length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                ans.asigna(j, i, matriz[i][j]);
            }
        }
        return ans;
    }

    /**
     * Retorna el poducto de la matriz y un vecotr
     *
     * @param other El vector a multiplicar
     * @return Un vector que es la multiplicacion del vector y la matriz
     * @throws CalculadoraComplejosException
     */
    public VectorComplejo productoMatrizVector(VectorComplejo other) throws CalculadoraComplejosException {
        MatrizCompleja other2 = new MatrizCompleja(other.getSize(), 1);
        for (int i = 0; i < other.getSize(); i++) {
            for (int j = 0; j < 1; j++) {
                other2.asigna(i, j, other.getArray()[i]);
            }
        }
        MatrizCompleja temp_ans = this.productoMatrizMatriz(other2);
        VectorComplejo ans = new VectorComplejo();
        for (int i = 0; i < temp_ans.getMatriz().length; i++) {
            for (int j = 0; j < 1; j++) {
                ans.add(temp_ans.getMatriz()[i][j]);
            }
        }
        return ans;
    }

    /**
     * Hace el producto de dos matrices
     *
     * @param other La otra matriz
     * @return Una complexMatriz que es la multiplicacion
     * @throws CalculadoraComplejosException
     */
    public MatrizCompleja productoMatrizMatriz(MatrizCompleja other) throws CalculadoraComplejosException {
        NumeroComplejo[][] other2 = other.getMatriz();
        if (this.matriz[0].length != other2.length) {
            throw new CalculadoraComplejosException(CalculadoraComplejosException.SIZE_ERROR);
        }
        NumeroComplejo[][] ansMatriz = new NumeroComplejo[matriz.length][other2[0].length];
        for (int i = 0; i < ansMatriz.length; i++) {
            Arrays.fill(ansMatriz[i], new NumeroComplejo(0.0, 0.0));
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < other2[0].length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    ansMatriz[i][j] = ansMatriz[i][j].sumeComplejo(matriz[i][k].productoComplejo(other2[k][j]));
                }
            }
        }
        return new MatrizCompleja(ansMatriz);
    }

    /**
     * Comprueba si una matriz es Hermitian
     *
     * @return boolean de si la matriz es Hermitian
     */
    public boolean hermitian() {
        if (this.equals(this.adjunta())) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si una matriz es una unitaria
     *
     * @return boolean si la la matriz es unitaria
     */
    public boolean unitary() {
        MatrizCompleja complexMatriz;
        boolean ans = true;
        try {
            MatrizCompleja adjunta = this.adjunta();
            complexMatriz = this.productoMatrizMatriz(adjunta);
            NumeroComplejo[][] matriz = complexMatriz.getMatriz();
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i != j && Math.round(matriz[i][j].getParteReal()) != 0) {
                        ans = false;
                    } else if (i == j && Math.round(matriz[i][j].getParteImaginaria()) != 1) {
                        ans = false;
                    }
                }
            }
        } catch (CalculadoraComplejosException e) {
            e.printStackTrace();
        }
        return ans;
    }

    /**
     * Realiza el producto tensor entre dos matrices
     *
     * @param other La otra matriz
     * @return una matriz de complejos con el resultado del producto tensor
     */
    public MatrizCompleja tensorProduct(MatrizCompleja other) {
        NumeroComplejo[][] other2 = other.getMatriz();
        MatrizCompleja ans = new MatrizCompleja(other2.length * matriz.length, other2[0].length * matriz[0].length);
        for (int i = 0; i < other2.length * matriz.length; i++) {
            for (int j = 0; j < other2[0].length * matriz[0].length; j++) {
                ans.asigna(i, j, matriz[i / other2.length][j / other2[0].length].productoComplejo(other2[i % other2.length][j % other2[0].length]));
            }
        }
        return ans;
    }

    /**
     * Realiza el producto por un escalar
     *
     * @param value el valor del numero escalar
     * @return Una ComplexMatriz con la multiplicacion del producto escalar
     */
    public MatrizCompleja escalarProduct(NumeroComplejo value) {
        MatrizCompleja ans = new MatrizCompleja(matriz.length, matriz[0].length);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                ans.asigna(i, j, matriz[i][j].productoComplejo(value));
            }
        }
        return ans;
    }

    /**
     * Compara dos matrices de numeros complejos
     *
     * @param other La otra matriz
     * @return boolean si las matrices son iguales o no
     */
    public boolean equals(MatrizCompleja other) {
        NumeroComplejo[][] matriz2 = other.getMatriz();
        if (matriz2[0].length != matriz[0].length || matriz2.length != matriz.length) {
            return false;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!matriz[i][j].equals(matriz2[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fill(NumeroComplejo value) {
        for (int i = 0; i < matriz.length; i++) {
            Arrays.fill(matriz[i], value);
        }
    }

    public void fillColumn(int n, NumeroComplejo value) {
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][n] = (i == n) ? matriz[i][n] : value;
        }
    }

    public void fillRange(int n, int init, int end, NumeroComplejo value) {
        for (int i = init; i < end; i++) {
            matriz[i][n] = value;
        }
    }

    /**
     * Retorna la matriz
     *
     * @return la matriz de numeros complejos
     */
    public NumeroComplejo[][] getMatriz() {
        return matriz;
    }

    /*
    public static void main(String[] args) {
        MatrizCompleja a = new MatrizCompleja(2, 2);
        a.asigna(0, 0, new NumeroComplejo(1.0 / 3.0, 0.0));
        a.asigna(0, 1, new NumeroComplejo(2.0 / 3.0, 0.0));
        a.asigna(1, 0, new NumeroComplejo(2.0 / 3.0, 0.0));
        a.asigna(1, 1, new NumeroComplejo(1.0 / 3.0, 0.0));
        MatrizCompleja b = a.tensorProduct(a);
    }*/
}