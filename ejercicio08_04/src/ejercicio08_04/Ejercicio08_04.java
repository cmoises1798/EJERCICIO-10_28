/************************************************* ********************************
* (Calcule las horas semanales para cada empleado) Supongamos que las horas semanales para todos *
* los empleados se almacenan en una matriz bidimensional. Cada fila registra el * de un empleado
* horas de trabajo de siete días con siete columnas. Por ejemplo, el siguiente *
* array almacena las horas de trabajo para ocho empleados. Escriba un programa que muestre *
* empleados y sus horas totales en orden decreciente del total de horas. *
************************************************** *******************************/
package ejercicio08_04;

/**
 *
 * @author user
 */
public class Ejercicio08_04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // Inicializar la matriz 7-por-7 con datos
		int[][] weeklyHours = { {2, 4, 3, 4, 5, 8, 8},
		             {7, 3, 4, 3, 3, 4, 4},
			     {3, 3, 4, 3, 3, 2, 2},
			     {9, 3, 4, 7, 3, 4, 1},
			     {3, 5, 4, 3, 6, 3, 8},
                             {3, 4, 4, 6, 3, 4, 4},
                             {3, 7, 4, 8, 3, 8, 4},
                             {6, 3, 5, 9, 2, 7, 9},};

		// Inicializar la matriz de 7 por 2 con el total de horas de cada empleado
		int[][] Horastotales = sumRows(weeklyHours);

		// Ordenar matriz en orden decreciente del total de horas
		sort(Horastotales);

		// Mostrar resultados
		print(Horastotales);
	}

	/** sumRows devuelve una matriz con el total de cada fila */
	public static int[][] sumRows(int[][] m) {
		// Crear una matriz de 7 por 2
		int[][] totales = new int[m.length][2];

		for (int row = 0; row < m.length; row++) {
			totales[row][0] = row;
			totales[row][1] = 0;
			for (int col = 0; col < m[row].length; col++) {
				totales[row][1] += m[row][col];
			}	
		}
		return totales;
	}

	/** ordenar ordena una matriz en orden decreciente de la columna 1*/
	public static void sort(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			// Encuentra el máximo de la columna 1
			int maxCol0 = m[i][0];
			int maxCol1 = m[i][1];
			int maxIndex = i;

			for (int j = i + 1; j < m.length; j++) {
				if (maxCol1 < m[j][1]) {
					maxCol1 = m[j][1];
					maxCol0 = m[j][0];
					maxIndex = j;
				}
			}

			// Intercambiar
			if (i != maxIndex) {
				m[maxIndex][1] = m[i][1];
				m[maxIndex][0] = m[i][0];
				m[i][1] =  maxCol1;
				m[i][0] =  maxCol0;
			}
		}
	}

	/** print muestra la tabla de empleados y sus horas totales */
	public static void print(int[][] m) {
		System.out.println("Horas     semanales del empleado");
		System.out.println("-------------------------");
		for (int fila = 0; fila < m.length; fila++) {
				System.out.printf("%4d%16d\n", m[fila][0],Horastotales[fila][1]);
		}	
	}
}