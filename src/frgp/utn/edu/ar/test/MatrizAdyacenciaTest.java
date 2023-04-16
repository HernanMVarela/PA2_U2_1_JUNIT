package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;

public class MatrizAdyacenciaTest {
	
	private final int CANTIDAD = 4;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(CANTIDAD);
	
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
		for(int i=0; i<=CANTIDAD-1; i++)
		{
		   for(int j=0; j<=CANTIDAD-1; j++)
			   if(matriz.existeElemento(i, j)==matriz.existeElemento(j, i) && matriz.existeElemento(i, j)==true)
				   cont++;
		}
		cont = cont/2;
		assertEquals(matriz.getCantidadElementos(),cont);
	}
	
	/// Punto F: existenTodosLosElementoTest
	@Test
	public void existenTodosLosElementoTest() {
		/// Arrange
		/// Recorre s�lo un lado de la matriz (Y evita la diagonal) y agrega 1 en el nodo y su sim�trico
		for(int i=0; i<CANTIDAD-1; i++) {
			for(int j=CANTIDAD-1; j>i; j--) {
				matriz.agregarElemento(i, j);
			}
		}
		/// Act
		/// Recorre el mismo patr�n del anterior y pregunta por el nodo y su opuesto
		boolean val = true;
		for(int i=0; i<CANTIDAD-1; i++) {
			for(int j=CANTIDAD-1; j>i; j--) {
				if(!matriz.existeElemento(i, j) || !matriz.existeElemento(j, i)){
					val = false;
				}
			}
		}
		/// Assert
		assertTrue(val);
	}
	
	/// Punto G: agregarElementoFilaNegativaTest
	@Test
	public void agregarElementoFilaNegativaTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			matriz.agregarElemento(-1, 0);
		});
	}
	
	/// Punto H: agregarElementoColumnaNegativaTest
	@Test
	public void agregarElementoColumnaNegativaTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			matriz.agregarElemento(0, -1);
		});
	}
	
	/// Punto I: agregarElementoFueraRangoTest
	@Test
	public void agregarElementoFueraRangoTest() throws ArrayIndexOutOfBoundsException {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			matriz.agregarElemento(5, 5);
		});
	}
}
