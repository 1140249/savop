/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import javax.swing.JFileChooser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RicardoMoreira(11402
 */
public class UtilitariosTest {

    public UtilitariosTest() {
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
     * Test of calculaIdade method, of class Utilitarios.
     */
    @Test
    public void testCalculaIdade() {
        System.out.println("calculaIdade");
        Utilitarios.calculaIdade();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolveDataAtual method, of class Utilitarios.
     */
    @Test
    public void testDevolveDataAtual() {
        System.out.println("devolveDataAtual");
        int[] expResult = null;
        int[] result = Utilitarios.devolveDataAtual();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of converteData method, of class Utilitarios.
     */
    @Test
    public void testConverteData() {
        System.out.println("converteData");
        String data = "";
        int[] expResult = null;
        int[] result = Utilitarios.converteData(data);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostraDataHoje method, of class Utilitarios.
     */
    @Test
    public void testMostraDataHoje() {
        System.out.println("mostraDataHoje");
        Utilitarios.mostraDataHoje();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduzNome method, of class Utilitarios.
     */
    @Test
    public void testReduzNome() {
        System.out.println("reduzNome");
        Utilitarios.reduzNome();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of imprimeEcraCabecalhoDeputados method, of class Utilitarios.
     */
    @Test
    public void testImprimeEcraCabecalhoDeputados() {
        System.out.println("imprimeEcraCabecalhoDeputados");
        int paginaAtual = 0;
        int totalPaginas = 0;
        Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeInstrucoes method, of class Utilitarios.
     */
    @Test
    public void testImprimeInstrucoes() {
        System.out.println("imprimeInstrucoes");
        Utilitarios.imprimeInstrucoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolveIniciosPagina method, of class Utilitarios.
     */
    @Test
    public void testDevolveIniciosPagina() {
        System.out.println("devolveIniciosPagina");
        String[][] deputados = null;
        int numeroDeputados = 0;
        int[] expResult = null;
        int[] result = Utilitarios.devolveIniciosPagina(deputados, numeroDeputados);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolveNumeroPaginas method, of class Utilitarios.
     */
    @Test
    public void testDevolveNumeroPaginas() {
        System.out.println("devolveNumeroPaginas");
        int numeroDeputados = 0;
        int expResult = 0;
        int result = Utilitarios.devolveNumeroPaginas(numeroDeputados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaID method, of class Utilitarios.
     */
    @Test
    public void testValidaID() {
        System.out.println("validaID");
        String id = "";
        String[] COD_REGIOES = null;
        boolean expResult = false;
        boolean result = Utilitarios.validaID(id, COD_REGIOES);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaIDUnico method, of class Utilitarios.
     */
    @Test
    public void testValidaIDUnico() {
        System.out.println("validaIDUnico");
        String id = "";
        String[][] deputados = null;
        int maxProcura = 0;
        boolean expResult = false;
        boolean result = Utilitarios.validaIDUnico(id, deputados, maxProcura);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lerFicheiro method, of class Utilitarios.
     */
    @Test
    public void testLerFicheiro() throws Exception {
        System.out.println("lerFicheiro");
        String ficheiro = "";
        String[] expResult = null;
        String[] result = Utilitarios.lerFicheiro(ficheiro);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeConteudoLinha method, of class Utilitarios.
     */
    @Test
    public void testImprimeConteudoLinha() {
        System.out.println("imprimeConteudoLinha");
        int linha = 0;
        int coluna = 0;
        String[][] deputados = null;
        Utilitarios.imprimeConteudoLinha(linha, coluna, deputados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeEspacos method, of class Utilitarios.
     */
    @Test
    public void testImprimeEspacos() {
        System.out.println("imprimeEspacos");
        int quantidadeEspacos = 0;
        Utilitarios.imprimeEspacos(quantidadeEspacos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenaAlfaMatrizColuna method, of class Utilitarios.
     */
    @Test
    public void testOrdenaAlfaMatrizColuna() {
        System.out.println("ordenaAlfaMatrizColuna");
        String[][] matriz = {{"c","3"},{"b","2"},{"a","1"}};
        String[][] expResult = {{"a","1"},{"b","2"},{"c","3"}};
        String[][] result = Utilitarios.ordenaAlfaMatrizColuna(matriz);
        assertArrayEquals(expResult, result);
    }



}
