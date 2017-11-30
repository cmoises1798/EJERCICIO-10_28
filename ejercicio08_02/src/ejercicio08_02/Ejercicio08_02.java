/************************************************* ********************************
* (Suma la diagonal principal en una matriz) Escribe un método que sume todos los números *
* en la diagonal principal en una matriz n * n de valores dobles usando lo siguiente *
* encabezado: *
* *
* static static double sumMajorDiagonal (double [] [] m) *
* *
* Escriba un programa de prueba que lea una matriz de 4 por 4 y muestre la suma de todos *
* sus elementos en la diagonal principal. *
************************************************** *******************************/
package ejercicio08_02;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Crear una matriz de 4 por 4
		double[][] matrix = getMatrix();

		//Muestra la suma de la diagonal principal
		System.out.println("La suma de los elementos en la diagonal principal es" + 
			sumMajorDiagonal(matrix));
	}

	/** getMatrix devuelve una matriz inicializada con la entrada del usuario */
	public static double[][] getMatrix() {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Crear una matriz de 4 por 4
		final int FILAS = 4;
		final int COLUMNAS = 4;
		double[][] m = new double[FILAS][COLUMNAS];
		
		// Pedir al usuario que ingrese una matriz de 4 por 4
		System.out.println("Ingrese una matriz de 4 por 4 fila por fila:");
		for (int fila = 0; fila < FILAS; fila++) {
			for (int col = 0; col < COLUMNAS; col++) {
				m[fila][col] = input.nextDouble(); 
			}
		}
		return m;
	}

	/** sumMajorDiagonal devuelve la suma de todos los elementos 
             de la matriz en la diagonal principal */
	public static double sumMajorDiagonal(double[][] m) {
		double suma = 0;
		for (int i = 0; i < m.length; i++) {
			suma += m[i][i];
		}
		return suma;
	}
}