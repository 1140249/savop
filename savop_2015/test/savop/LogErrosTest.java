/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.util.Formatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RicardoMoreira(11402
 */
public class LogErrosTest {
    
    public LogErrosTest() {
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
     * Test of criaFicheiroErros method, of class LogErros.
     */
    @Test
    public void testCriaFicheiroErros() {
        System.out.println("criaFicheiroErros");
        File expResult = null;
        File result = LogErros.criaFicheiroErros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nomeSistemaOperativo method, of class LogErros.
     */
    @Test
    public void testNomeSistemaOperativo() {
        System.out.println("nomeSistemaOperativo");
        String expResult = "Windows";
        String result = LogErros.nomeSistemaOperativo();
        assertEquals(expResult, result);
    }

    /**
     * Test of escreveNoFicheiroErros method, of class LogErros.
     */
    @Test
    public void testEscreveNoFicheiroErros() throws Exception {
        System.out.println("escreveNoFicheiroErros");
        String mensagemErro = "";
        Formatter escrever = null;
        LogErros.escreveNoFicheiroErros(mensagemErro, escrever);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
