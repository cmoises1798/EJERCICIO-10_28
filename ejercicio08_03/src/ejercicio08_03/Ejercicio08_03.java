/************************************************* ********************************
* (Ordenar estudiantes en calificaciones) Reescribir el Listado 8.2, GradeExam.java, para mostrar el *
* estudiantes en orden creciente del número de respuestas correctas. *
************************************************** *******************************/
package ejercicio08_03;

/**
 *
 * @author user
 */
public class Ejercicio08_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Respuestas de los estudiantes a las preguntas
		char[][] preguntas = {
			{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
			{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
			{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
			{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

		// Clave para las preguntas
		char [] claves = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

		// Número de alumnos y respuestas correctas
		int[][] conteocorrecto = new int[preguntas.length][2];

		// Calificar todas las respuestas
		for (int i = 0; i < preguntas.length; i++) {
			// Estudiante de primer grado
			for (int j = 0; j < preguntas[i].length; j++) {
				if (preguntas[i][j] == claves[j]) {
					conteocorrecto[i][0] = i;
					conteocorrecto[i][1]++;
				}
			}

		}

		// Ordenar en orden creciente de la cantidad de respuestas correctas.
		sort(conteocorrecto);

		// Display sorted matrix
		for (int row = 0; row < conteocorrecto.length; row++) {
			System.out.println("Student " + conteocorrecto[row][0] + 
				"'s correct count is " + conteocorrecto[row][1]);
		}
	}

	/** ordenado por columna 1 en orden ascendente*/
	public static void sort(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			// Encuentra el mínimo en la columna1
			int minCol1 = m[i][1];
			int minCol0 = m[i][0];
			int minIndex = i;

			for (int j = i + 1; j < m.length; j++) {
				if (minCol1 > m[j][1]) {
					minCol1 = m[j][1];
					minCol0 = m[j][0];
					minIndex = j;
				}
			}

			// Intercambiar
			if (minIndex != i) {
				m[minIndex][1] = m[i][1];
				m[minIndex][0] = m[i][0];
				m[i][1] = minCol1;
				m[i][0] = minCol0;
			}
		}
	}
}
