/************************************************** *******************************
* (Fila y columna más grandes) Escriba un programa que rellene al azar 0 y 1 en *
* una matriz de 4 por 4, imprime la matriz y encuentra la primera fila y columna con *
* la mayor cantidad de 1s. *
************************************************** *******************************/
package ejercicio08_10;

/**
 *
 * @author user
 */
public class Ejercicio08_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una matriz de 4 por 4
		int[][] matrix = new int[4][4];
 
 		// llena aleatoriamente la matriz con 0s y 1s
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random() * 2);
			}
		}

		// Muestra la matriz
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		
		// Busque y muestre la primera fila y la columna con más 1s
		System.out.println("El índice de fila más grande: " + largestRow(matrix));
		System.out.println("La columna de fila más grande: " + largestColumn(matrix));

	}

	/** largeRow encuentra la primera fila con más 1s */
	public static int largestRow(int[][] m) {
		int maxRowIndex = 0;
		int max = 0;
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1)
					count++;
			}
			if (count > max) {
				max = count;
				maxRowIndex = i;
			}
		}
		return maxRowIndex;
	}

	/** largestColumn encuentra la primera columna con más 1s*/
	public static int largestColumn(int[][] m) {
		int maxColumnIndex = 0;
		int max = 0;
		for (int col = 0; col < m[0].length; col++) {
			int count = 0;
			for (int row = 0; row < m.length; row++) {
				if (m[row][col] == 1)
					count++;
			}
			if (count > max) {
				max = count;
				maxColumnIndex = col;
			}
		}
		return maxColumnIndex;
	}
}