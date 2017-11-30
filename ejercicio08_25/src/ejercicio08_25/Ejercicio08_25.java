/************************************************* ********************************
* (Matriz de Markov) Una matriz n * n se llama matriz de Markov positiva si cada uno *
* el elemento es positivo y la suma de los elementos en cada columna es 1. Escribe el *
* siguiendo el método para verificar si una matriz es una matriz de Markov. *
* *
* public static boolean isMarkovMatrix (double [] [] m) *
* *
* Escriba un programa de prueba que le solicite al usuario ingresar una matriz de 3 * 3 de doble *
* valores y prueba si es una matriz de Markov. *
************************************************** *******************************/
package ejercicio08_25;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Ejercicio08_25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Generar una matriz de 3 x 3 de entrada del usuario
		double[][] matrix = getMatrix();

		// Prueba si la matriz es una matriz de Markov
		System.out.println("Es" + (isMarkovMatrix(matrix) ? " " : " no ") +
			"una matriz de Markov ");
	}

	/** getMatrix devuelve una matriz de 3 por 3 completada con la entrada del usuario */
	public static double[][] getMatrix() {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Crear una matriz de 3 por 3
		double[][] m = new double[3][3];

		// Indíquele al usuario que ingrese una matriz de 3 x 3
		System.out.println("Ingrese una matriz de 3 por 3 fila por fila:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextDouble();
			}
		}
		return m;
	}

	/** isMarkovMatrix devuelve verdadero si la matriz es una matriz de Markov positiva*/
	public static boolean isMarkovMatrix(double[][] m) {
		return isElementsPositive(m) && isEachColumnSum1(m);
	}

	/** isElementsPositive devuelve verdadero si cada
               elemento en la matriz es positivo  */
	public static boolean isElementsPositive(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < 0)
					return false;
			}
		}
		return true;
	}

	/** isEachColumnSum1 devuelve verdadero si el
            la suma de los elementos en cada columna es 1 */
	public static boolean isEachColumnSum1(double[][] m) {
		for (int col = 0; col < m.length; col++) {
			double sum = 0; // Sum of each column
			for (int row = 0; row < m.length; row++) {
				sum += m[row][col];
			}
			if (sum != 1)
				return false;
		}
		return true;
	}
}
