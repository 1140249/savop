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
        String id = "prt03";
        String[][] deputados = {{"prt00","s"},{"prt02","s"},{"prt03","s"}};
        int maxProcura = 3;
        boolean expResult = false;
        boolean result = Utilitarios.validaIDUnico(id, deputados, maxProcura);
        assertEquals(expResult, result);
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
     * Test of imprimeConteudoCelulaDeputados method, of class Utilitarios.
     */
    @Test
    public void testImprimeConteudoLinha() {
        System.out.println("imprimeConteudoLinha");
        int linha = 0;
        int coluna = 0;
        String[][] deputados = null;
        Utilitarios.imprimeConteudoCelulaDeputados(linha, coluna, deputados);
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
     * Test of ordenaAlfaMatrizVotacoesColuna method, of class Utilitarios.
     */
    @Test
    public void testOrdenaAlfaMatrizVotacoesColuna() {
        System.out.println("ordenaAlfaMatrizColuna");
        String[][] matriz = {{"c", "3"}, {"b", "2"}, {"a", "1"}};
        String[][] expResult = {{"a", "1"}, {"b", "2"}, {"c", "3"}};
        String[][] result = Utilitarios.ordenaAlfaMatrizVotacoesColuna(matriz, SAVOP.NUMERO_VOTACOES);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of devolveInfoVotosByID method, of class Utilitarios.
     */
    @Test
    public void testDevolveInfoVotosByID() {
        System.out.println("devolveInfoVotosByID");
        String[][] deputados = null;
        String[][] matrizVotos = null;
        String id = "";
        String[] expResult = null;
        String[] result = Utilitarios.devolveInfoVotosByID(deputados, matrizVotos, id);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolveMatrizCompletaVotacaoOrdenada method, of class
     * Utilitarios.
     */
    @Test
    public void testDevolveMatrizCompletaVotacaoOrdenada() {
        System.out.println("devolveMatrizCompletaVotacaoOrdenada");
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT02", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT03", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT04", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT05", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT06", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT07", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT08", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT09", "Jorge Silva Gomes", "PartidoA", "19701212"}, {"PRT10", "Jorge Silva Gomes", "PartidoA", "19701212"}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}};
        String[][] matrizVotos = {{"PRT20S"}, {"PRT19S"}, {"PRT03S"}, {"PRT04S"}, {"PRT05S"}, {"PRT06S"}, {"PRT07S"}, {"PRT08S"}, {"PRT09S"}, {"PRT10N"}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}};
        String[][] expResult = {{"PRT03S"}, {"PRT04S"}, {"PRT05S"}, {"PRT06S"}, {"PRT07S"}, {"PRT08S"}, {"PRT09S"}, {"PRT10N"}, {"PRT19S"}, {"PRT20S"}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}, {null}};
        String[][] result = Utilitarios.devolveMatrizCompletaVotacaoOrdenada(deputados, matrizVotos);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of obtemPrimeiroUltimoNome method, of class Utilitarios.
     */
    @Test
    public void testObtemPrimeiroUltimoNome() {
        System.out.println("obtemPrimeiroUltimoNome");
        String nomeCompleto = "Jorge Silva Gomes";
        String[] expResult = {"Jorge", "Gomes"};
        String[] result = Utilitarios.obtemPrimeiroUltimoNome(nomeCompleto);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of linhasVaziasFicheiro method, of class Utilitarios.
     */
    @Test
    public void testLinhasVaziasFicheiro() throws Exception {
        System.out.println("linhasVaziasFicheiro");
        String ficheiro = "teste_linhas_vazias.txt";
        boolean[] expResult = {false, true, true, false};
        boolean[] result = Utilitarios.linhasVaziasFicheiro(ficheiro);
        Assert.assertTrue(Arrays.equals(expResult, result));
    }

    /**
     * Test of retornaVetorPartidos method, of class Utilitarios.
     */
    @Test
    public void retornaVetorPartidos() {
        System.out.println("retornaVetorPartidos");
        String [][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int numeroDeputados = 10;
        String [] expResult = {"a", "b", "c"};
        String [] result = Utilitarios.retornaVetorPartidos(deputados,numeroDeputados);
        Assert.assertTrue(Arrays.equals(expResult, result));
    }

    /**
     * Test of imprimeEcraCabecalhoVotacoes method, of class Utilitarios.
     */
    @Test
    public void testImprimeEcraCabecalhoVotacoes() {
        System.out.println("imprimeEcraCabecalhoVotacoes");
        int paginaAtual = 0;
        int totalPaginas = 0;
        Utilitarios.imprimeEcraCabecalhoVotacoes(paginaAtual, totalPaginas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeConteudoCelulaDeputados method, of class Utilitarios.
     */
    @Test
    public void testImprimeConteudoCelula() {
        System.out.println("imprimeConteudoCelula");
        int linha = 0;
        int coluna = 0;
        String[][] deputados = null;
        Utilitarios.imprimeConteudoCelulaDeputados(linha, coluna, deputados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmaSimNao method, of class Utilitarios.
     */
    @Test
    public void testConfirmaSimNao() {
        System.out.println("confirmaSimNao");
        String pergunta = "";
        boolean expResult = false;
        boolean result = Utilitarios.confirmaSimNao(pergunta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtemInput method, of class Utilitarios.
     */
    @Test
    public void testObtemInput() {
        System.out.println("obtemInput");
        String pergunta = "";
        String expResult = "";
        String result = Utilitarios.obtemInput(pergunta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtemNomeCampoDeputados method, of class Utilitarios.
     */
    @Test
    public void testObtemNomeCampoDeputados() {
        System.out.println("obtemNomeCampoDeputados");
        int coluna = 0;
        String expResult = "";
        String result = Utilitarios.obtemNomeCampoDeputados(coluna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtemValorPesquisa method, of class Utilitarios.
     */
    @Test
    public void testObtemValorPesquisa() {
        System.out.println("obtemValorPesquisa");
        int coluna = 0;
        String expResult = "";
        String result = Utilitarios.obtemValorPesquisa(coluna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encontraDeputadoPorID method, of class Utilitarios.
     */
    @Test
    public void testEncontraDeputadoPorID() {
        System.out.println("encontraDeputadoPorID");
        String id = "";
        String[][] deputados = null;
        int numDeputados = 0;
        int expResult = 0;
        int result = Utilitarios.encontraDeputadoPorID(id, deputados, numDeputados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtemColunaAlterarDeputados method, of class Utilitarios.
     */
    @Test
    public void testObtemColunaAlterarDeputados() {
        System.out.println("obtemColunaAlterarDeputados");
        int expResult = 0;
        int result = Utilitarios.obtemColunaAlterarDeputados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaErrosVotacoes method, of class Utilitarios.
     */
    @Test
    public void testEliminaErrosVotacoes() {
        System.out.println("eliminaErrosVotacoes");
        String[][] votacoes = null;
        String[][] deputados = null;
        boolean expResult = false;
        boolean result = Utilitarios.eliminaErrosVotacoes(votacoes, deputados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaVetorPartidos method, of class Utilitarios.
     */
    @Test
    public void testRetornaVetorPartidos() {
        System.out.println("retornaVetorPartidos");
        String[][] deputados = null;
        int numeroDeputados = 0;
        String[] expResult = null;
        String[] result = Utilitarios.retornaVetorPartidos(deputados, numeroDeputados);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLinhaMatriz method, of class Utilitarios.
     */
    @Test
    public void testRemoveLinhaMatriz() {
        System.out.println("removeLinhaMatriz");
        int linha = 0;
        String[][] matriz = null;
        String[][] expResult = null;
        String[][] result = Utilitarios.removeLinhaMatriz(linha, matriz);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaPartidoPorID method, of class Utilitarios.
     */
    @Test
    public void testRetornaPartidoPorID() {
        System.out.println("retornaPartidoPorID");
        String id = "";
        String[][] deputados = null;
        int numeroDeputados = 0;
        String[] partidos = null;
        String expResult = "";
        String result = Utilitarios.retornaPartidoPorID(id, deputados, numeroDeputados, partidos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarMatrizVaziaResultadosVotacoes method, of class Utilitarios.
     */
    @Test
    public void testCriarMatrizVaziaResultadosVotacoes() {
        System.out.println("criarMatrizVaziaResultadosVotacoes");
        String [] vetorPartidos = {};
        int[][] expResult = null;
        int[][] result = Utilitarios.criarMatrizVaziaResultadosVotacoes(vetorPartidos);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaLinhaPartidoByNome method, of class Utilitarios.
     */
    @Test
    public void testRetornaLinhaPartidoByNome() {
        System.out.println("retornaLinhaPartidoByNome");
        String nomePartido = "ABC";
        String[] partidos = {"ab","cda","AB"};
        Utilitarios instance = new Utilitarios();
        int expResult = -1;
        int result = instance.retornaLinhaPartidoByNome(nomePartido, partidos);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculaResultadosVotacoes method, of class Utilitarios.
     */
    @Test
    public void testCalculaResultadosVotacoes() {
        System.out.println("calculaResultadosVotacoes");
        int[][] matrizResultadosVotacoes = null;
        String[][] votacoes = null;
        int numeroVotacoes = 0;
        String[][] deputados = null;
        int numeroDeputados = 0;
        Utilitarios.calculaResultadosVotacoes(matrizResultadosVotacoes, votacoes, numeroVotacoes, deputados, numeroDeputados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contaTotalDeputadosPorPartido method, of class Utilitarios.
     */
    @Test
    public void testContaTotalDeputadosPorPartido() {
        System.out.println("contaTotalDeputadosPorPartido");
        int totalDeputados = 10;
        String[] vetorPartidos = {"a","b","c"};
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int[] expResult = {3,4,3};
        int[] result = Utilitarios.contaTotalDeputadosPorPartido(vetorPartidos, deputados, totalDeputados);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of somaColuna method, of class Utilitarios.
     */
    @Test
    public void testSomaColuna() {
        System.out.println("somaColuna");
        int[][] matriz = null;
        int coluna = 0;
        int linhaInicio = 0;
        int LinhaFim = 0;
        int expResult = 0;
        int result = Utilitarios.somaColuna(matriz, coluna, linhaInicio, LinhaFim);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tipoVoto method, of class Utilitarios.
     */
    @Test
    public void testTipoVoto() {
        System.out.println("tipoVoto");
        String voto = "";
        int expResult = 0;
        int result = Utilitarios.tipoVoto(voto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenaVetorPartidosPorTotalDeputados method, of class Utilitarios.
     */
    @Test
    public void testOrdenaVetorPartidosPorTotalDeputados() {
        System.out.println("ordenaVetorPartidosPorTotalDeputados");
        String[] vetorPartidos = {"d","b","c","a"};
        String[][] deputados = {{"PRT01", "Jorge Silva Gomes", "a", "19701212"}, {"PRT02", "Jorge Silva Gomes", "b", "19701212"}, {"PRT03", "Jorge Silva Gomes", "a", "19701212"}, {"PRT04", "Jorge Silva Gomes", "b", "19701212"}, {"PRT05", "Jorge Silva Gomes", "c", "19701212"}, {"PRT06", "Jorge Silva Gomes", "b", "19701212"}, {"PRT07", "Jorge Silva Gomes", "c", "19701212"}, {"PRT08", "Jorge Silva Gomes", "c", "19701212"}, {"PRT09", "Jorge Silva Gomes", "a", "19701212"}, {"PRT10", "Jorge Silva Gomes", "b", "19701212"}};
        int totalDeputados = 10;
        Utilitarios.ordenaVetorPartidosPorTotalDeputados(vetorPartidos, deputados, totalDeputados);
    }

    /**
     * Test of ordenaVetorAlfabeticamente method, of class Utilitarios.
     */
    @Test
    public void testOrdenaVetorAlfabeticamente() {
        System.out.println("ordenaVetorAlfabeticamente");
        String[] vetor = {"c","b","d","a"};
        String[] expResult = {"a","b","c","d"};
        String[] result = Utilitarios.ordenaVetorAlfabeticamente(vetor);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of imprimeConteudoCelulaDeputados method, of class Utilitarios.
     */
    @Test
    public void testImprimeConteudoCelulaDeputados() {
        System.out.println("imprimeConteudoCelulaDeputados");
        int linha = 0;
        int coluna = 0;
        String[][] deputados = null;
        Utilitarios.imprimeConteudoCelulaDeputados(linha, coluna, deputados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeEspacosFicheiro method, of class Utilitarios.
     */
    @Test
    public void testImprimeEspacosFicheiro() {
        System.out.println("imprimeEspacosFicheiro");
        int quantidadeEspacos = 0;
        File ficheiro = null;
        Formatter escrever = null;
        Utilitarios.imprimeEspacosFicheiro(quantidadeEspacos, ficheiro, escrever);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeConteudoCelulaVotos method, of class Utilitarios.
     */
    @Test
    public void testImprimeConteudoCelulaVotos() {
        System.out.println("imprimeConteudoCelulaVotos");
        int linha = 0;
        int coluna = 0;
        int[][] votacoes = null;
        String[] partidos = null;
        Utilitarios.imprimeConteudoCelulaVotos(linha, coluna, votacoes, partidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escreveFicheiroConteudoCelulaVotos method, of class Utilitarios.
     */
    @Test
    public void testEscreveFicheiroConteudoCelulaVotos() throws Exception {
        System.out.println("escreveFicheiroConteudoCelulaVotos");
        int linha = 0;
        int coluna = 0;
        int[][] votacoes = null;
        String[] partidos = null;
        File ficheiro = null;
        Formatter escreve = null;
        Utilitarios.escreveFicheiroConteudoCelulaVotos(linha, coluna, votacoes, partidos, ficheiro, escreve);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerExtensaoFicheiro method, of class Utilitarios.
     */
    @Test
    public void testRemoverExtensaoFicheiro() {
        System.out.println("removerExtensaoFicheiro");
        String nomeFicheiro = "abc.txt";
        String expResult = "abc";
        String result = Utilitarios.removerExtensaoFicheiro(nomeFicheiro);
        assertEquals(expResult, result);
    }

}
