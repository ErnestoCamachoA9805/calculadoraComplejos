package edu.eci.cnyt.complex;

import edu.eci.cnyt.complex.*;


public class CalculadoraDeSistemas {
	
	public static void ejercicioDoctor() {
		MatrizCompleja sistemaPersonalidad = new MatrizCompleja(2, 2);
		sistemaPersonalidad.asigna(0, 0, new NumeroComplejo((double) (1.0/3.0) , 0.0));
		sistemaPersonalidad.asigna(0, 1, new NumeroComplejo((double) (2.0/3.0)  , 0.0));
		sistemaPersonalidad.asigna(1, 0, new NumeroComplejo((double) (2.0/3.0)  , 0.0));
		sistemaPersonalidad.asigna(1, 1, new NumeroComplejo((double) (1.0/3.0)  , 0.0));
		
		MatrizCompleja sistemaPosicion= new MatrizCompleja(3,3);
		sistemaPosicion.asigna(0, 0, new NumeroComplejo( 0.0, 0.0));
		sistemaPosicion.asigna(0, 1, new NumeroComplejo((double) (1.0/6.0)  , 0.0));
		sistemaPosicion.asigna(0, 2, new NumeroComplejo((double) (5.0/6.0)  , 0.0));
		sistemaPosicion.asigna(1, 0, new NumeroComplejo((double) (1.0/3.0)  , 0.0));
		sistemaPosicion.asigna(1, 1, new NumeroComplejo((double) (1.0/2.0)  , 0.0));
		sistemaPosicion.asigna(1, 2, new NumeroComplejo((double) (1.0/6.0)  , 0.0));
		sistemaPosicion.asigna(2, 0, new NumeroComplejo((double) (2.0/3.0)  , 0.0));
		sistemaPosicion.asigna(2, 1, new NumeroComplejo((double) (1.0/3.0)  , 0.0));
		sistemaPosicion.asigna(2, 2, new NumeroComplejo( 0.0, 0.0));
		
		VectorComplejo configInicialPersonalidad= new VectorComplejo();
		configInicialPersonalidad.add(new NumeroComplejo((double) (5.0/100.0)  , 0.0));
		configInicialPersonalidad.add(new NumeroComplejo((double) (95.0/100.0)  , 0.0));
		
		VectorComplejo configInicialPosicion= new VectorComplejo();
		configInicialPosicion.add(new NumeroComplejo((double) (1.0/100.0)  , 0.0));
		configInicialPosicion.add(new NumeroComplejo((double) (90.0/100.0)  , 0.0));
		configInicialPosicion.add(new NumeroComplejo((double) (9.0/100.0)  , 0.0));
		
		MatrizCompleja sistema= sistemaPersonalidad.tensorProduct(sistemaPosicion);
		VectorComplejo configuracionInicial= configInicialPersonalidad.productoTensor(configInicialPosicion);
		VectorComplejo respuesta= null;
		try {
			for (int i=0; i< 10000;i++) {
				if ( i== 0 ){
					respuesta= sistema.productoMatrizVector(configuracionInicial);
				}
				else {
					respuesta= sistema.productoMatrizVector(respuesta);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		System.out.println(respuesta.toString());
		}
	
	public static void ejercicioQuiz1() {
		MatrizCompleja sistema= new MatrizCompleja(3,3);
		sistema.asigna(0, 0, new NumeroComplejo( 0.0, 0.0));
		sistema.asigna(0, 1, new NumeroComplejo((double) (1.0/6.0)  , 0.0));
		sistema.asigna(0, 2, new NumeroComplejo((double) (5.0/6.0)  , 0.0));
		sistema.asigna(1, 0, new NumeroComplejo((double) (1.0/3.0)  , 0.0));
		sistema.asigna(1, 1, new NumeroComplejo((double) (1.0/2.0)  , 0.0));
		sistema.asigna(1, 2, new NumeroComplejo((double) (1.0/6.0)  , 0.0));
		sistema.asigna(2, 0, new NumeroComplejo((double) (2.0/3.0)  , 0.0));
		sistema.asigna(2, 1, new NumeroComplejo((double) (1.0/3.0)  , 0.0));
		sistema.asigna(2, 2, new NumeroComplejo( 0.0, 0.0));
		
		VectorComplejo configInicial= new VectorComplejo();
		configInicial.add(new NumeroComplejo((double) (1.0/5.0)  , 0.0));
		configInicial.add(new NumeroComplejo((double) (7.0/10.0)  , 0.0));
		configInicial.add(new NumeroComplejo((double) (1.0/10.0)  , 0.0));
		
		VectorComplejo respuesta= null;
		try {
			for (int i=0; i< 4;i++) {
				if ( i== 0 ){
					respuesta= sistema.productoMatrizVector(configInicial);
				}
				else {
					respuesta= sistema.productoMatrizVector(respuesta);
				}
			}
		}catch(CalculadoraComplejosException e) {
			}
	
		System.out.println(respuesta.toString());
	}

	public static void ejercicioQuiz2() {
		MatrizCompleja sistema = new MatrizCompleja(2, 2);
		sistema.asigna(0, 0, new NumeroComplejo((double) (1.0/Math.sqrt(2.0)) , 0.0));
		sistema.asigna(0, 1, new NumeroComplejo((double) (1.0/Math.sqrt(2.0)) , 0.0));
		sistema.asigna(1, 0, new NumeroComplejo( 0.0 , (double) (1.0/Math.sqrt(2.0))));
		sistema.asigna(1, 1, new NumeroComplejo( 0.0 , (double) (-1.0/Math.sqrt(2.0))));
		
		VectorComplejo configInicial= new VectorComplejo();
		configInicial.add(new NumeroComplejo( 1.0 , 0.0));
		configInicial.add(new NumeroComplejo( 0.0 , 0.0));
		
		VectorComplejo respuesta= null;
		}
	
	public static void ejecicio1AcitivdadLab3() {
		VectorComplejo vectorInicial= new VectorComplejo();
		VectorComplejo vectorEstado= new VectorComplejo();
		
		//### inicial
		vectorInicial.add(new NumeroComplejo( 2.0 , 1.0));
		vectorInicial.add(new NumeroComplejo( -1.0 , 2.0));
		vectorInicial.add(new NumeroComplejo( 0.0 , 1.0));
		vectorInicial.add(new NumeroComplejo( 1.0 , 0.0));
		vectorInicial.add(new NumeroComplejo( 3.0 , -1.0));
		vectorInicial.add(new NumeroComplejo( 2.0 , 0.0));
		vectorInicial.add(new NumeroComplejo( 0.0 , -2.0));
		vectorInicial.add(new NumeroComplejo( -2.0 , 1.0));
		vectorInicial.add(new NumeroComplejo( 1.0 , -3.0));
		vectorInicial.add(new NumeroComplejo( 0.0 , -1.0));
		//### Estado
		vectorEstado.add(new NumeroComplejo( 1.0 , -4.0));
		vectorEstado.add(new NumeroComplejo( 2.0 , -3.0));
		vectorEstado.add(new NumeroComplejo( -7.0 , 6.0));
		vectorEstado.add(new NumeroComplejo( -1.0 , 1.0));
		vectorEstado.add(new NumeroComplejo( -5.0 , -3.0));
		vectorEstado.add(new NumeroComplejo( 5.0 , 0.0));
		vectorEstado.add(new NumeroComplejo( 5.0 , 8.0));
		vectorEstado.add(new NumeroComplejo( 4.0 , -4.0));
		vectorEstado.add(new NumeroComplejo( 8.0 , -7.0));
		vectorEstado.add(new NumeroComplejo( 2.0 , -7.0));
		
		NumeroComplejo normaInicial= new NumeroComplejo((double)1.0/vectorInicial.norma(),0.0);
		NumeroComplejo normaEstado= new NumeroComplejo((double)1.0/vectorEstado.norma(),0.0);
		
		VectorComplejo inicialNormalizado= vectorInicial.multiplicacionEscalar(normaInicial);
		VectorComplejo estadoNormalizado= vectorEstado.multiplicacionEscalar(normaEstado);
		
		VectorComplejo vectorAdjunto= estadoNormalizado.adjunta();
		
		try {
			System.out.println(vectorAdjunto.productoInterno(inicialNormalizado).prettyPrinting());
		} catch (CalculadoraComplejosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void ejercicio2ActividadLab3() {
		MatrizCompleja observable = new MatrizCompleja(2, 2);
		observable.asigna(0, 0, new NumeroComplejo( 2.0 , 0.0));
		observable.asigna(0, 1, new NumeroComplejo( 1.0 , 1.0));
		observable.asigna(1, 0, new NumeroComplejo( 1.0 , -1.0));
		observable.asigna(1, 1, new NumeroComplejo( 3.0, 0.0));
	}
	
	public static void main(String[] args) {
		//ejercicioDoctor();
		//ejercicioQuiz1();
		//ejercicioQuiz2();
		ejecicio1AcitivdadLab3();
	}
}
