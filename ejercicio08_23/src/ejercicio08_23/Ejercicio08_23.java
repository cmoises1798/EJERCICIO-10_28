/************************************************* ********************************
* (Juego: encuentra la celda volteada) Supongamos que te dan una matriz de 6 por 6 *
* con 0s y 1s. Todas las filas y todas las columnas tienen un número par de 1s. Deja el *
* el usuario voltea una celda (es decir, cambia de 1 a 0 o de 0 a 1) y escribe un programa *
* para encontrar qué celda fue volteada. Su programa debe solicitar al usuario que ingrese un *
* Matriz de 6 por 6 con 0s y 1s y encuentre la primera fila ry la primera columna c donde *
* se infringe el número par de la propiedad 1s (es decir, el número de 1s no es *
* incluso). La celda volteada está en (r, c). *
************************************************** *******************************/
package ejercicio08_23;

/**
 *
 * @author user
 */
public class Ejercicio08_23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Indique al usuario que ingrese una matriz de 6 por 6
		System.out.println("Ingrese una matriz de 6 por 6 fila por fila:");
		int[][] matrix = getMatrix();

		// Encuentre la primera fila ry la primera columna c donde 
		// se infringe el número par de la propiedad 1s
		int row = oddRow1s(matrix);
		int column = oddColumn1s(matrix);

		// Mostrar la celda volteada
		if (row < 0 || column < 0)
			System.out.println("Ninguna celda ha sido volteada");
		else {
			System.out.println(
				"La celda volteada está en (" + row + ", " + column + ")");
		}
	}

	/** getMatrix inicializa y devuelve una matriz de 6 x 6 de entrada del usuario */
	public static int[][] getMatrix() {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);
		// Crea una matriz de 6 x 6
		int[][] m = new int[6][6];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = input.nextInt();
			}
		}
		return m;
	}

	/** oddRow1s devuelve índice de fila con número impar de 1s */
	public static int oddRow1s(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1)
					count++;
			}
			if (count % 2 != 0)
				return i;
		}
		return -1;
	}

	/** oddColumn1s devuelve el índice de la columna con un número impar de 1s*/
	public static int oddColumn1s(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m.length; j++) {
				if (m[j][i] == 1)
					count++;
			}
			if (count % 2 != 0)
				return i;
		}
		return -1;
	}
}