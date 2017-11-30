/************************************************* ********************************
* (Clasificación de filas) Implemente el siguiente método para ordenar las filas en un *
* matriz bidimensional. Se devuelve una nueva matriz y la matriz original es *
* intacto. *
* *
* static static double [] [] sortRows (double [] [] m) *
* *
* Escriba un programa de prueba que le solicite al usuario ingresar una matriz de 3 * 3 de doble *
* valores y muestra una nueva matriz clasificada por filas. *
************************************************** *******************************/
package ejercicio08_26;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Ejercicio08_26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtenga una matriz 3 x 3 de valores dobles a partir de la entrada del usuario
		double[][] matrix = getMatrix();

		// Obtenga una nueva matriz ordenada
		double[][] sortedMatrix = sortRows(matrix);

		// Mostrar nueva matriz ordenada
		System.out.println("\nLa matriz clasificada por filas es");
		for (int i = 0; i < sortedMatrix.length; i++) {
			for (int j = 0; j < sortedMatrix.length; j++) {
				System.out.print(sortedMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/** getMatrix solicita al usuario que ingrese un 3 x 3
            matriz de valores dobles luego lo devuelve */
	public static double[][] getMatrix() {
		Scanner input = new Scanner(System.in);
		double[][] m = new double[3][3];

		System.out.println("Ingrese una matriz de 3 por 3 fila por fila:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextDouble();
			}
		}
		return m;
	}

	/** sortRows devuelve una nueva matriz ordenada dejando la matriz original intacta*/
	public static double[][] sortRows(double[][] m)  {
		// Crea una nueva matriz de 3 por 3
		double[][] s = new double[m.length][m[0].length];
		
		// Ccopiar elementos a la nueva matriz
		copyMatrix(m, s);

		//Ordenar nueva matriz por fila
		for (int row = 0; row < s.length; row++) {
			for (int col = 0; col < s.length - 1; col++) {
				double min = s[row][col];
				int index = col;
				for (int j = col + 1; j < s.length; j++) {
					if (min > s[row][j]) {
						min = s[row][j];
						index = j;
					}
				}
				if (index != col) {
					s[row][index] = s[row][col];
					s[row][col] = min;
				}
			}
		}
		return s;
	}

	/** copyMatrix copia todos los elementos en la matriz original a la copia*/ 
	public static void copyMatrix(double[][] original, double[][] copy) {
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[i].length; j++) {
				copy[i][j] = original[i][j];
			}
		}
	}
}