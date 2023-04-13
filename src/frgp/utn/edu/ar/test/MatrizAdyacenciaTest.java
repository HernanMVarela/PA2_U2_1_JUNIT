package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {
	
	private int cantidad = 4;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(cantidad);
	
	/// Punto A: agregarElementoTest
	@Test
    public void agregarElementoTest() {
		/// Arrange 
        matriz.agregarElemento(1, 2); 
		/// Act
		boolean check = matriz.existeElemento(1, 2);
		/// Assert
		assertTrue(check);
    }
	
	/// Punto B: agregarElementoSimetriaTest
	@Test
	public void agregarElementoSimetriaTest() {		
		/// Arrange 
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
	@Test
	public void eliminarElementoSimetricoTest() {
		/// Arrange
		matriz.agregarElemento(2,3);
		matriz.eliminarElemento(2,3);
		/// Act
		boolean check = matriz.existeElemento(3,2);
		/// Assert
		assertFalse(check);
	}
	
	/// Punto E: contarRelacionesTest
	@Test
	public void contarRelacionesTest() {
		matriz.agregarElemento(0, 1);
		matriz.agregarElemento(1, 2);
		matriz.agregarElemento(2, 2);
		int cont=0;
		for(int i=0; i<=Cantidad-1; i++)
		{
		   for(int j=0; j<=Cantidad-1; j++)
			   if(matriz.existeElemento(i, j)==matriz.existeElemento(j, i) && matriz.existeElemento(i, j)==true)
				   cont++;
		}
		cont = cont/2;
		assertEquals(matriz.getCantidadElementos(),cont);
	}
	
	/// Punto F: existenTodosLosElementoTest
	
	/// Punto G: agregarElementoFilaNegativaTest
		
	/// Punto H: agregarElementoColumnaNegativaTest
	
	/// Punto I: agregarElementoFueraRangoTest
	
}
