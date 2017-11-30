/************************************************* ********************************
* (Juego: juega un juego de tic-tac-toe) En un juego de tres en raya, dos jugadores toman *
* convierte marcando una celda disponible en una cuadrícula de 3 * 3 con sus tokens respectivos *
* (ya sea X o O). Cuando un jugador ha colocado tres fichas en una posición horizontal, *
* fila vertical o diagonal en la grilla, el juego ha terminado y ese jugador tiene *
* ganado Un sorteo (sin ganador) ocurre cuando todas las celdas de la cuadrícula se han llenado *
* con tokens y ninguno de los jugadores ha logrado una victoria. Crea un programa para *
* jugando tic-tac-toe. El programa solicita dos jugadores para ingresar un token X *
* y O token alternativamente. Cada vez que se ingresa un token, el programa vuelve a mostrar *
* la placa en la consola y determina el estado del juego (ganar, dibujar o *
* continuar). *
************************************************** *******************************/
package ejercicio08_09;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Crea un tablero vacío
		String [][] board = getBoard();

		// Crear dos fichas de jugador
		String[] tokens = {" X "," O "};

		int result; // resultado del estado del juego

		// Repite mientras el resultado continúa
		do {
			// Tablero de visualización
			print(board);

			// Obtener celular disponible para marcar
			int[] cell = getCell(board, tokens[0]);
			
			// Marque la celda disponible con la ficha del jugador
			placeToken(board, cell, tokens[0]);
	
			// Determinar el estado del juego
			result = gameStatus(board, tokens[0]);

			// Si el estado es continuar, haz que el siguiente jugador se vuelva
			if (result == 2) {
				swap(tokens);
			}

		} while(result == 2);

		// Tablero de visualización
		print(board);

		//Mostrar resultados del juego
		if (result == 0)
			System.out.println(tokens[0] + "jugador ganado");
		else
			System.out.println("Jugadores empatados");

	}

	/** gameStatus determina el estado del juego (ganar, empatar o continuar) */
	public static int gameStatus(String[][] m, String e) {
		if (isWin(m, e))
			return 0; // Ganar
		else if (isDraw(m))
			return 1; // Empatar
		else
			return 2; // Continuar
	}

	/** isWin devuelve verdadero si el jugador ha colocado tres fichas en,
             una fila horizontal vertical o diagonal en la grilla */
	public static boolean isWin(String[][] m, String t) { 
		return isHorizontalWin(m, t) || isVerticalWin(m, t) || isDiagonalWin(m, t);
	}

	/** isHorizontalWin devuelve verdadero si el jugador tiene
              colocado tres fichas en una fila horizontal */
	public static boolean isHorizontalWin(String[][] m, String t) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == t)
					count++;
			}
			if (count == 3)
				return true;
		}
		return false;
	}

	/** isVerticalWin devuelve verdadero si el jugador tiene
              colocó tres fichas en una fila vertical*/
	public static boolean isVerticalWin(String[][] m, String t) {
		for (int i = 0; i < m.length; i++) {
			int count = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (m[j][i] == t)
					count++;
			}
			if (count == 3)
				return true;
		}
		return false;
	}

	/** isDiagonalWin devuelve verdadero si el jugador tiene
              colocado tres fichas en una fila diagonal */
	public static boolean isDiagonalWin(String[][] m, String t) {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i][i] == t)
				count++;
			if (count == 3)
				return true;
		}

		count = 0;
		for (int i = 0, j = m[i].length - 1; j >= 0 ; j--, i++) {
			if (m[i][j] == t)
				count++;
			if (count == 3)
				return true;
		}
		return false;
	}

	/** isDraw devuelve verdadero si todas las celdas en la grilla han sido
             lleno de tokens y ninguno de los jugadores ha logrado una victoria */
	public static boolean isDraw(String[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == "   ")
					return false;
			}
		}
		return true;
	}

	/** swap intercambia los elementos en una matriz*/
	public static void swap(String[] p) {
		String temp = p[0];
		p[0] = p[1];
		p[1] = temp;
	}

	/** placeToken llena la celda de la matriz con la ficha del jugador */
	public static void placeToken(String[][] m, int[] e, String t) {
		m[e[0]][e[1]] = t;
	}

	/** getCell devuelve una entrada de celda válida por usuario */
	public static int[] getCell(String[][] m, String t) {
		// Crear un Scanner
		Scanner input = new Scanner(System.in);
		int[] cell = new int[2]; // Fila y columna de celda

		// Preguntar al jugador para ingresar una ficha
		do {
			System.out.print("Ingrese una fila(0, 1 o 2) para el jugador " + t + ": ");
			cell[0] = input.nextInt();
			System.out.print("Ingrese una columna(0, 1 o 2) para el jugador " + t + ": ");
			cell[1] = input.nextInt();

		} while (!isValidCell(m, cell));
		return cell;
	}

	/** isValid Cell devuelve verdadero si la celda está vacía y está en una matriz de 3 x 3 */
	public static boolean isValidCell(String[][] m, int[] cell) {
		for (int i = 0; i < cell.length; i++) {
			if (cell[i] < 0 || cell[i] >= 3) {
				System.out.println("Celda inválida");
				return false;
			}
		}
		if (m[cell[0]][cell[1]] != "   ") {
			System.out.println(
				"\nRow " + cell[0] + " columna " + cell[1] + " está lleno");
			return false;
		}
		return true;		
	}

	/** getBoard devuelve una matriz de 3 x 3 llena de espacios en blanco */
	public static String[][] getBoard() {
		String[][] m = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = "   ";
			}
		}
		return m;
	}

	/** imprimir muestra el tablero */
	public static void print(String[][] m) {
		System.out.println("\n-------------");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print("|" + m[i][j]);
			}
			System.out.println("|\n-------------");
		}
	}
}