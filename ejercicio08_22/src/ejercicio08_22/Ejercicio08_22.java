/************************************************* ********************************
* (Número par de 1s) Escriba un programa que genere un 6-por-6 bidimensional *
* matriz llena de 0s y 1s, muestra la matriz y verifica si cada fila y *
* cada columna tiene un número par de 1s. *
************************************************** *******************************/
package ejercicio08_22;

/**
 *
 * @author user
 */
public class Ejercicio08_22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Genera una matriz 6 por 6 y la muestra
		int[][] matrix = new int[6][6];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * 2);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		// Mostrar si cada fila y cada columna tienen un número par de 1s
		System.out.println("Every row" + 
			(isAllRowsEven1s(matrix) ? " " : " does not " + 
				"have an even number of 1s"));
		System.out.println("Every column" + 
			(isAllColumnsEven1s(matrix) ? " " : " does not " + 
				"have an even number of 1s"));
	}

	/** isAllRowsEven1s devuelve verdadero es que cada fila tiene un número par de 1s */
	public static boolean isAllRowsEven1s(int[][] m) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1)
					count++;
			}
			if (count % 2 != 0)
				return false;
		}
		return true;
	}

	/** isAllColumnsEven1s devuelve verdadero es que cada columna tiene un número par de 1s*/
	public static boolean isAllColumnsEven1s(int[][] m) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[j][i] == 1)
					count++;
			}
			if (count % 2 != 0)
				return false;
		}
		return true;
	}
}