package ISO2.Pr3;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FuerzaGravitatoriaTest {

	@Test
    public void testCalcularFuerza_CasoNormal() {
        assertEquals(6.674e-8, FuerzaGravitatoria.calcularFuerza(50, 30, 10), 0.001);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testCalcularFuerza_DistanciaCero() {
        FuerzaGravitatoria.calcularFuerza(50, 30, 0);
    }
 
    @Test
    public void testCalcularFuerza_CasoInvalido_MasaNegativa() {
        assertEquals(0, FuerzaGravitatoria.calcularFuerza(-10, 20, 5), 0.001);
    }
 
    @Test
    public void testCalcularFuerza_CasoLimite_MasaCero() {
        assertEquals(0, FuerzaGravitatoria.calcularFuerza(0, 20, 5), 0.001);
    }
 
    @Test
    public void testCalcularFuerza_CasoLimite_DistanciaCero() {
        assertEquals(0, FuerzaGravitatoria.calcularFuerza(50, 30, 0), 0.001);
    }
 
    
    @Test
    public void testCalcularFuerza_Decimales() {
        assertEquals(1.234, FuerzaGravitatoria.calcularFuerza(12.34, 56.78, 90.12), 0.001);
    }
 
    @Test
    public void testCalcularFuerza_Caracteres() {
        try {
            FuerzaGravitatoria.calcularFuerza(Double.parseDouble("abc"), 20, 5);
            fail("Se esperaba NumberFormatException");
        } catch (NumberFormatException e) {
        }
    }
 
    @Test
    public void testCalcularFuerza_ValoresPequenos() {
        assertEquals(1.0e-20, FuerzaGravitatoria.calcularFuerza(1.0e-10, 2.0e-10, 3.0e-10), 0.001);
    }
 
    @Test
    public void testCalcularFuerza_ValoresGrandes() {
        assertEquals(1.0e20, FuerzaGravitatoria.calcularFuerza(1.0e10, 2.0e10, 3.0e10), 0.001);
    }
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    

    @Test
    public void testLeerNumeroValido() {
        provideInput("5.0");
        double result = InterfazPorComando.leerNumero("Ingrese un número");
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testLeerNumeroNoValidoYDespuesValido() {
        provideInput("abc\n10.5");
        double result = InterfazPorComando.leerNumero("Ingrese un número");
        assertEquals(10.5, result, 0.001);
    }

    @Test
    public void testImprimirMensaje() {
        InterfazPorComando.imprimirMensaje("¡Hola, mundo!");
        assertEquals("¡Hola, mundo!\n", outContent.toString());
    }

    @Test
    public void testImprimirMensajeVacio() {
        InterfazPorComando.imprimirMensaje("");
        assertEquals("\n", outContent.toString());
    }

    @Test
    public void testLeerMultiplesNumerosEnSecuencia() {
        provideInput("2.5\n7.8\n-3.0");
        double result1 = InterfazPorComando.leerNumero("Ingrese el primer número");
        double result2 = InterfazPorComando.leerNumero("Ingrese el segundo número");
        double result3 = InterfazPorComando.leerNumero("Ingrese el tercer número");

        assertEquals(2.5, result1, 0.001);
        assertEquals(7.8, result2, 0.001);
        assertEquals(-3.0, result3, 0.001);
    }

    @Test
    public void testLeerNumerosNoValidosYDespuesValido() {
        provideInput("xyz\nabc\n15.3");
        double result = InterfazPorComando.leerNumero("Ingrese un número");
        assertEquals(15.3, result, 0.001);
    }

    @Test
    public void testLeerNumeroDecimalNegativo() {
        provideInput("-8.75");
        double result = InterfazPorComando.leerNumero("Ingrese un número");
        assertEquals(-8.75, result, 0.001);
    }

    @Test
    public void testLeerNumeroEnteroPositivo() {
        provideInput("42");
        double result = InterfazPorComando.leerNumero("Ingrese un número");
        assertEquals(42, result, 0.001);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
 
    
}
