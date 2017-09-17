/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorLogico;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mitch
 */
public class FrameTest {
    
    public FrameTest() {
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
     * Test of Compoents method, of class Frame.
     */
    @Test
    public void testCompoents() {
        System.out.println("Compoents");
        Frame instance = new Frame();
        instance.Compoents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FrameV method, of class Frame.
     */
    @Test
    public void testFrameV() {
        System.out.println("FrameV");
        Frame instance = new Frame();
        instance.FrameV();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class Frame.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Frame instance = new Frame();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of itemStateChanged method, of class Frame.
     */
    @Test
    public void testItemStateChanged() {
        System.out.println("itemStateChanged");
        ItemEvent e = null;
        Frame instance = new Frame();
        instance.itemStateChanged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
