/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hulkstore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel Rodriguez
 */
public class ProductosTest {
    
    public ProductosTest() {
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
     * Test of Agregar method, of class Productos.
     */
    @Test
    public void testAgregar() throws Exception{
        System.out.println("Agregar");
        Productos instance = new Productos();
        instance.Agregar();
        
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class Productos.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Productos.main(args);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(this);
    }
    
}
