package ISO2.Pr3;


class FuerzaGravitatoria {
	
 private static final double G = 6.674 * Math.pow(10, -11);

 public static double calcularFuerza(double masa1, double masa2, double distancia) {
     if (distancia == 0) {
         throw new IllegalArgumentException("La distancia no puede ser cero.");
     }
     return (G * masa1 * masa2) / Math.pow(distancia, 2);
 }
}
