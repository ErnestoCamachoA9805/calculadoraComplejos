package Simulacion;

import edu.eci.cnyt.complex.*;

public class Simulacion {
	
	private MatrizCompleja matriz;  
	private VectorComplejo inicial;
	private VectorComplejo Temporal;
	
	public Simulacion() {
		matriz= new MatrizCompleja(8,8);
		inicial= new VectorComplejo();
		
		this.setUp();
	}
	
	public MatrizCompleja getMatriz() {
		return matriz;
	}
	
	public VectorComplejo getInicial() {
		return inicial;
	}
	
	private void setUp() {
		this.inicial.add(new NumeroComplejo(1.0,0.0));
		for(int i=0; i<7;i++) {
			this.inicial.add(new NumeroComplejo(0.0,0.0));
		}
		
		this.matriz.fill(new NumeroComplejo(0.0,0.0));

		//primera columna
		this.matriz.asigna(1, 0, new NumeroComplejo(1.0/Math.sqrt(2.0), 0.0));
		this.matriz.asigna(2, 0, new NumeroComplejo(1.0/Math.sqrt(2.0), 0.0));
		//segunda columna
		this.matriz.asigna(3, 1, new NumeroComplejo(-1.0/Math.sqrt(6.0), 1.0/Math.sqrt(6.0)));
		this.matriz.asigna(4, 1, new NumeroComplejo(-1.0/Math.sqrt(6.0), -1.0/Math.sqrt(6.0)));
		this.matriz.asigna(5, 1, new NumeroComplejo(1.0/Math.sqrt(6.0), -1.0/Math.sqrt(6.0)));
		//tercera columna
		this.matriz.asigna(5, 2, new NumeroComplejo(-1.0/Math.sqrt(6.0), 1.0/Math.sqrt(6.0)));
		this.matriz.asigna(6, 2, new NumeroComplejo(-1.0/Math.sqrt(6.0), -1.0/Math.sqrt(6.0)));
		this.matriz.asigna(7, 2, new NumeroComplejo(1.0/Math.sqrt(6.0), -1.0/Math.sqrt(6.0)));
		//columnas finales
		this.matriz.asigna(3, 3, new NumeroComplejo(1.0, 0.0));
		this.matriz.asigna(4, 4, new NumeroComplejo(1.0, 0.0));
		this.matriz.asigna(5, 5, new NumeroComplejo(1.0, 0.0));
		this.matriz.asigna(6, 6, new NumeroComplejo(1.0, 0.0));
		this.matriz.asigna(7, 7, new NumeroComplejo(1.0, 0.0));
		
		
	}
	
	public VectorComplejo click(int numero) {
		try {
			for (int i=0; i< numero;i++) {
				if ( i== 0 ){
					Temporal= matriz.productoMatrizVector(inicial);
				}
				else {
					Temporal= matriz.productoMatrizVector(Temporal);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		return Temporal;
		}
	
	
	public static void main(String[] args) {
		Simulacion sim= new Simulacion();
		System.out.println(sim.click(2).toString());
	}
}
