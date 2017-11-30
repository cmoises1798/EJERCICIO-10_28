/************************************************* ********************************
* (Puntos más cercanos entre sí) El Listado 8.3 brinda un programa que encuentra dos *
* puntos en un espacio bidimensional más cercano el uno al otro. Revise el programa así que *
* que encuentra dos puntos en un espacio tridimensional más cercano el uno al otro. *
* Use una matriz bidimensional para representar los puntos. Pruebe el programa usando *
* los siguientes puntos: *
* double [] [] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, *
* {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2}, *
* {5.5, 4, -0.5}}; *
* La fórmula para calcular la distancia entre dos puntos (x1, y1, z1) y *
* (x2, y2, z2) es √ (x2 - x1) ^ 2 + (y2 - y1) ^ 2 + (z2 - z1) ^ 2. *
************************************************** *******************************/
package ejercicio08_07;

/**
 *
 * @author user
 */
public class Ejercicio08_07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // Inicializar matriz con puntos
		double[][] puntos = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},                      
			{2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},                          
			{5.5, 4, -0.5}};

		// p1 y p2 son los índices en la matriz de puntos
		int p1 = 0, p2 = 1, p3 = 3; // Dos puntos iniciales
		double distanciacorta = distance(puntos[p1][0], puntos[p1][1], puntos[p1][2],
			puntos[p2][0], puntos[p2][p1], puntos[p3][p2]); // Inicializa la distancia más corta

		// Calcule la distancia por cada dos puntos
		for (int i = 0; i < puntos.length; i++) {
			for (int j = i + 1; j < puntos.length; j++) {
				double distancia = distance(puntos[i][0], puntos[i][1], puntos[i][2],
					puntos[j][0], puntos[j][1], puntos[j][2]); // Encontrar distancia

				if (distanciacorta > distancia) {
					p1 = i; // Actualización p1
					p2 = j; // Actualización p2
					distanciacorta = distancia; // Actualizar distanciacorta
				}
			}
		}

		// Mostrar resultado
		System.out.println("Los dos puntos más cercanos son " +
			"(" + puntos[p1][0] + ", " + puntos[p1][1] + ") y (" +
				puntos[p2][0] + ", " + puntos[p2][1] + ")");
	}

	/** Calcule la distancia entre dos puntos (x1, y1) y (x2, y2) */
	public static double distance(
		double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) +  
			Math.pow(y2 - y1, 2) + Math.pow(y2 - y1, 2));
	}
}
