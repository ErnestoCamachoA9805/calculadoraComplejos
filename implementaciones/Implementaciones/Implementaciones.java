package Implementaciones;

import edu.eci.cnyt.complex.*;

public class Implementaciones {
	
	public VectorComplejo primerMetodo(MatrizCompleja matriz, VectorComplejo vector, int clicks) {
		VectorComplejo vectorFinal= null;
		try {
			for (int i=0; i< clicks;i++) {
				if ( i== 0 ){
					vectorFinal= matriz.productoMatrizVector(vector);
				}
				else {
					vectorFinal= matriz.productoMatrizVector(vectorFinal);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		return vectorFinal;
		}
		
	}
	
	public VectorComplejo segundoMetodo(MatrizCompleja matriz, VectorComplejo vector, int clicks) {
		VectorComplejo vectorFinal= null;
		try {
			for (int i=0; i< clicks;i++) {
				if ( i== 0 ){
					vectorFinal= matriz.productoMatrizVector(vector);
				}
				else {
					vectorFinal= matriz.productoMatrizVector(vectorFinal);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		return vectorFinal;
		}
		
	}

	public VectorComplejo tercerMetodo(MatrizCompleja matriz, VectorComplejo vector, int clicks) {
		VectorComplejo vectorFinal= null;
		try {
			for (int i=0; i< clicks;i++) {
				if ( i== 0 ){
					vectorFinal= matriz.productoMatrizVector(vector);
				}
				else {
					vectorFinal= matriz.productoMatrizVector(vectorFinal);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		return vectorFinal;
		}
		
	}
}
