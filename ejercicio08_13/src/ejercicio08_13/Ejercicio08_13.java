/************************************************* ********************************
* (Ubique el elemento más grande) Escriba el siguiente método que devuelve *
* ubicación del elemento más grande en una matriz bidimensional. *
* *
* public static int [] locateLargest (double [] [] a) *
* *
* El valor de retorno es una matriz unidimensional que contiene dos elementos. Estas *
* dos elementos indican los índices de fila y columna del elemento más grande en el *
* matriz bidimensional. Escriba un programa de prueba que solicite al usuario ingresar un *
* matriz bidimensional y muestra la ubicación del elemento más grande en el *
* matriz *
************************************************** *******************************/
package ejercicio08_13;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Ejercicio08_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Indique al usuario que ingrese una matriz bidimensional
		System.out.print("Ingrese la cantidad de filas y columnas de la matriz: ");
		int row = input.nextInt();
		int column = input.nextInt();

		double[][] array = new double[row][column];

		System.out.println("Ingrese la matriz:");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.nextDouble();
			}
		}

		// Obtener la ubicación del elemento más grande
		int[] location = locateLargest(array);

		// Mostrar resultados
		System.out.println("La ubicación del elemento más grande está en(" +
			location[0] + ", " + location[1] + ")");
	}

	/**locateLargest devuelve la ubicación del
           elemento más grande en una matriz bidimensional*/
	public static int[] locateLargest(double[][] a) {
		int[] l = new int[2];
		l[0] = 0;
		l[1] = 0;
		double max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					l[0] = i;
					l[1] = j;
					max = a[i][j];
				}
			}
		}
		return l;
	}
}
