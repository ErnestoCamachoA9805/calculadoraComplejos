package edu.eci.cnyt.complex;

import javafx.util.Pair;

/**
 * Numero complejo que puede ser operado con otros complejos, ser conjugado, convertir de cartesianas a polares, sacar el modulo, retornar la fase
 * Ernesto Camacho Arroyave 2154021
 */
public class NumeroComplejo {
	private Double parteReal;
	private Double parteImaginaria;

		public NumeroComplejo (Double parteReal,Double parteImaginaria) {
			this.parteReal= parteReal;
			this.parteImaginaria= parteImaginaria;
		}
	
	/**
         * retorna la parte real del numero complejo
         * @return parteReal
         */
        public Double getParteReal() {
		return this.parteReal;
	}
	
        /**
         * retorna la parte real del numero complejo
         * @return parteReal
         */
		public Double getParteImaginaria() {
		return this.parteImaginaria;
	}
	
        /**
         * retorna el numero complejo escrito
         * @return s
         */
		public String prettyPrinting() {
			String s= parteReal +" "+ "+" +" "+ parteImaginaria +"i";
			return s;
		}
	
        /**
         * retorna el resultado de la operacion con el numero complejo recibe
         * @param 
         * c
         * @return 
         * NumeroComplejo
         */
		public NumeroComplejo sumeComplejo (NumeroComplejo c) {
			double pReal= this.getParteReal() + c.getParteReal();
			double pImaginaria= this.getParteImaginaria() + c.getParteImaginaria();
			return new NumeroComplejo(pReal, pImaginaria);
		}
	
        /**
         * retorna el resultado de la operacion con el numero complejo recibe
         * @param 
         * c
         * @return 
         * NumeroComplejo
         */
		public NumeroComplejo resteComplejo (NumeroComplejo c) {
			Double pReal= this.getParteReal() - c.getParteReal();
			Double pImaginaria= this.getParteImaginaria() - c.getParteImaginaria();
			return new NumeroComplejo(pReal, pImaginaria);
		}
	
        /**
         * retorna el resultado de la operacion con el numero complejo recibe
         * @param 
         * c
         * @return 
         * NumeroComplejo
         */
        public NumeroComplejo productoComplejo (NumeroComplejo c) {
			Double pReal= (this.getParteReal() * c.getParteReal()) - (this.getParteImaginaria() * c.getParteImaginaria());
			Double pImaginaria= (this.getParteReal() * c.getParteImaginaria()) + (c.getParteReal() * this.getParteImaginaria());
			return new NumeroComplejo(pReal, pImaginaria);
        }
        
        /**
         * retorna el resultado de la operacion con el numero complejo recibe
         * @param 
         * c
         * @return 
         * NumeroComplejo
         */
        public NumeroComplejo dividaComplejo (NumeroComplejo c) throws CalculadoraComplejosException {
        	if((c.getParteReal().compareTo(new Double(0.0))== 0) && (c.getParteImaginaria().compareTo(new Double(0.0)) == 0)){
        		throw new CalculadoraComplejosException(CalculadoraComplejosException.DIVISION_BY_0);
			}
			Double pReal= ((this.getParteReal() * c.getParteReal()) + (this.getParteImaginaria() * c.getParteImaginaria())) / (Math.pow(c.getParteReal(), 2) + Math.pow(c.getParteImaginaria(), 2));
			Double pImaginaria= ((this.getParteImaginaria() * c.getParteReal()) - (this.getParteReal() * c.getParteImaginaria())) / (Math.pow(c.getParteReal(), 2) + Math.pow(c.getParteImaginaria(), 2));
			return new NumeroComplejo(pReal, pImaginaria);
        }
        
        /**
         * retorna el conjugado del numero complejo
         * @return 
         * NumeroComplejo
         */
        public NumeroComplejo conjugado(){
            return new NumeroComplejo(this.getParteReal(),(-1)* this.getParteImaginaria());
        }
        
        /**
         * retorna el modulo del numero complejo
         * @return 
         * d
         */
        public Double moduloComplejo(){
			Double d= Math.pow((Math.pow(this.getParteReal(), 2) + Math.pow(this.getParteImaginaria(), 2)),0.5);
            return d;
        }

		/**
		 * 	retorna el valor del numero complejo en coordenadas polares
		 * @return
		 * respuesta
		 */
		public Pair<Double,Double> cambieAPolares(){
			Double real= this.moduloComplejo();
			Double suma= 0.0;
			if(this.getParteReal()< 0 && this.getParteReal()< 0){
				suma= Math.PI;
			}
			else if (this.getParteReal()<0 && this.getParteImaginaria()>0){
				suma= Math.PI;
			}
			Double imaginaria= Math.atan((this.getParteImaginaria()/this.getParteReal())) + suma;
			Pair<Double,Double> respuesta= new Pair<>(real,imaginaria);
			return respuesta;
		}

		/**
		 * retorna el valor de la fase
		 * @return
		 * respuesta
		 */
		public Double calculeFase(){
			Double suma= 0.0;
			if(this.getParteReal()< 0 && this.getParteReal()< 0){
				suma= Math.PI;
			}
			else if (this.getParteReal()<0 && this.getParteImaginaria()>0){
				suma= Math.PI;
			}
			Double imaginaria= Math.atan((this.getParteImaginaria()/this.getParteReal())) + suma;
			return imaginaria;
		}



	@Override
	public boolean equals(Object c){
            NumeroComplejo nc= (NumeroComplejo) c;
            boolean flag= false;
            if(((this.getParteReal().compareTo(nc.getParteReal())) == 0) && ((this.getParteImaginaria().compareTo(nc.getParteImaginaria()))== 0)){
                flag= true;
            }
            return flag;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.parteReal) ^ (Double.doubleToLongBits(this.parteReal) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.parteImaginaria) ^ (Double.doubleToLongBits(this.parteImaginaria) >>> 32));
        return hash;
    }
}