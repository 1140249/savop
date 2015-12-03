/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.util.Arrays;
import java.util.Formatter;
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
     * Test of validaIDUnico method, of class Utilitarios.
     */
    @Test
    public void testValidaIDUnico() {
        System.out.println("validaIDUnico");
        String id = "prt03";
        String[][] deputados = {{"prt00", "s"}, {"prt02", "s"}, {"prt03", "s"}};
        int maxProcura = 3;
        boolean expResult = false;
        boolean result = Utilitarios.validaIDUnico(id, deputados, maxProcura);
        assertEquals(expResult, result);
    }

    /**
     * Test of ordenaMatrizVotacoesPorAlfabetoNaColunaID method, of class
     * Utilitarios.
     */
    @Test
    public void testOrdenaMatrizVotacoesPorAlfabetoNaColunaID() {
        System.out.println("ordenaAlfaMatrizColuna");
        String[][] matriz = {{"c", "3"}, {"b", "2"}, {"a", "1"}};
        String[][] expResult = {{"c", "3"}, {"b", "2"}, {"a", "1"}};
        String[][] result = Utilitarios.ordenaMatrizVotacoesPorAlfabetoNaColunaID(matriz, SAVOP.NUMERO_VOTACOES);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of retornaPrimeiroUltimoNome method, of class Utilitarios.
     */
    @Test
    public void testRetornaPrimeiroUltimoNome() {
        System.out.println("obtemPrimeiroUltimoNome");
        String nomeCompleto = "Jorge Silva Gomes";
        String[] expResult = {"Jorge", "Gomes"};
        String[] result = Utilitarios.retornaPrimeiroUltimoNome(nomeCompleto);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of retornaVetorPartidos method, of class Utilitarios.
     */
    @Test
    public void retornaVetorPartidos() {
        System.out.println("retornaVetorPartidos");
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int numeroDeputados = 10;
        String[] expResult = {"a", "b", "c"};
        String[] result = Utilitarios.retornaVetorPartidos(deputados, numeroDeputados);
        Assert.assertTrue(Arrays.equals(expResult, result));
    }

    /**
     * Test of retornaLinhaPartidoPorNome method, of class Utilitarios.
     */
    @Test
    public void testRetornaLinhaPartidoPorNome() {
        System.out.println("retornaLinhaPartidoByNome");
        String nomePartido = "ABC";
        String[] partidos = {"ab", "cda", "AB"};
        Utilitarios instance = new Utilitarios();
        int expResult = -1;
        int result = instance.retornaLinhaPartidoPorNome(nomePartido, partidos);
        assertEquals(expResult, result);
    }

    /**
     * Test of retornaTotalDeputadosPorPartido method, of class Utilitarios.
     */
    @Test
    public void testRetornaTotalDeputadosPorPartido() {
        System.out.println("contaTotalDeputadosPorPartido");
        int totalDeputados = 10;
        String[] vetorPartidos = {"a", "b", "c"};
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int[] expResult = {3, 4, 3};
        int[] result = Utilitarios.retornaTotalDeputadosPorPartido(vetorPartidos, deputados, totalDeputados);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of ordenaVetorPartidosPorTotalDeputados method, of class
     * Utilitarios.
     */
    @Test
    public void testOrdenaVetorPartidosPorTotalDeputados() {
        System.out.println("ordenaVetorPartidosPorTotalDeputados");
        String[] vetorPartidos = {"d", "b", "c", "a"};
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int totalDeputados = 10;
        Utilitarios.ordenaVetorPartidosPorTotalDeputados(vetorPartidos, deputados, totalDeputados);
    }

    /**
     * Test of ordenaVetorPorAlfabeto method, of class Utilitarios.
     */
    @Test
    public void testOrdenaVetorPorAlfabeto() {
        System.out.println("ordenaVetorAlfabeticamente");
        String[] vetor = {"c", "b", "d", "a"};
        String[] expResult = {"a", "b", "c", "d"};
        String[] result = Utilitarios.ordenaVetorPorAlfabeto(vetor);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of removeExtensaoNomeFicheiro method, of class Utilitarios.
     */
    @Test
    public void testRemoveExtensaoNomeFicheiro() {
        System.out.println("removerExtensaoFicheiro");
        String nomeFicheiro = "abc.txt";
        String expResult = "abc";
        String result = Utilitarios.removeExtensaoNomeFicheiro(nomeFicheiro);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaNomeDeputado method, of class Utilitarios.
     */
    @Test
    public void testValidaNomeDeputado() {
        System.out.println("validaNomeDeputado");
        String nome = "aásna ajak a";
        boolean expResult = true;
        boolean result = Utilitarios.validaNomeDeputado(nome);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaDataNascimento method, of class Utilitarios.
     */
    @Test
    public void testValidaDataNascimento() {
        System.out.println("validaDataNascimento");
        String data = "19500101";
        boolean expResult = true;
        boolean result = Utilitarios.validaDataNascimento(data);
        assertEquals(expResult, result);
    }

}
