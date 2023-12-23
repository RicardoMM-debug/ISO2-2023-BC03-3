package ISO2.Pr3;

import java.util.Scanner;

public class InterfazPorComando {

	private static Scanner TECLADO = new Scanner(System.in);

	public static double leerNumero(String mensaje) {
		System.out.print(mensaje + ": ");
		while (!TECLADO.hasNextDouble()) {
			System.out.println("¡Entrada inválida! Introduce un número.");
			TECLADO.nextLine();
		}
		return TECLADO.nextDouble();
	}

	public static void imprimirMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
