/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hulkstore;

import java.sql.Connection;
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
public class ConexionTest {
    
    public ConexionTest() {
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
     * Test of CrearBD method, of class Conexion.
     */
    //La prueba da OK solo si se ejecuta sin haberse creado la Base de Datos, si ya se creo es valido que falle
    @Test
    public void testCrearBD() {
        System.out.println("CrearBD");
        Conexion instance = new Conexion();
        Connection expResult = null;
        Connection result = instance.CrearBD();
        if (!(result==expResult)){
        } else {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of CargarBD method, of class Conexion.
     */
    //La prueba  da OK  si al cargar la Base de datos, esta no esta siendo usada por el aplicativo
    @Test
    public void testCargarBD() {
        System.out.println("CargarBD");
        Conexion instance = new Conexion();
        Connection expResult = null;
        Connection result = instance.CargarBD();
        if (!(result==expResult)){
        } else {
            fail("The test case is a prototype.");
        }
    }
    
}
