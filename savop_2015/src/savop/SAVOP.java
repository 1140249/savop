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
    public final static int MAX_DEPUTADOS = 230;
    public final static String FILE_DEPUTADOS = "Deputados.txt";
    public final static String PAGINA_HTML = "Pagina.html";
    public final static int MAX_LINHAS_PAGINA = 5;
    public final static String[] COD_REGIOES = {"AVE", "BEJ", "BRG", "BRA", "CAS", "COI", "EVO", "FAR", "GUA", "LEI", "LIS", "PTL", "PRT", "SAN", "SET", "VIA", "VRL", "VIS", "ACO", "MAD"};
    public static int NUMERO_DEPUTADOS = 0;
    public static int NUMERO_VOTACOES = 0;

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File logErros = LogErros.criaFicheiroErros();
        Formatter escrever = new Formatter(logErros);
        Scanner ler = new Scanner(System.in);
        String[][] deputados = new String[230][4];
        String[][] votacoes = new String[230][2];
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
                    NUMERO_DEPUTADOS = lerParaMemoriaFicheiroDeputados(deputados, logErros, escrever);
                    System.out.println("Ficheiro deputados carregado com sucesso!");
                    break;
                case 2:
                    /*Visualizar ficheiro deputados existente em memória (depois de iniciada a opção 1) usando paginação*/
                    mostraDeputadosPaginado(deputados, NUMERO_DEPUTADOS);
                    break;
                case 3:
                    /*Alterar informação de um deputado (depois de iniciada a opção 1)*/
                    break;
                case 4:
                    /*Ler de um ficheiro de texto selecionado pelo utilizador a informação referente a uma votação ocorrrida */
                    NUMERO_VOTACOES = lerVotacoes(votacoes);
                    System.out.println("Ficheiro votações carregado com sucesso!");
                    break;
                case 5:
                    /*Visualizar informação da opção 4 mas ordenada alfabeticamente pelo código de identificação*/
                    String matrizOrdenada[][] = Utilitarios.devolveMatrizCompletaVotacaoOrdenada(deputados, votacoes);
                    mostraVotacaoPaginado(matrizOrdenada, NUMERO_VOTACOES);
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

    /**
     *
     * @param deputados
     * @param fc
     * @param logErros
     * @param escrever
     * @return Método para ler para a memória central o ficheiro
     * "Deputados.txt". Devolve um inteiro que representa o número de deputados.
     * @throws FileNotFoundException
     */
    public static int lerParaMemoriaFicheiroDeputados(String[][] deputados, File logErros, Formatter escrever) throws FileNotFoundException {
        String[] conteudoFicheiro = Utilitarios.lerFicheiro(FILE_DEPUTADOS);
        String[][] deputadosTemp = guardarDadosDeputados(conteudoFicheiro, logErros, escrever);
        System.arraycopy(deputadosTemp, 0, deputados, 0, deputadosTemp.length);
        return deputadosTemp.length;
    }

    /**
     *
     * @param linhasFicheiro
     * @param logErros
     * @param escrever
     * @return Método para passar os dados de uma linha presente no array de
     * Strings dado como parâmetro para a matriz da memória principal
     * "deputados". Para essa linha ser passada para a matriz, a mesma não pode
     * ser vazia; tem de ter o número de colunas certas (4); na coluna do ID, o
     * ID tem de ser válido (recorre-se ao método "validaID") e o ID dessa linha
     * não pode já estar presente na matriz "deputados" (recorre-se ao método
     * "validaIDUnico"). O return é a matriz de deputados. Qualquer erro numa
     * linha do ficheiro que resulte na mesma em não ser passada é reportado num
     * ficheiro "log_erros.txt"
     * @throws FileNotFoundException
     */
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

    /**
     * @param deputados
     * @param numeroDeputados Método para mostrar a listagem de deputados na
     * consola de uma forma que permita a paginação. Para alterar o número de
     * elementos a mostrar por página, basta alterar o valor da constante
     * MAX_LINHAS_PAGINA.
     */
    public static void mostraDeputadosPaginado(String[][] deputados, int numeroDeputados) {
        int paginaAtual = 1;
        int totalPaginas = Utilitarios.devolveNumeroPaginas(numeroDeputados);
        if (totalPaginas == 0) {
            System.out.println("\nNão existem dados para mostrar. Faça uma leitura prévia de dados (Opção 1 do menu principal) através de um ficheiro válido e com elementos válidos.");
        } else {
            System.out.println("\nTotal de páginas: " + totalPaginas);
            System.out.println("Total de resultados por página: " + MAX_LINHAS_PAGINA);
            int[] iniciosPagina = Utilitarios.devolveIniciosPagina(deputados, numeroDeputados);
            String acao;
            int inicPrimeira = 0;
            int limPrimeira = MAX_LINHAS_PAGINA - 1;
            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
            for (int i = inicPrimeira; i <= limPrimeira; i++) {
                System.out.println("");
                for (int j = 0; j < 4; j++) {
                    Utilitarios.imprimeConteudoLinha(i, j, deputados);
                }
            }
            do {
                Utilitarios.imprimeInstrucoes();
                Scanner ler = new Scanner(System.in);
                acao = ler.nextLine();
                if (!acao.equalsIgnoreCase("f")) {
                    if (acao.isEmpty()) {
                        paginaAtual++;
                        if (paginaAtual <= totalPaginas) {
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = linhaInicial + MAX_LINHAS_PAGINA;
                            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                if (i < numeroDeputados) {
                                    System.out.println("");
                                    for (int j = 0; j < 4; j++) {
                                        Utilitarios.imprimeConteudoLinha(i, j, deputados);
                                    }
                                }
                            }
                        } else {
                            paginaAtual--;
                            System.out.println("Fim de listagem!");
                            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = numeroDeputados;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, deputados);
                                }
                            }
                        }
                    } else {
                        int acaoNum = Integer.parseInt(acao);
                        if (acaoNum > 0 && acaoNum < totalPaginas) {
                            paginaAtual = acaoNum;
                            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = linhaInicial + MAX_LINHAS_PAGINA;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, deputados);
                                }
                            }
                        } else if (acaoNum == totalPaginas) {
                            System.out.println("Fim de listagem!");
                            paginaAtual = acaoNum;
                            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = numeroDeputados;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
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
    }
    /*Método auxiliar para encontrar o deputado para alterar. Devolve um vetor de inteiros cujos valores correspondem às posicões correspontes às linhas na matriz de deputados dado como parâmetro que satisfazem as condições da String de input dado como parâmetro, na coluna indicada como parâmetro.*/

    public static int[] encontraDeputadoPorInput(String input, int coluna, String[][] deputados) {
        int resultadosEncontrados = 0;
        for (int i = 0; i < deputados.length; i++) {
            if (deputados[i][coluna].contains(input)) {
                resultadosEncontrados++;
            }
        }
        int[] deputadosEncontrados = new int[resultadosEncontrados];
        if (resultadosEncontrados != 0) {
            resultadosEncontrados = 0;
            for (int i = 0; i < deputados.length; i++) {
                if (deputados[i][coluna].contains(input)) {
                    deputadosEncontrados[resultadosEncontrados] = i;
                    resultadosEncontrados++;
                }
            }
        }
        return deputadosEncontrados;
    }

    public static void mostraDeputadosDeListaLinhas(int[] posicoesEncontradas, String[][] deputados) {
        for (int i = 0; i < posicoesEncontradas.length; i++) {
            System.out.println("");
        }

    }

    public static void selecionaDeputadoDeLista(String[][] deputados, int[] posicoesEncontradas) {
        boolean terminar = true;
        do {
            if (posicoesEncontradas.length == 0) {
                String resposta;
                System.out.println("\nNão existem nenhuns resultados que satisfaçam a sua pesquisa!");
                do {
                    System.out.println("\nPretende continuar a sua pesquisa? (S/N)");
                    Scanner ler = new Scanner(System.in);
                    resposta = ler.nextLine();
                    if (resposta.equalsIgnoreCase("n")) {
                        terminar = true;
                    } else if (resposta.equalsIgnoreCase("s")) {
                        terminar = false;
                    } else {
                        System.out.println("Resposta inválida! "
                            + "\nPrima \"S\" para continuar pesquisa."
                            + "\nPrima \"N\" para terminar pesquisa.");
                    }
                } while (resposta.equalsIgnoreCase("s") && resposta.equalsIgnoreCase("n"));
            } else if (posicoesEncontradas.length == 1) {

            } else {
            }
        } while (terminar == false);
    }

    /*Método auxiliar para obter, através da interação com o utilizador, qual a coluna onde efetuar pesquisa. Devolve -1 caso o utilizador escolha a opcão "terminar". Devolve "0" para ID, "1" para nome, "2" para partido e "3" para data de nascimento*/
    public static int obtemColunaPesquisa() {
        int opcao;
        do {
            System.out.println("\nInsira qual o campo a pesquisar:"
                + "\n1 - ID"
                + "\n2 - Nome"
                + "\n3 - Partido"
                + "\n4 - Data Nascimento"
                + "\n"
                + "\n5 - Terminar");
            Scanner ler = new Scanner(System.in);
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return -1;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5);
        return -1;
    }

    /*Método auxiliar para obter a string de input que o utilizar quer pesquisar*/
    public static String obtemInput(int coluna) {
        String campo = obtemNomeCampo(coluna);
        System.out.println("\nInsira valor a pesquisar na coluna \"" + campo + "\":");
        Scanner ler = new Scanner(System.in);
        String input = ler.nextLine();
        return input;
    }

    /*Método auxiliar para obter o campo correspondente à coluna. Devolve ID para 0, Nome para 1, Partido para 2 e Data Nascimento para 3. Devolve String vazia para qualquer outro valor.*/
    public static String obtemNomeCampo(int coluna) {
        switch (coluna) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Partido";
            case 3:
                return "Data Nascimento";
            default:
                return "";
        }
    }

    /**
     * @param matrizCompletaOrdenada
     * @param numeroVotos Método para mostrar a listagem de deputados na consola
     * de uma forma que permita a paginação. Para alterar o número de elementos
     * a mostrar por página, basta alterar o valor da constante
     * MAX_LINHAS_PAGINA.
     */
    public static void mostraVotacaoPaginado(String[][] matrizCompletaOrdenada, int numeroVotos) {
        int paginaAtual = 1;
        int totalPaginas = Utilitarios.devolveNumeroPaginas(numeroVotos);
        if (totalPaginas == 0) {
            System.out.println("\nNão existem dados para mostrar. Faça uma leitura prévia de dados (Opção 1 do menu principal) através de um ficheiro válido e com elementos válidos.");
        } else {
            System.out.println("\nTotal de páginas: " + totalPaginas);
            System.out.println("Total de resultados por página: " + MAX_LINHAS_PAGINA);
            int[] iniciosPagina = Utilitarios.devolveIniciosPagina(matrizCompletaOrdenada, numeroVotos);
            String acao;
            int inicPrimeira = 0;
            int limPrimeira = MAX_LINHAS_PAGINA - 1;
            Utilitarios.imprimeEcraCabecalhoVotacoes(paginaAtual, totalPaginas);
            for (int i = inicPrimeira; i <= limPrimeira; i++) {
                System.out.println("");
                for (int j = 0; j < 4; j++) {
                    Utilitarios.imprimeConteudoLinha(i, j, matrizCompletaOrdenada);
                }
            }
            do {
                Utilitarios.imprimeInstrucoes();
                Scanner ler = new Scanner(System.in);
                acao = ler.nextLine();
                if (!acao.equalsIgnoreCase("f")) {
                    if (acao.isEmpty()) {
                        paginaAtual++;
                        if (paginaAtual <= totalPaginas) {
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = linhaInicial + MAX_LINHAS_PAGINA;
                            Utilitarios.imprimeEcraCabecalhoDeputados(paginaAtual, totalPaginas);
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                if (i < numeroVotos) {
                                    System.out.println("");
                                    for (int j = 0; j < 4; j++) {
                                        Utilitarios.imprimeConteudoLinha(i, j, matrizCompletaOrdenada);
                                    }
                                }
                            }
                        } else {
                            paginaAtual--;
                            System.out.println("Fim de listagem!");
                            Utilitarios.imprimeEcraCabecalhoVotacoes(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = numeroVotos;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, matrizCompletaOrdenada);
                                }
                            }
                        }
                    } else {
                        int acaoNum = Integer.parseInt(acao);
                        if (acaoNum > 0 && acaoNum < totalPaginas) {
                            paginaAtual = acaoNum;
                            Utilitarios.imprimeEcraCabecalhoVotacoes(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = linhaInicial + MAX_LINHAS_PAGINA;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, matrizCompletaOrdenada);
                                }
                            }
                        } else if (acaoNum == totalPaginas) {
                            System.out.println("Fim de listagem!");
                            paginaAtual = acaoNum;
                            Utilitarios.imprimeEcraCabecalhoVotacoes(paginaAtual, totalPaginas);
                            int linhaInicial = iniciosPagina[paginaAtual - 1];
                            int linhaFinal = numeroVotos;
                            for (int i = linhaInicial; i < linhaFinal; i++) {
                                System.out.println("");
                                for (int j = 0; j < 4; j++) {
                                    Utilitarios.imprimeConteudoLinha(i, j, matrizCompletaOrdenada);
                                }
                            }
                        } else {
                            System.out.println("Número de página inválido!");
                        }
                    }
                }
            } while (!acao.equalsIgnoreCase("f"));
        }
    }

    public static String obterFicheiro() {
        System.out.println("Insira o nome do ficheiro: ");
        Scanner ler = new Scanner(System.in);
        String nomeFicheiro = ler.nextLine();
        return nomeFicheiro;
    }

    public static String[][] guardarVotacoes(String[] votacoes, int numeroVotos) {
        String[][] retorno = new String[230][2];
        for (int i = 0; i < numeroVotos; i++) {
            String ID = votacoes[i].substring(0, 5);
            String voto = votacoes[i].substring(5);
            retorno[i][0] = ID;
            retorno[i][1] = voto;
        }
        return retorno;
    }

    public static int lerVotacoes(String[][] votacoes) throws FileNotFoundException {
        String nomeFicheiro = obterFicheiro();
        String[] conteudoFicheiro = Utilitarios.lerFicheiro(nomeFicheiro);
        System.arraycopy(guardarVotacoes(conteudoFicheiro,conteudoFicheiro.length), 0, votacoes, 0, conteudoFicheiro.length);
        return conteudoFicheiro.length;
    }

}
