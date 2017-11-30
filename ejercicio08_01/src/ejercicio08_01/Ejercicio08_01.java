/***********************************************************************************
(Suma elementos columna por columna) Escribe un método que devuelva la suma de todos *
* elementos en una columna especificada en una matriz usando el siguiente encabezado: *
* public static double sumColumnas (double [] [] m, int columnasIndex) *
* Escriba un programa de prueba que lea una matriz de 3 por 4 y muestre la suma de cada *
* columna.                                                                              *
************************************************************************************/
package ejercicio08_01;

import java.util.Scanner;

/**
 *
 * @author sesion
 */
public class Ejercicio08_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lea una matriz de 3 por 4
		double[][] matrix = getMatrix();

		// Muestra la suma de cada columna
		for (int col = 0; col < matrix[0].length; col++) {	
			System.out.println(
				"Suma de los elementos en la columna " + col + 
				" es " + sumColumnas(matrix, col));
		}
	}

	/** etMatrix inicializa una matriz con valores de entrada del usuario
     * @return  */
	public static double[][] getMatrix() {
		// Crear el Scanner
		Scanner input = new Scanner(System.in);
		final int FILAS = 3;
		final int COLUMNAS = 4;
		double[][] m = new double[FILAS][COLUMNAS];

		// Pedir al usuario que ingrese una matriz de 3 por 4
		System.out.println("Enter a " + FILAS + "-by-" + 
			COLUMNAS + " matrix row by row:");
		for (int fila = 0; fila < m.length; fila++)
			for (int col = 0; col < m[fila].length; col++) 
				m[fila][col] = input.nextDouble();
		return m;
	}

	/** sum devuelve la suma de los elementos en columnasIndex*/
	public static double sumColumnas(double[][] m, int columnasIndex) {
		double sum = 0;
		for (int row = 0; row < m.length; row++) {
			sum += m[row][columnasIndex];		
		}
		return sum;
	}
}

