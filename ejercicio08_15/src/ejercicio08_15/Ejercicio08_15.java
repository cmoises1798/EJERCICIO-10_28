/************************************************* ********************************
* (Geometría: ¿la misma línea?) El ejercicio de programación 6.39 brinda un método para probar *
* si tres puntos están en la misma línea. *
* Escriba el siguiente método para comprobar si todos los puntos de la matriz apuntan *
* están en la misma línea. *
* *
* public static boolean sameLine (puntos dobles [] []) *
* *
* Escriba un programa que le pida al usuario que ingrese cinco puntos y visualice *
* si están en la misma línea. *
************************************************** *******************************/
package ejercicio08_15;

import java.util.Scanner;
/**
 *
 * @author user
 */
public class Ejercicio08_15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Crea una matriz de 5 x 2
		double[][] puntos = new double[5][2];

		// Indique al usuario que ingrese cinco puntos
		System.out.print("Ingrese cinco puntos: ");
		for (int i = 0; i < puntos.length; i++) {
			for (int j = 0; j < puntos[i].length; j++) {
				puntos[i][j] = input.nextDouble();
			}
		}
		
		// Mostrar si el punto en una matriz está en la misma línea
		System.out.println("Los cinco puntos son" + 
			(sameLine(puntos) ? " " : " no ") + "en la misma linea");	
	}

	/** sameLine prueba si todos los puntos en una matriz están en la misma línea*/
	public static boolean sameLine(double[][] points) {
		for (int i = 0; i < puntos.length - 2; i += 3) {
			if (pointPosition(puntos[i][0], puntos[i][1], puntos[i + 1][0], 
				puntos[i + 1][1], puntos[i + 2][0], puntos[i + 2][1]) != 0) {
				return false;
			}
		}
		return true;
	}

	/** pointPosition devuelve la posición de p2 a p0 y p1*/
	public static double pointPosition(double x0, double y0,
	double x1, double y1, double x2, double y2) {
		// Calcular la posición del punto
		return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	}
}