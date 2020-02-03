/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.complex;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.util.Pair;

/**
 *
 * @author 2154021
 */
public class NumeroComplejoTest {
    
    public NumeroComplejoTest() {
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
     * Test of getParteReal method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testGetParteReal() {
        System.out.println("getParteReal");
        NumeroComplejo instance = new NumeroComplejo(3.0,0.0);
        double expResult = 3.0;
        double result = instance.getParteReal();
        assertEquals(expResult, result, 3.0);
    }

    /**
     * Test of getParteImaginaria method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testGetParteImaginaria() {
        System.out.println("getParteImaginaria");
        NumeroComplejo instance = new NumeroComplejo(3.0,0.0);
        double expResult = 0.0;
        double result = instance.getParteImaginaria();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of prettyPrinting method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testPrettyPrinting() {
        System.out.println("prettyPrinting");
        NumeroComplejo instance = new NumeroComplejo(3.0,0.0);
        String expResult = "3.0 + 0.0i";
        String result = instance.prettyPrinting();
        assertEquals(expResult, result);
    }

    /**
     * Test of sumeComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testSumeComplejo() {
        System.out.println("sumeComplejo");
        NumeroComplejo c = new NumeroComplejo(4.0,5.0);
        NumeroComplejo instance = new NumeroComplejo(3.0,0.0);
        NumeroComplejo expResult = new NumeroComplejo(7.0,5.0);
        NumeroComplejo result = instance.sumeComplejo(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of resteComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testResteComplejo() {
        System.out.println("resteComplejo");
        NumeroComplejo c = new NumeroComplejo(4.0,5.0);
        NumeroComplejo instance = new NumeroComplejo(3.0,0.0);
        NumeroComplejo expResult = new NumeroComplejo(-1.0,-5.0);
        NumeroComplejo result = instance.resteComplejo(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of productoComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testProductoComplejo() {
        System.out.println("productoComplejo");
        NumeroComplejo c = new NumeroComplejo(1.0,2.0);
        NumeroComplejo instance = new NumeroComplejo(3.0,-2.0);
        NumeroComplejo expResult = new NumeroComplejo(7.0,4.0);
        NumeroComplejo result = instance.productoComplejo(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of dividaComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testDividaComplejo() {
        System.out.println("dividaComplejo");
        try {
            NumeroComplejo c = new NumeroComplejo(1.0, 2.0);
            NumeroComplejo instance = new NumeroComplejo(-2.0, 1.0);
            NumeroComplejo expResult = new NumeroComplejo(0.0, 1.0);
            NumeroComplejo result = instance.dividaComplejo(c);
            assertEquals(expResult, result);
        }catch (CalculadoraComplejosException e){
            fail("no realizo la operacion");
        }
    }

    /**
     * Test of dividaComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void divideByZero() {
        System.out.println("dividaComplejo pero con zero");
        try {
            NumeroComplejo c = new NumeroComplejo(0.0, 0.0);
            NumeroComplejo instance = new NumeroComplejo(1.0, 2.0);
            NumeroComplejo result = instance.dividaComplejo(c);
            fail("realizo la operacion");
        }catch (CalculadoraComplejosException e){
            System.out.println("atrapo el error");
        }
    }

    /**
     * Test of conjugado method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testConjugado() {
        System.out.println("conjugado");
        NumeroComplejo instance = new NumeroComplejo(-2.0,1.0);
        NumeroComplejo expResult = new NumeroComplejo(-2.0,-1.0);
        NumeroComplejo result = instance.conjugado();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of moduloComplejo method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testModuloComplejo() {
        System.out.println("moduloComplejo");
        NumeroComplejo instance = new NumeroComplejo(1.0,-1.0);
        double result = instance.moduloComplejo();
        double expResult= Math.pow(2.0,0.5);
        assertEquals(expResult, result, Math.pow(2.0,0.5));
    }

    /**
     * Test of cambieApolares method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testCambieAPolares() {
        System.out.println("cambieAPolares");
        NumeroComplejo instance = new NumeroComplejo(1.0,1.0);
        Pair<Double,Double> result = instance.cambieAPolares();
        Pair<Double,Double> expResult= new Pair<>(Math.pow(2.0,0.5),0.7853981633974483);
        assertEquals(expResult.getKey(), result.getKey(), Math.pow(2.0,0.5));
    }

    /**
     * Test of calculeFase method, of class NumeroComplejo.
     */
    @org.junit.Test
    public void testCalculeFase() {
        System.out.println("calculeFase");
        NumeroComplejo instance = new NumeroComplejo(1.0, 1.0);
        double result = instance.calculeFase();
        double expResult = 0.7853981633974483;
        assertEquals(expResult, result, 0.7853981633974483);
    }

    /*
    @org.junit.Test
    public void ejercicio() {
        System.out.println("ejercicio");
        NumeroComplejo c = new NumeroComplejo(3.1,7.1);
        NumeroComplejo d = new NumeroComplejo(6.6,-6.0);
        NumeroComplejo uno= c.productoComplejo(c.conjugado());
        NumeroComplejo dos= d.productoComplejo(d.conjugado());
        NumeroComplejo r= uno.sumeComplejo(dos);
        System.out.println(r.prettyPrinting());
        System.out.println(Math.pow(r.getParteReal(),0.5));
    }*/


}
