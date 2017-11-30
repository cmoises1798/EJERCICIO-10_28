/************************************************* ********************************
* (Aplicación financiera: impuesto de cálculo) Reescribe el Listado 3.5, ComputeTax.java, *
* usando arreglos. Para cada estado civil, existen seis tasas impositivas. Cada tasa es *
* aplicado a una cierta cantidad de ingresos imponibles. Por ejemplo, del sujeto pasivo *
* ingreso de $ 400,000 para un solo declarante, $ 8,350 está gravado al 10%, (33,950 - 8,350) *
* al 15%, (82,250 - 33,950) al 25%, (171,550 - 82,550) al 28%, (372,550 - 82,250) *
* al 33% y (400,000 - 372,950) al 36%. Las seis tarifas son las mismas para todos *
* estados de archivo, que se pueden representar en el siguiente conjunto: *
* *
* double [] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35}; *
* *
* Los corchetes para cada tasa para todos los estados de archivo se pueden representar en un *
* matriz bidimensional de la siguiente manera: *
* int [] [] corchetes = {*
* {8350, 33950, 82250, 171550, 372950}, // Single filer *
* {16700, 67900, 137050, 20885, 372950}, // Casado conjuntamente *
* // -o viuda calificadora (er) *
* {8350, 33950, 68525, 104425, 186475}, // Casado por separado *
* {11950, 45500, 117450, 190200, 372950} // Jefe de hogar *
*}; *
* *
* Supongamos que el ingreso gravable es de $ 400,000 para declarantes individuales. El impuesto puede ser *
* calculado de la siguiente manera: *
* *
* impuesto = corchetes [0] [0] * tasas [0] + *
* (corchetes [0] [1] - corchetes [0] [0]) * tasas [1] + *
* (corchetes [0] [2] - corchetes [0] [1]) * tasas [2] + *
* (corchetes [0] [3] - corchetes [0] [2]) * tasas [3] + *
* (corchetes [0] [4] - corchetes [0] [3]) * índices [4] + *
* (400000 - paréntesis [0] [4]) * tasas [5] *
************************************************** *******************************/
package ejercicio08_12;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ejercicio08_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un Scanner
		Scanner input = new Scanner(System.in);

		// Las tasas de impuestos
		double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

		// Los corchetes para cada tasa para todos los estados de presentación
		int[][] corchetes = {
			{8350, 33950, 82250, 171550, 372950},  // Single filer
			{16700, 67900, 137050, 20885, 372950}, // Casado conjuntamente
																// -or qualifying widow(er)
			{8350, 33950, 68525, 104425, 186475},  // Casado por separado
			{11950, 45500, 117450, 190200, 372950} // Jefe de hogar
		};
			
		// Pedir al usuario que ingrese el estado civil
		System.out.print("(0-single filer, 1-married jointly o \"+\n" +
                                 "\"viuda elegible (er), 2-casado por separado, 3-jefe de\" +\n" +
                                 "\"hogar\" Ingrese el estado civil para la declaración: ");
		int status = getStatus();

		// Indique al usuario que ingrese ingresos gravables
		System.out.print("Ingrese el ingreso gravable: ");
		double income = input.nextDouble();


		// Mostrar el resultado
		System.out.printf("El impuesto es $%6.2f\n", 
			computeTax(corchetes, rates, status, income)); 
	}

	/** computeTax calcula y devuelve el total
            impuesto para los paréntesis del estado civil */
	public static double computeTax(int[][] corchetes, double[] rates,
		int status, double income) {
		double tax = 0, incomeTaxed = 0;
		for (int i = 4; i >= 0; i--) {
			if (income > corchetes[status][i])
 				tax += (incomeTaxed = income - corchetes[status][i]) * rates[i + 1];
				income -= incomeTaxed;
		} 
		return tax += corchetes[status][0] * rates[0];
	}

	/** getStatus devuelve un estado válido */
	public static int getStatus(){
		Scanner input = new Scanner(System.in);
		int status;
		do {
			status = input.nextInt();
			if (status < 0 || status > 3)
				System.out.println("Error: estado no válido");
		} while (status < 0 || status > 3);
		return status;
	}
}