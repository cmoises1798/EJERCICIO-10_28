/************************************************* ********************************
* (Álgebra: agregue dos matrices) Escriba un método para agregar dos matrices. El encabezado de *
* el método es como sigue: *
* *
* public static double [] [] addMatrix (double [] [] a, double [] [] b) *
* *
* Para ser agregado, las dos matrices deben tener las mismas dimensiones y el *
* tipos de elementos iguales o compatibles. Deje c ser la matriz resultante. Cada *
* elemento cij es aij + bij. *
* Escriba un programa de prueba que solicite al usuario ingresar dos matrices 3 * 3 y *
* muestra su suma. *
************************************************** *******************************/
package ejercicio08_05;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Inicializa dos matrices de 3 x 3
		double[][] matrix1 = getmatrix(1);
		double[][] matrix2 = getmatrix(2);

		// Inicializa matrix3 con la suma de matrix1 y matrix2
		double[][] matrix3 = addMatrix(matrix1, matrix2);

		// Visualizar matrix1, matrix2 y matrix3
		print(matrix1, matrix2, matrix3);
	}

	/** getmatrix */
	public static double[][] getmatrix(int n) {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Indique al usuario que ingrese una matriz de 3 x 3
		System.out.print("Ingresar matriz" + n + ": ");

		double[][] m = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				m[i][j] = input.nextDouble();
		}

		return m;
	}

	/** addMatrix agrega dos matrices y devuelve el resultado */
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double[][] c = new double[3][3];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	/** print muestra todos los elementos en la fila r */
	public static void print(double[][] m, int r) {	
		for (int j = 0; j < m[r].length; j++) {
			System.out.print(m[r][j] + " ");
		}	
	}

	/**impresión muestra resultados*/
	public static void print(double[][] m1, double[][] m2, double[][] m3) {
		System.out.println("Las matrices se agregan de la siguiente manera");
		
		for (int i = 0; i < 3; i++) {
			print(m1, i);
			System.out.print((i == 1 ? "  +  " : "     "));
			print(m2, i);
			System.out.print((i == 1 ? "  =  " : "     "));
			print(m3, i);
			System.out.println();
		}
	}
}
