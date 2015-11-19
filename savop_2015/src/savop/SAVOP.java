/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author RicardoMoreira(11402
 */
public class SAVOP {

    /**
     * @param args the command line arguments
     */
    private final static int MAX_DEPUTADOS = 230;
    private final static String FILE_DEPUTADOS = "Deputados230.txt";
    private final static String PAGINA_HTML = "Pagina.html";
    private final static int MAX_LINHAS_PAGINA = 5;
    private final static String[] COD_REGIOES = {"AVE", "BEJ", "BRG", "BRA", "CAS", "COI", "EVO", "FAR", "GUA", "LEI", "LIS", "PTL", "PRT", "SAN", "SET", "VIA", "VRL", "VIS", "ACO", "MAD"};

    public static void main(String[] args) throws FileNotFoundException {
        File logErros = LogErros.criaFicheiroErros();
        String nomeFicheiro = logErros.getAbsolutePath();
        Formatter escrever = new Formatter(nomeFicheiro);

        String userDir = System.getProperty("user.home");
        JFileChooser fc = new JFileChooser(userDir);
        Scanner ler = new Scanner(System.in);
        String[][] deputados = new String[230][4];
        int numeroDeputados = 0;
        int opcao;
        do {
            System.out.println("\nInsira opção: "
                + "\n1 - Ler ficheiro Deputados e guardar na memória principal"
                + "\n2 - Mostrar listagem Deputados paginada"
                + "\n3 - Alterar informação deputado"
                + "\n4 - Ler ficheiro votação"
                + "\n5 - Visualisar votação ordenada por ID deputado"
                + "\n6 - Visualizar resultados última votação"
                + "\n7 - Visualisar votação por faixa etária"
                + "\n8 - Visualizar resultados última votação em página HTML"
                + "\n9 - Terminar o programa"
            );
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    /*Ler ficheiro deputados e armazená-la na memória principal*/
                    numeroDeputados = lerParaMemoriaFicheiroDeputados(deputados, fc, logErros, escrever);
                    System.out.println("Ficheiro lido com sucesso!");
                    break;
                case 2:
                    /*Visualizar ficheiro deputados existente em memória (depois de iniciada a opção 1) usando paginação*/
                    numeroDeputados = mostraDeputadosPaginado(deputados, numeroDeputados);
                    break;
                case 3:
                    /*Alterar informação de um deputado (depois de iniciada a opção 1)*/
                    break;
                case 4:
                    /*Ler de um ficheiro de texto selecionado pelo utilizador a informação referente a uma votação ocorrrida */
                    break;
                case 5:
                    /*Visualizar informação da opção 4 mas ordenada alfabeticamente pelo código de identificação*/
                    break;
                case 6:
                    /*Visualizar no ECRÃ os resultados da última votação introduzida e guardar dados num ficheiro de texto cujo nome seja a palavra Resultados, concatenada com o título da votação*/
                    break;
                case 7:
                    /*Visualizar votação em função da faixa etária*/
                    break;
                case 8:
                    /*Visualizar em HTML os resultados da última votação introduzida*/
                    break;
                case 9:
                    /*Terminar o programa*/
                    System.out.println("Programa terminado!");
                    break;
                default:
                    System.out.println("Inseriu opção inválida!");
                    break;
            }
        } while (opcao != 9);
    }

    /*Método para ler para a memória central o ficheiro "Deputados.txt". Valida o facto do nome do ficheiro ter de ter o nome "Deputados.txt". Valida a passagem de um número máximo de 230 linhas para o array FICHEIRO_DEPUTADOS. Utiliza as validações inerentes do método "guardarDadosDeputado", que utiliza.*/
    public static int lerParaMemoriaFicheiroDeputados(String[][] deputados, JFileChooser fc, File logErros, Formatter escrever) throws FileNotFoundException {
        String ficheiro = Utilitarios.selecionarFicheiro(fc);
        if (ficheiro.endsWith(FILE_DEPUTADOS)) {
            String[] conteudoFicheiro = Utilitarios.lerFicheiro(ficheiro);
            String[][] deputadosTemp = guardarDadosDeputados(conteudoFicheiro, logErros, escrever);
            System.arraycopy(deputadosTemp, 0, deputados, 0, deputadosTemp.length);
            return deputadosTemp.length;
        } else {
            System.out.println("Para leitura para a memória, o ficheiro selecionado tem de ter o nome \"Deputados.txt\".");
            return 0;
        }
    }
    /*Método para passar os dados de uma linha presente no ficheiro de texto Deputados.txt para a matriz da memória principal "deputados". Para essa linha ser passada para a matriz, a mesma não pode ser vazia; tem de ter o número de colunas certas; na coluna do ID, o ID tem de ser válido (recorre-se ao método "validaID") e o ID dessa linha não pode já estar presente na matriz "deputados" (recorre-se ao método "validaIDUnico")*/

    /*TODO: corrigir a linha específica onde é detetado um erro. atualmente se um ficheiro tiver mais que uma linha errada, a mensagem de erro vai dar um número errado quanto ao número da linha do erro.*/
    public static String[][] guardarDadosDeputados(String[] linhasFicheiro, File logErros, Formatter escrever) throws FileNotFoundException {
        int numLinhas = linhasFicheiro.length;
        String[][] deputados = new String[numLinhas][4];
        int linhasValidas = 0;
        for (int i = 0; i < numLinhas; i++) {
            String[] temp = linhasFicheiro[i].split(";");
            if (temp.length == 4) {
                String id = temp[0].trim();
                if (Utilitarios.validaID(id, COD_REGIOES)) {
                    if (Utilitarios.validaIDUnico(id, deputados, linhasValidas)) {
                        deputados[linhasValidas][0] = id;
                        deputados[linhasValidas][1] = temp[1].trim();
                        deputados[linhasValidas][2] = temp[2].trim();
                        deputados[linhasValidas][3] = temp[3].trim();
                        linhasValidas++;
                    } else {
                        String erro = "A linha ".concat(Integer.toString(linhasValidas + 1)).concat(" é uma linha inválida, dado o ID desta linha já existir para outro deputado registado previamente.");
                        LogErros.escreveNoFicheiroErros(erro, escrever);
                    }
                } else {
                    String erro = "A linha " + (linhasValidas + 1) + " é uma linha inválida, dado o ID ser inválido.";
                    LogErros.escreveNoFicheiroErros(erro, escrever);
                }
            } else {
                String erro = "A linha " + (linhasValidas + 1) + " é uma linha inválida, dado não ter número de colunas suficientes.";
                LogErros.escreveNoFicheiroErros(erro, escrever);
                System.out.println(erro);
            }
        }
        String[][] retorno = new String[linhasValidas][4];
        System.arraycopy(deputados, 0, retorno, 0, linhasValidas);
        escrever.close();
        return retorno;
    }

    public static int mostraDeputadosPaginado(String[][] deputados, int numeroDeputados) {
        if (numeroDeputados == 0) {
            System.out.println("Não existem dados para mostrar. Faça uma leitura prévia de dados (Opção 1 do menu principal) através de um ficheiro válido e com elementos válidos.");
        } else {
            int totalPaginas = devolveNumeroPaginas(numeroDeputados);
            System.out.println("Total de páginas: " + totalPaginas);
            System.out.println("Total de resultados por página: " + MAX_LINHAS_PAGINA);

            int[] iniciosPagina = devolveIniciosPagina(deputados, numeroDeputados);

            int posicao = 0;
            String acao;

            do {
                System.out.println("\n\nInsira \"ENTER\" para visualizar página seguinte \nInsira \"Número Página + ENTER\" para apresentar resultados \n---    Para terminar visualização insira \"F + ENTER\"    ---");
                Scanner ler = new Scanner(System.in);
                acao = ler.nextLine();
                if (!acao.equalsIgnoreCase("f")) {
                    if (acao.isEmpty()) {
                        posicao++;
                        int inicio = iniciosPagina[posicao];
                        int limite = inicio + MAX_LINHAS_PAGINA;
                        imprimeEcraCabecalhoDeputados();
                        for (int i = inicio; i <= limite; i++) {
                            System.out.println("");
                            for (int j = 0; j < 4; j++) {
                                Utilitarios.imprimeConteudoLinha(i, j, deputados);
                            }
                        }
                    } else {
                        int acaoNum = Integer.parseInt(acao);
                        if (acaoNum > 0 && acaoNum <= totalPaginas) {
                            posicao = acaoNum;
                            imprimeEcraCabecalhoDeputados();
                            int inicio = iniciosPagina[posicao];
                            int fim = inicio + MAX_LINHAS_PAGINA;
                            for (int i = inicio; i < fim; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, deputados);
                                }
                            }
                        } else {
                            System.out.println("Número de página inválido!");
                        }
                    }
                }
            } while (!acao.equalsIgnoreCase("f"));
        }
        return numeroDeputados;
    }

    public static void imprimeEcraCabecalhoDeputados() {
        System.out.println("\n|| ID    || NOME                          || PARTIDO || DATA NASC   ||\n"
            + "----------------------------------------------------------------------");
    }

    public static int[] devolveIniciosPagina(String[][] deputados, int numeroDeputados) {
        int numeroPaginas = devolveNumeroPaginas(numeroDeputados);
        int[] iniciosPagina = new int[numeroPaginas];
        int pagina = 0;
        for (int i = 0; i < numeroPaginas; i++) {
            iniciosPagina[i] = pagina;
            pagina += MAX_LINHAS_PAGINA;
        }
        return iniciosPagina;
    }

    public static int devolveNumeroPaginas(int numeroDeputados) {
        int numeroPaginas = (numeroDeputados / MAX_LINHAS_PAGINA) + 1;
        return numeroPaginas;
    }
}
