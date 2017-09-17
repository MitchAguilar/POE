/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorInner;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mitch
 */
public class EstudianteNGTest {
    
    public EstudianteNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getNombre method, of class Estudiante.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Estudiante instance = new Estudiante();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Estudiante.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Estudiante instance = new Estudiante();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdentificacion method, of class Estudiante.
     */
    @Test
    public void testGetIdentificacion() {
        System.out.println("getIdentificacion");
        Estudiante instance = new Estudiante();
        String expResult = "";
        String result = instance.getIdentificacion();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentificacion method, of class Estudiante.
     */
    @Test
    public void testSetIdentificacion() {
        System.out.println("setIdentificacion");
        String identificacion = "";
        Estudiante instance = new Estudiante();
        instance.setIdentificacion(identificacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrograma method, of class Estudiante.
     */
    @Test
    public void testGetPrograma() {
        System.out.println("getPrograma");
        Estudiante instance = new Estudiante();
        String expResult = "";
        String result = instance.getPrograma();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrograma method, of class Estudiante.
     */
    @Test
    public void testSetPrograma() {
        System.out.println("setPrograma");
        String programa = "";
        Estudiante instance = new Estudiante();
        instance.setPrograma(programa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotadefinitiva method, of class Estudiante.
     */
    @Test
    public void testGetNotadefinitiva() {
        System.out.println("getNotadefinitiva");
        Estudiante instance = new Estudiante();
        double expResult = 0.0;
        double result = instance.getNotadefinitiva();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotadefinitiva method, of class Estudiante.
     */
    @Test
    public void testSetNotadefinitiva() {
        System.out.println("setNotadefinitiva");
        double notadefinitiva = 0.0;
        Estudiante instance = new Estudiante();
        instance.setNotadefinitiva(notadefinitiva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Estudiante.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Estudiante instance = new Estudiante();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
