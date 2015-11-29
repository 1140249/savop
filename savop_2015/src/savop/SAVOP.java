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

/**
 *
 * @author RicardoMoreira(11402
 */
public class SAVOP {

    public final static int MAX_DEPUTADOS = 230;
    public final static String FILE_DEPUTADOS = "Deputados.txt";
    public final static String PAGINA_HTML = "Pagina.html";
    public final static int MAX_LINHAS_PAGINA = 5;
    public final static String[] COD_REGIOES = {"AVE", "BEJ", "BRG", "BRA", "CAS", "COI", "EVO", "FAR", "GUA", "LEI", "LIS", "PTL", "PRT", "SAN", "SET", "VIA", "VRL", "VIS", "ACO", "MAD"};
    public static int NUMERO_DEPUTADOS = 0;
    public static int NUMERO_VOTACOES = 0;
    public static String[] PARTIDOS;
    public static boolean FICHEIRO_DEPUTADOS_CARREGADO = false;
    public static boolean FICHEIRO_VOTACAO_CARREGADO = false;
    public static String NOME_FICHEIRO_VOTACOES_CARREGADO;

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
        int[][] matrizResultadosVotacoes;
        int opcao;
        do {
            System.out.println("\nInsira opção: "
                + "\n1 - Ler ficheiro Deputados e guardar na memória principal"
                + "\n2 - Mostrar listagem Deputados paginada"
                + "\n3 - Alterar informação deputado"
                + "\n4 - Ler ficheiro de votação e carregá-lo na memória principal"
                + "\n5 - Visualisar votação em memória ordenada por ID deputado"
                + "\n6 - Visualizar votação em memória compilada por resultados e escrita dos mesmo para ficheiro"
                + "\n7 - Visualisar votação em memória compilada por faixa etária"
                + "\n8 - Visualizar votação em memória compilada por resultados em página HTML"
                + "\n9 - Terminar o programa"
            );

            while (!ler.hasNextInt()) {
                ler.nextLine();
                System.out.println("Opção inválida!");
            }
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    /*Ler ficheiro deputados e armazená-la na memória principal*/
                    NUMERO_DEPUTADOS = lerDeputados(deputados, logErros, escrever);
                    PARTIDOS = Utilitarios.retornaVetorPartidos(deputados, NUMERO_DEPUTADOS);
                    Utilitarios.ordenaVetorPartidosPorTotalDeputados(PARTIDOS, deputados, NUMERO_DEPUTADOS);
                    System.out.println("Ficheiro deputados carregado com sucesso!");
                    FICHEIRO_DEPUTADOS_CARREGADO = true;
                    break;
                case 2:
                    /*Visualizar ficheiro deputados existente em memória (depois de iniciada a opção 1) usando paginação*/
                    if (!FICHEIRO_DEPUTADOS_CARREGADO) {
                        System.out.println("\n\"O ficheiro de deputados ainda não foi carregado. Insira a opção \"1 - Ler ficheiro Deputados e guardar na memória principal\" primeiro, para poder visualizar a listagem de deputadas paginada.");
                    } else {
                        mostraDeputadosPaginado(deputados, NUMERO_DEPUTADOS);
                    }
                    break;
                case 3:
                    /*Alterar informação de um deputado (depois de iniciada a opção 1)*/
                    if (!FICHEIRO_DEPUTADOS_CARREGADO) {
                        System.out.println("O ficheiro de deputados ainda não foi carregado. Insira a opção \"1 - Ler ficheiro Deputados e guardar na memória principal\" primeiro, para poder fazer a alteração de dados.");
                    } else {
                        alteraDadosDeputado(deputados, NUMERO_DEPUTADOS);
                    }
                    break;

                case 4:
                    /*Ler de um ficheiro de texto selecionado pelo utilizador a informação referente a uma votação ocorrrida */
                    if (!FICHEIRO_DEPUTADOS_CARREGADO) {
                        System.out.println("O ficheiro de deputados ainda não foi carregado. Insira a opção \"1 - Ler ficheiro Deputados e guardar na memória principal\" primeiro, para poder fazer a alteração de dados.");
                    } else {
                        NUMERO_VOTACOES = lerVotacoes(votacoes);
                        FICHEIRO_VOTACAO_CARREGADO = true;
                        Utilitarios.eliminaErrosVotacoes(votacoes, deputados);
                        System.out.println("Ficheiro votações carregado com sucesso!");
                    }
                    break;

                case 5:
                    /*Visualizar informação da opção 4 mas ordenada alfabeticamente pelo código de identificação*/
                    if (!FICHEIRO_DEPUTADOS_CARREGADO) {
                        System.out.println("O ficheiro de deputados ainda não foi carregado. Insira a opção \"1 - Ler ficheiro Deputados e guardar na memória principal\" primeiro, para poder fazer a alteração de dados.");
                    } else {
                        if (!SAVOP.FICHEIRO_VOTACAO_CARREGADO) {
                            System.out.println("Ficheiro de votações ainda não foi carregado! Selecione opção \"4 - Ler ficheiro de votação e carregá-lo na memória principal\" antes de utilizar a corrente opção.");
                        } else {
                            String matrizOrdenada[][] = Utilitarios.devolveMatrizCompletaVotacaoOrdenada(deputados, votacoes);
                            mostraVotacoesPaginado(matrizOrdenada, NUMERO_VOTACOES);
                        }
                    }
                    break;
                case 6:
                    /*Visualizar no ECRÃ os resultados da última votação introduzida e guardar dados num ficheiro de texto cujo nome seja a palavra Resultados, concatenada com o título da votação*/
                    matrizResultadosVotacoes = Utilitarios.criarMatrizVaziaResultadosVotacoes(PARTIDOS);
                    Utilitarios.calculaResultadosVotacoes(matrizResultadosVotacoes, votacoes, NUMERO_VOTACOES, deputados, NUMERO_DEPUTADOS);
                    apresentaEcraResultadosVotacoes(matrizResultadosVotacoes);
                    apresentaFicheiroResultadosVotacoes(matrizResultadosVotacoes);
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
    public static int lerDeputados(String[][] deputados, File logErros, Formatter escrever) throws FileNotFoundException {
        String[] conteudoFicheiro = Utilitarios.lerFicheiro(FILE_DEPUTADOS);
        String[][] deputadosTemp = guardarDeputados(conteudoFicheiro, logErros, escrever);
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
    public static String[][] guardarDeputados(String[] linhasFicheiro, File logErros, Formatter escrever) throws FileNotFoundException {
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
                Utilitarios.imprimeConteudoCelulaDeputados(i, j, deputados);
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
                                    Utilitarios.imprimeConteudoCelulaDeputados(i, j, deputados);
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
                                Utilitarios.imprimeConteudoCelulaDeputados(i, j, deputados);
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
                                Utilitarios.imprimeConteudoCelulaDeputados(i, j, deputados);
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
                                Utilitarios.imprimeConteudoCelulaDeputados(i, j, deputados);
                            }
                        }
                    } else {
                        System.out.println("Número de página inválido!");
                    }
                }
            }
        } while (!acao.equalsIgnoreCase("f"));

    }

    public static void alteraDadosDeputado(String[][] deputados, int numeroDeputados) {
        int linhaDeputado = -1;
        boolean continuaPesquisa = false;
        do {
            String idDeputado = Utilitarios.obtemInput("\nInsira qual o ID do deputado que pretende alterar:");
            int linha = Utilitarios.encontraDeputadoPorID(idDeputado, deputados, NUMERO_DEPUTADOS);
            if (linha == -1) {
                if (Utilitarios.confirmaSimNao("\nNão foi encontrado nenhum registo com o ID fornecido. Pretende fazer nova pesquisa?")) {
                    continuaPesquisa = true;
                } else {
                    continuaPesquisa = false;
                    System.out.println("\nPesquisa de deputado terminada!");
                }
            } else {
                linhaDeputado = linha;
                continuaPesquisa = false;
            }
        } while (continuaPesquisa);

        if (linhaDeputado == -1) {
            System.out.println("\nOpção de alteração de dados de deputado terminada!");
        } else {
            System.out.println("\nDADOS ATUAIS DO DEPUTADO:");
            Utilitarios.imprimeEcraCabecalhoDeputados(1, 1);
            for (int i = 0; i < 4; i++) {
                Utilitarios.imprimeConteudoCelulaDeputados(linhaDeputado, i, deputados);
            }
            boolean continuaAlterar = false;
            do {
                Scanner ler = new Scanner(System.in);
                String novoValor = "nada preenchido";
                int colunaAlterar = Utilitarios.obtemColunaAlterarDeputados();
                switch (colunaAlterar) {
                    case -1:
                        System.out.println("\nAlteração de dados terminada!");
                        continuaAlterar = true;
                        break;
                    case 0:
                        System.out.println("\nInsira novo ID:");
                        novoValor = ler.nextLine();
                        break;
                    case 1:
                        System.out.println("\nInsira novo NOME:");
                        novoValor = ler.nextLine();
                        break;
                    case 2:
                        System.out.println("\nInsira novo PARTIDO:");
                        novoValor = ler.nextLine();
                        break;
                    case 3:
                        System.out.println("\nInsira nova DATA NASCIMENTO:");
                        novoValor = ler.nextLine();
                        break;
                    default:
                        System.out.println("erro!");
                }
                if (!continuaAlterar) {
                    System.out.println("\nNovos dados do deputado:");
                    Utilitarios.imprimeEcraCabecalhoDeputados(1, 1);
                    for (int i = 0; i < 4; i++) {
                        if (i != colunaAlterar) {
                            Utilitarios.imprimeConteudoCelulaDeputados(linhaDeputado, i, deputados);
                        } else {
                            String[][] deputadosTemp = new String[1][4];
                            deputadosTemp[0] = deputados[linhaDeputado];
                            deputadosTemp[0][colunaAlterar] = novoValor;
                            Utilitarios.imprimeConteudoCelulaDeputados(0, colunaAlterar, deputadosTemp);
                        }
                    }

                    if (Utilitarios.confirmaSimNao("\n\nPretende gravar alterações?")) {
                        deputados[linhaDeputado][colunaAlterar] = novoValor;
                        continuaAlterar = false;
                    } else {
                        System.out.println("\nAlterações não gravadas!");
                        if (Utilitarios.confirmaSimNao("\nPretende fazer novas alterações?")) {
                            continuaAlterar = true;
                        } else {
                            System.out.println("\nAlteração de dados concluída!");
                            continuaAlterar = false;
                        }
                    }

                }
            } while (continuaAlterar);
        }
    }

    public static int lerVotacoes(String[][] votacoes) throws FileNotFoundException {
        String nomeFicheiro = Utilitarios.obtemInput("Insira o nome do ficheiro:");
        String[] conteudoFicheiro = Utilitarios.lerFicheiro(nomeFicheiro);
        System.arraycopy(guardarVotacoes(conteudoFicheiro, conteudoFicheiro.length), 0, votacoes, 0, conteudoFicheiro.length);
        SAVOP.NOME_FICHEIRO_VOTACOES_CARREGADO = nomeFicheiro;
        return conteudoFicheiro.length;
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

    /**
     * @param matrizCompletaOrdenada
     * @param numeroVotos Método para mostrar a listagem de deputados na consola
     * de uma forma que permita a paginação. Para alterar o número de elementos
     * a mostrar por página, basta alterar o valor da constante
     * MAX_LINHAS_PAGINA.
     */
    public static void mostraVotacoesPaginado(String[][] matrizCompletaOrdenada, int numeroVotos) {
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
                    Utilitarios.imprimeConteudoCelulaDeputados(i, j, matrizCompletaOrdenada);
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
                                        Utilitarios.imprimeConteudoCelulaDeputados(i, j, matrizCompletaOrdenada);
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
                                    Utilitarios.imprimeConteudoCelulaDeputados(i, j, matrizCompletaOrdenada);
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
                                    Utilitarios.imprimeConteudoCelulaDeputados(i, j, matrizCompletaOrdenada);
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
                                    Utilitarios.imprimeConteudoCelulaDeputados(i, j, matrizCompletaOrdenada);
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

    public static void apresentaEcraResultadosVotacoes(int[][] matrizResultadosVotacoes) {
        String nomeFicheiro = Utilitarios.removerExtensaoFicheiro(NOME_FICHEIRO_VOTACOES_CARREGADO);     
        System.out.println("\nVotação de: " + nomeFicheiro + "\n");
        for (int i = 0; i < matrizResultadosVotacoes.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrizResultadosVotacoes[0].length; j++) {
                Utilitarios.imprimeConteudoCelulaVotos(i, j, matrizResultadosVotacoes, PARTIDOS);
            }
            if (i == matrizResultadosVotacoes.length - 2) {
                System.out.println("");
            }
        }
        System.out.println("");
    }


    public static void apresentaFicheiroResultadosVotacoes(int[][] matrizResultadosVotacoes) throws FileNotFoundException {
        String nomeFicheiro = "Resultados"+Utilitarios.removerExtensaoFicheiro(NOME_FICHEIRO_VOTACOES_CARREGADO)+".txt";
        File ficheiro = new File(nomeFicheiro);
        Formatter escrever = new Formatter(ficheiro);
        escrever.format("\nVotação de: "+Utilitarios.removerExtensaoFicheiro(NOME_FICHEIRO_VOTACOES_CARREGADO)+"\n");
        for (int i = 0; i < matrizResultadosVotacoes.length; i++) {
            escrever.format("\n");
            for (int j = 0; j < matrizResultadosVotacoes[0].length; j++) {
                Utilitarios.escreveFicheiroConteudoCelulaVotos(i, j, matrizResultadosVotacoes, PARTIDOS,ficheiro,escrever);
            }
            if (i == matrizResultadosVotacoes.length - 2) {
                escrever.format("\n");
            }
        }
        escrever.format("");
        escrever.close();
    }

}
