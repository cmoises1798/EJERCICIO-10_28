/************************************************* ********************************
* (Ordenar matriz bidimensional) Escribir un método para ordenar una matriz bidimensional *
* usando el siguiente encabezado: *
* *
* clasificación vacía pública estática (int m [] []) *
* *
* El método realiza una clasificación primaria en filas y una ordenación secundaria en iumns. *
* Por ejemplo, la siguiente matriz *
* *
* {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}} *
* *
* se ordenarán en *
* *
* {{1, 1}, {1, 2}, {1, 7}, {4, 1}, {4, 2}, {4, 5}}. *
************************************************** *******************************/
package ejercicio08_18;

/**
 *
 * @author user
 */
public class Ejercicio08_18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializar Matriz
		int[][] array = {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}};

		// ordenar matriz
		sort(array);

		// Mostrar matriz ordenada
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
	}

	// ordenar ordena una matriz primaria en filas y secundaria en columnas */
	public static void sort(int m[][]) {
		int[] min = new int[2];
		for (int row = 0; row < m.length - 1; row++) {
			min[0] = m[row][0]; 
			min[1] = m[row][1]; 
			int index = row;
			for (int i = row + 1; i < m.length; i++) {
				if (m[i][0] <= min[0] && (m[i][0] < min[1] || 
					 m[i][1] < min[0] || m[i][1] < min[1])) { 
					min[0] = m[i][0];
					min[1] = m[i][1];
					index = i;
				}
			}
			if (index != row){
				m[index][0] = m[row][0];
				m[index][1] = m[row][1];
				m[row][0] = min[0];
				m[row][1] = min[1]; 
			}
		}
	}
}