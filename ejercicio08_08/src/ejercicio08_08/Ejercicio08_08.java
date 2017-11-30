/************************************************* ********************************
* (Todos los pares de puntos más cercanos) Modifique el listado 8.3, FindNearestPoints.java, a *
* muestra todos los pares más cercanos de puntos con la misma distancia mínima. *
************************************************** *******************************/
package ejercicio08_08;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de puntos: ");
		int numberOfPoints = input.nextInt();

		// Crear una matriz para almacenar puntos
		double[][] points = new double[numberOfPoints][2];
		System.out.print("Ingresar " + numberOfPoints + " puntos: ");
		for (int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}

		// p1 y p2 son los índices en la matriz de puntos
		int p1 = 0, p2 = 1; // Dos puntos iniciales
		double shortestDistance = distance(points[p1][0], points[p1][1],
			points[p2][0], points[p2][p1]); // Inicializa la distancia más corta

		// Calcule la distancia por cada dos puntos
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1],
					points[j][0], points[j][1]); // Encontrar distancia

				if (shortestDistance > distance) {
					p1 = i; // Actualización p1
					p2 = j; // Actualización p2
					shortestDistance = distance; // Actializacion shortestDistance
				}
			}
		}

		// Mostrar resultado
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (distance(points[i][0], points[i][1],
					points[j][0], points[j][1]) == shortestDistance)
					System.out.println("Los dos puntos más cercanos son " +
						"(" + points[i][0] + ", " + points[i][1] + ") y (" +
							points[j][0] + ", " + points[j][1] + ")");
			}
		}
		System.out.println("La distancia es" + shortestDistance);
	}

	/** Calcule la distancia entre dos puntos (x1, y1) y (x2, y2) */
	public static double distance(
		double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}