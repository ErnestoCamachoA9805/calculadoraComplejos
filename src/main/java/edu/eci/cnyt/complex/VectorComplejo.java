package edu.eci.cnyt.complex;

import java.util.*;
public class VectorComplejo {
    private List<NumeroComplejo> elementos;

    public VectorComplejo(List<NumeroComplejo> elements){
        elementos= new ArrayList<NumeroComplejo>();
        for(NumeroComplejo c: elements){
            elementos.add(c);
        }
    }

    public VectorComplejo(){
        elementos= new ArrayList<NumeroComplejo>();
    }

    /**
     * consulta el tamano del vector
     * return
     * size
     */
    public int getSize(){
        return elementos.size();
    }

    /**
     * consulta el elemneto especificado, empieza con el elemento 0
     * return
     * elemento
     */
    public NumeroComplejo get (int index){
        return elementos.get(index);
    }

    /**
     * anade un elemento al vector
     * param
     * elemto
     */
    public void add(NumeroComplejo c){
        elementos.add(c);
    }

    /**
     * suma el vector con otro vector
     * @param
     * vector
     * @return
     * respuesta
     */
    public VectorComplejo sumeVectores(VectorComplejo vector) throws CalculadoraComplejosException{
        if(!this.checkSize(vector)) {
           // throw new CalculadoraComplejosException(CalculadoraComplejosException.VECTOR_SIZE_ERROR);
        }
        VectorComplejo respuesta= new VectorComplejo();
        for(int i= 0; i< this.getSize(); i++) {
            respuesta.add(this.get(i).sumeComplejo(vector.get(i)));
        }
        return respuesta;
    }

    /**
     * resta el vector con otro vector
     * @param
     * vector
     * @return
     * respuesta
     */
    public VectorComplejo resteVectores(VectorComplejo vector) throws CalculadoraComplejosException{
        if(!this.checkSize(vector)) {
           // throw new CalculadoraComplejosException(CalculadoraComplejosException.VECTOR_SIZE_ERROR);
        }
        VectorComplejo respuesta= new VectorComplejo();
        for(int i= 0; i< this.getSize(); i++) {
            respuesta.add(this.get(i).resteComplejo(vector.get(i)));
        }
        return respuesta;
    }

    /**
     * hace el inverso del vector
     * @return
     * respuesta
     */
    public VectorComplejo inversaVector() {
        VectorComplejo respuesta= new VectorComplejo();
        NumeroComplejo menosUno= new NumeroComplejo(-1.0,0.0);
        for(int i= 0; i< this.getSize(); i++) {
            respuesta.add(this.get(i).productoComplejo(menosUno));
        }
        return respuesta;
    }

    /**
     * hace el producto escalar del vector con un numero complejo
     * @param
     * c
     * @return
     * respuesta
     */
    public VectorComplejo multiplicacionEscalar(NumeroComplejo c){
        VectorComplejo respuesta= new VectorComplejo();
        for(int i= 0; i< this.getSize(); i++){
            respuesta.add(this.get(i).productoComplejo(c));
        }
        return respuesta;
    }



    /**
     * valida el tamaño del vector con el que se va a operar
     * @return
     * flag
     */
    private boolean checkSize(VectorComplejo vector){
        boolean flag= false;
        if(vector.getSize() == this.getSize()){
            flag= true;
        }
        return flag;
    }

    @Override
    public boolean equals(Object o){
        VectorComplejo nv= (VectorComplejo) o;
        boolean flag= true;
        if(this.checkSize(nv)){
            flag= false;
        }
        else{
            for(int i= 0;i< this.getSize();i++){
                if(!(this.get(i).equals(nv.get(i)))){
                    flag= false;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.elementos);
        return hash;
    }
}
