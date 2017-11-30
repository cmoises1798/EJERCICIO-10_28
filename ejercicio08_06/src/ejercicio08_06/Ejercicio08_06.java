/************************************************* ********************************
* (Algebra: multiplica dos matrices) Escribe un método para multiplicar dos matrices. Los *
* el encabezado del método es: *
* *
* public static double [] [] multiplyMatrix (double [] [] a, double [] [] b) *
* *
* Para multiplicar la matriz a por la matriz b, el número de columnas en a debe ser el mismo *
* como el número de filas en b, y las dos matrices deben tener elementos del mismo *
* o tipos compatibles. Deje c ser el resultado de la multiplicación. Supongamos que *
* el tamaño de columna de la matriz a es n. Cada elemento cij es ai1 * b1j + ai2 * b2j + ... *
* + ain * bnj. *
* *
* Escriba un programa de prueba que solicite al usuario ingresar dos matrices 3 * 3 y *
* muestra su producto. *
************************************************** *******************************/
package ejercicio08_06;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializa dos matrices de 3 x 3
		double[][] matrix1 = getmatrix(1);
		double[][] matrix2 = getmatrix(2);

		// Inicializa matrix3 con la multiplicación de matrix1 y matrix2
		double[][] matrix3 = multiplyMatrix(matrix1, matrix2);

		// Visualizar matrix1, matrix2 y matrix3
		print(matrix1, matrix2, matrix3);
	}

	/** getmatrix */
	public static double[][] getmatrix(int n) {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Indique al usuario que ingrese una matriz de 3 x 3
		System.out.print("Ingresar Matriz" + n + ": ");

		double[][] m = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				m[i][j] = input.nextDouble();
		}

		return m;
	}

	/** multiplyMatrix multiplica dos matrices y devuelve el resultado */
	public static double[][] multiplyMatrix(double[][] a, double[][] b) {
		double[][] c = new double[3][3];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				for (int h = 0; h < c.length; h++) {
					c[i][j] += a[i][h] * b[h][j];
				}
			}
		}
		return c;
	}


	/** print muestra todos los elementos en la fila r*/
	public static void print(double[][] m, int r) {	
		for (int j = 0; j < m[r].length; j++) {
			System.out.printf("%5.1f", m[r][j]);
		}	
	}

	/** print muestra resultados */
	public static void print(double[][] m1, double[][] m2, double[][] m3) {
		System.out.println("Las matrices se agregan de la siguiente manera");
		
		for (int i = 0; i < 3; i++) {
			print(m1, i);
			System.out.print((i == 1 ? "   * " : "     "));
			print(m2, i);
			System.out.print((i == 1 ? "   = " : "     "));
			print(m3, i);
			System.out.println();
		}
	}
}