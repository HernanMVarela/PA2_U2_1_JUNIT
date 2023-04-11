package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {
	
	private int cantidad = 4;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(Cantidad);
	
	/// Punto A: agregarElementoTest
	@Test
    public void agregarElementoTest() {
        //MatrizAdyacencia matriz = new MatrizAdyacencia(3); 
        matriz.agregarElemento(1, 2); 
        assertTrue(matriz.existeElemento(1, 2)); 
    }
	
	/// Punto B: agregarElementoSimetriaTest
	@Test
	public void agregarElementoSimetriaTest() {
		
		/// Arrange 
		//MatrizAdyacencia matriz = new MatrizAdyacencia(4); 
		matriz.agregarElemento(2, 3);
		/// Act
		boolean check = matriz.existeElemento(3, 2);
		/// Assert
		assertTrue(check);
	}
	/// Punto C: eliminarElementoTest
	@Test
	public void eliminarElementoTest() {
		/// Arrange
		matriz.agregarElemento(1,0);
		matriz.eliminarElemento(1,0);
		/// Act
		boolean check = matriz.existeElemento(1,0);
		/// Assert
		assertFalse(check);
	}
	
	/// Punto D: eliminarElementoSimetricoTest
	
	/// Punto E: contarRelacionesTest
	
	/// Punto F: existenTodosLosElementoTest
	
	/// Punto G: agregarElementoFilaNegativaTest
	
	/// Punto H: agregarElementoColumnaNegativaTest
	
	/// Punto I: agregarElementoFueraRangoTest
	
}
