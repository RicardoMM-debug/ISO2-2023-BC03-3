package ISO2.Pr3;

public class Main {

	public static void main(String[] args) {
        try {
            double masa1 = InterfazPorComando.leerNumero("Introduce la masa del primer cuerpo (kg)");
            double masa2 = InterfazPorComando.leerNumero("Introduce la masa del segundo cuerpo (kg)");
            double distancia = InterfazPorComando.leerNumero("Introduce la distancia entre los cuerpos (m)");
 
            double fuerza = FuerzaGravitatoria.calcularFuerza(masa1, masa2, distancia);
 
            InterfazPorComando.imprimirMensaje("La fuerza de atracción gravitatoria es: " + fuerza + " N");
        } catch (Exception e) {
        	InterfazPorComando.imprimirMensaje("Error: " + e.getMessage());
        }
    }
}
