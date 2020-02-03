package edu.eci.cnyt.complex;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 *
 * @author 2154021
 */
public class VectorComplejoTest {

    public VectorComplejoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of VectorComplejo Class
     */
    @org.junit.Test
    public void testGet() {
        System.out.println("getElement of index");
        NumeroComplejo c= new NumeroComplejo(2.0,-3.5);
        VectorComplejo vector= new VectorComplejo();
        vector.add(c);
        assertEquals(c,vector.get(0));
    }

    /**
     * Test of getSize method, of class VectorComplejo
     */
    @org.junit.Test
    public void testGetSize(){
        System.out.println("getSize of vector");
        NumeroComplejo c= new NumeroComplejo(2.0,-3.5);
        VectorComplejo vector= new VectorComplejo();
        assertEquals(0,vector.getSize());
        vector.add(c);
        assertEquals(1,vector.getSize());
    }

    /**
     * Test of sumeVectores
     */
    @org.junit.Test
    public void deberiaSumarVectores(){
        System.out.println("sumeVectores");
        NumeroComplejo c= new NumeroComplejo(2.0,-3.5);
        VectorComplejo vectorUno= new VectorComplejo();
        VectorComplejo vectorDos= new VectorComplejo();
        vectorUno.add(c);
        vectorDos.add(c);
        try {
            VectorComplejo respuesta = vectorUno.sumeVectores(vectorDos);
            ArrayList<NumeroComplejo> array = new ArrayList<NumeroComplejo>();
            array.add(c.sumeComplejo(c));
            VectorComplejo respuestaEsperada = new VectorComplejo(array);
            assertTrue(respuestaEsperada.equals(respuesta));
        }catch (CalculadoraComplejosException e){

        }
    }

    @org.junit.Test
    public void noDeberiaSumarVectores(){
        System.out.println("sumeVectores");
        NumeroComplejo c= new NumeroComplejo(2.0,-3.5);
        VectorComplejo vectorUno= new VectorComplejo();
        VectorComplejo vectorDos= new VectorComplejo();
        vectorUno.add(c);
        try {
            VectorComplejo respuesta = vectorUno.sumeVectores(vectorDos);
           fail("si paso el error");
        }catch (CalculadoraComplejosException e){
            System.out.println("atrapo el error");
        }
    }
}