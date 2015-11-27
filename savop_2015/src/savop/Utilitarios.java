/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author RicardoMoreira(11402
 */
public class Utilitarios {

    public static void calculaIdade() {
    }

    /*método que devolve um vetor de inteiros com ano, mes, dia nas posicoes 0,1,2*/
    public static int[] devolveDataAtual() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int data[] = new int[3];
        data[0] = year;
        data[1] = month;
        data[2] = day;
        return data;
    }

    public static int[] converteData(String data) {
        int[] dataConvertida = new int[3];
        String ano = data.substring(0, 3);
        String mes = data.substring(4, 5);
        String dia = data.substring(6, 7);
        int anoInt = Integer.parseInt(ano);
        int mesInt = Integer.parseInt(mes);
        int diaInt = Integer.parseInt(dia);
        dataConvertida[0] = anoInt;
        dataConvertida[1] = mesInt;
        dataConvertida[2] = diaInt;
        return dataConvertida;
    }

    /**
     *
     */
    public static String[][] ordenaAlfaMatrizVotacoesColuna(String[][] matrizVotacoes, int numeroVotacoes) {
        boolean naoOrdenou = true;
        do {
            naoOrdenou = true;
            for (int i = 0; i < numeroVotacoes - 1; i++) {
                if (matrizVotacoes[i][0].compareToIgnoreCase(matrizVotacoes[i + 1][0]) > 0) {
                    String aux1 = matrizVotacoes[i][0];
                    String aux2 = matrizVotacoes[i][1];
                    matrizVotacoes[i][0] = matrizVotacoes[i + 1][0];
                    matrizVotacoes[i][1] = matrizVotacoes[i + 1][1];
                    matrizVotacoes[i + 1][0] = aux1;
                    matrizVotacoes[i + 1][1] = aux2;
                    naoOrdenou = false;
                }
            }
        } while (!naoOrdenou);
        return matrizVotacoes;
    }

    public static String[] devolveInfoVotosByID(String[][] deputados, String[][] matrizVotos, String id) {
        int linha = 0;
        String[] impressao = new String[4];
        while (!id.equalsIgnoreCase(matrizVotos[linha][0]) && linha < SAVOP.NUMERO_VOTACOES) {
            linha++;
        }
        impressao[0] = matrizVotos[linha][0];
        impressao[3] = matrizVotos[linha][1];

        linha = 0;
        while (!id.equalsIgnoreCase(deputados[linha][0]) && linha < SAVOP.NUMERO_DEPUTADOS) {
            linha++;
        }

        String[] primeiroUltimo = obtemPrimeiroUltimoNome(deputados[linha][1]);
        String nomePrimeiroUltimo = primeiroUltimo[0].concat(" ").concat(primeiroUltimo[1]);
        impressao[1] = nomePrimeiroUltimo;
        impressao[2] = deputados[linha][2];
        return impressao;
    }

    public static String[][] devolveMatrizCompletaVotacaoOrdenada(String deputados[][], String[][] matrizVotos) {
        String[][] matrizVotosOrdenada = ordenaAlfaMatrizVotacoesColuna(matrizVotos, SAVOP.NUMERO_VOTACOES);
        String[][] matrizCompletaOrdenada = new String[matrizVotosOrdenada.length][4];
        for (int i = 0; i < SAVOP.NUMERO_VOTACOES; i++) {
            String[] resultadoLinha = devolveInfoVotosByID(deputados, matrizVotos, matrizVotosOrdenada[i][0]);
            matrizCompletaOrdenada[i][0] = resultadoLinha[0];
            matrizCompletaOrdenada[i][1] = resultadoLinha[1];
            matrizCompletaOrdenada[i][2] = resultadoLinha[2];
            matrizCompletaOrdenada[i][3] = resultadoLinha[3];
        }
        return matrizCompletaOrdenada;

    }

    public static String[] obtemPrimeiroUltimoNome(String nomeCompleto) {
        String[] nomes = nomeCompleto.split(" ");
        String primeiro;
        String ultimo;
        if (nomes.length == 0) {
            primeiro = "";
            ultimo = "";
        } else if (nomes.length == 1) {
            primeiro = nomes[0];
            ultimo = "";
        } else {
            primeiro = nomes[0];
            ultimo = nomes[nomes.length - 1];
        }
        String primeiroUltimo[] = {primeiro, ultimo};
        return primeiroUltimo;
    }

    /**
     * @param paginaAtual
     * @param totalPaginas Método auxiliar que imprime um cabeçalho consoante o
     * número da página atual e do número total de páginas dados como parâmetros
     * para a paginação deputados.
     */
    public static void imprimeEcraCabecalhoDeputados(int paginaAtual, int totalPaginas) {
        System.out.println("Página: " + paginaAtual + "/" + totalPaginas);
        System.out.println("\n|| ID    || NOME                          || PARTIDO || DATA NASC   ||\n"
            + "----------------------------------------------------------------------");
    }

    /**
     * @param paginaAtual
     * @param totalPaginas Método auxiliar que imprime um cabeçalho consoante o
     * número da página atual e do número total de páginas dados como parâmetros
     * para a paginação votações.
     */
    public static void imprimeEcraCabecalhoVotacoes(int paginaAtual, int totalPaginas) {
        System.out.println("Página: " + paginaAtual + "/" + totalPaginas);
        System.out.println("\n|| ID    || NOME                          || PARTIDO || VOTO        ||\n"
            + "----------------------------------------------------------------------");
    }

    /**
     * Método auxiliar que faz a impressão das instruções presentes na paginação
     * de deputados.
     */
    public static void imprimeInstrucoes() {
        System.out.println("\n"
            + "----------------------------------------------------------------------"
            + "\nPágina seguinte: pressione \"ENTER\""
            + "\nPágina específica: insira \"Número Página\" + pressione \"ENTER\""
            + "\nTerminar: insira \"F\" + pressione \"ENTER\"");
    }

    /**
     *
     * @param deputados
     * @param numeroDeputados
     * @return Método auxiliar que devolve um array de inteiros que contém, em
     * cada posicao, a linha correspondente ao início da página, com base no
     * máximo de linhas por página. Exemplo: se o número de deputados for 20 e o
     * máximo de linhas por página for 5, o retorno será {0,5,10,15}
     */
    public static int[] devolveIniciosPagina(String[][] deputados, int numeroDeputados) {
        int numeroPaginas = devolveNumeroPaginas(numeroDeputados);
        int[] iniciosPagina = new int[numeroPaginas];
        int pagina = 0;
        for (int i = 0; i < numeroPaginas; i++) {
            iniciosPagina[i] = pagina;
            pagina += SAVOP.MAX_LINHAS_PAGINA;
        }
        return iniciosPagina;
    }

    /**
     *
     * @param numeroDeputados
     * @return Método auxiliar que devolve o número total de páginas consoante o
     * número de deputados dado como parâmetro e o valor da constante
     * MAX_LINHAS_PAGINA. Exemplo: se o número de deputados for 20, e o
     * MAX_LINHAS_PAGINA for 5, o retorno será 4.
     */
    public static int devolveNumeroPaginas(int numeroDeputados) {
        int numeroPaginas;
        if (numeroDeputados == 0) {
            numeroPaginas = 0;
        } else {
            numeroPaginas = (numeroDeputados / SAVOP.MAX_LINHAS_PAGINA) + 1;
        }
        return numeroPaginas;
    }

    /**/
    /**
     *
     * @param id
     * @param COD_REGIOES
     * @return Valida o ID recebido como parâmetro. Se o ID for inválido, o
     * resultado será false. True para o inverso. Permite no futuro que se
     * possam detalhar melhor o reporte do erro em questão dado gerar um vetor
     * de boleanos que guarda qual a situação em que foi detetado o erro. Pode
     * utilizar-se esse array no futuro para personalizar as mensagens.
     */
    public static boolean validaID(String id, String[] COD_REGIOES) {
        boolean[] idValido = {true, true, true, true};

        /*valida tamanho String ID*/
        if (id.length() != 5) {
            idValido[0] = false;
        }

        /*valida que os 3 primeiros caracteres correspondem ao código de um distrito válido, existente numa constante dada como parâmetro que contém a listagem de distritos válidos. não distingue maiúsculas e minúsculas*/
        int numeroRegiao = 0;
        while (id.substring(0, 2).equalsIgnoreCase(COD_REGIOES[numeroRegiao]) && numeroRegiao < COD_REGIOES.length) {
            numeroRegiao++;
        }
        if (numeroRegiao == COD_REGIOES.length) {
            idValido[1] = false;
        }

        String[] algarismos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        /*valida que o caracter 4 corresponde a um algarismo*/
        int posicao = 0;
        while (id.substring(4, 4).equals(algarismos[posicao]) && posicao < 10) {
            posicao++;
        }
        if (posicao == 10) {
            idValido[2] = false;
        }

        /*valida que o caracter 5 corresponde a um algarismo*/
        posicao = 0;
        while (id.substring(4, 4).equals(algarismos[posicao]) && posicao < 10) {
            posicao++;
        }
        if (posicao == 10) {
            idValido[3] = false;
        }

        /*caso todas as validações estejam a true, devolve true, de contrário devolve false*/
        for (int i = 0; i < idValido.length; i++) {
            if (!idValido[i]) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    /**
     *
     * @param id
     * @param deputados
     * @param maxProcura
     * @return valida que o "id" recebido como parâmetro ainda não se encontra
     * presente na listagem "deputados" enviada como parâmetro até à linha
     * indicada como parâmetro na variável "maxProcura". Devolve false caso não
     * passe no teste. True para o inverso.
     */
    public static boolean validaIDUnico(String id, String[][] deputados, int maxProcura) {
        int posicao = 0;
        while (posicao < maxProcura && !deputados[posicao][0].equals(id)) {
            posicao++;
        }
        if (posicao == maxProcura) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * método inativado dado o método de leitura do ficheiro de deputados passar
     * a requerer apenas o ficheiro local e não o ficheiro selecionado pelo
     * utilizador
     *
     * @param fc
     * @return
     * @throws FileNotFoundException Obtém o nome de um ficheiro selecionado
     * pelo utilizador através de um objeto do tipo JFileChooser. Retorna uma
     * String com esse nome.
     */
    /*
     public static String selecionarFicheiro(JFileChooser fc) throws FileNotFoundException {
     fc.setDialogTitle("Selecione ficheiro para leitura");
     fc.showOpenDialog(fc);
     return fc.getSelectedFile().getAbsolutePath();
     }
     */
    /**
     *
     * @param ficheiro
     * @return Retorna um vetor de Strings com o conteúdo de um ficheiro cujo
     * nome é dado como parâmetro. O vetor tem tamanho máximo de 230 linhas mas
     * terá o tamanho correspondente ao número de linhas não vazias que o
     * ficheiro tiver e respetivo conteúdo. Resulta que se o ficheiro tiver 20
     * linhas não vazias, o vetor de Strings terá tamanho 20.
     * @throws FileNotFoundException
     */
    public static String[] lerFicheiro(String ficheiro) throws FileNotFoundException {
        Scanner ler = new Scanner(new File(ficheiro));
        String conteudo[] = new String[230];
        int numeroLinhasCarregadas = 0;
        while (ler.hasNextLine() && numeroLinhasCarregadas <= 230) {
            String aux = ler.nextLine();
            if (!aux.isEmpty()) {
                conteudo[numeroLinhasCarregadas] = aux;
                numeroLinhasCarregadas++;
            }
        }
        ler.close();
        String[] retorno = new String[numeroLinhasCarregadas];
        System.arraycopy(conteudo, 0, retorno, 0, numeroLinhasCarregadas);
        return retorno;

    }

    /**
     *
     * @param ficheiro
     * @return Retorna um vetor de booleans contendo as posicões do ficheiro
     * passado por parâmetro que têm conteúdo a false e as que estão vazias a
     * true. É útil para, por exemplo, poder especificar em que linhas do
     * ficheiro existem erros ou obter o número total de linhas de um ficheiro,
     * através do método length aplicado ao vetor retornado
     * @throws FileNotFoundException
     */
    public static boolean[] linhasVaziasFicheiro(String ficheiro) throws FileNotFoundException {
        Scanner ler1 = new Scanner(new File(ficheiro));
        int totalLinhas = 0;
        while (ler1.hasNextLine()) {
            totalLinhas++;
            ler1.nextLine();
        }
        ler1.close();
        Scanner ler2 = new Scanner(new File(ficheiro));
        boolean[] linhasVazias = new boolean[totalLinhas];
        for (int i = 0; i < totalLinhas; i++) {
            linhasVazias[i] = false;
        }
        int linha = 0;
        while (ler2.hasNextLine()) {
            if (ler2.nextLine().isEmpty()) {
                linhasVazias[linha] = true;
            }
            linha++;
        }
        return linhasVazias;
    }

    /**
     * @param linha
     * @param coluna
     * @param deputados Método que imprime para o ecrã o conteúdo da linha e
     * coluna dada como parâmetro no formato adequado da coluna, dada como
     * parâmetro. Este método é útil para apresentar de uma forma correta o
     * conteúdo da matriz deputados alinhado com as tabulações do cabeçalho do
     * mesmo.
     */
    public static void imprimeConteudoCelula(int linha, int coluna, String[][] deputados) {
        int quantidadeEspacos;
        switch (coluna) {
            case 0:
                quantidadeEspacos = 3;
                imprimeEspacos(quantidadeEspacos);
                System.out.printf(deputados[linha][coluna]);
                break;
            case 1:
                quantidadeEspacos = 4;
                imprimeEspacos(quantidadeEspacos);
                System.out.printf(deputados[linha][coluna]);
                break;
            case 2:
                quantidadeEspacos = 33 - deputados[linha][1].length();
                imprimeEspacos(quantidadeEspacos);
                System.out.printf(deputados[linha][coluna]);
                break;
            case 3:
                quantidadeEspacos = 11 - deputados[linha][2].length();
                imprimeEspacos(quantidadeEspacos);
                System.out.printf(deputados[linha][coluna]);
                break;
            default:
                System.out.println("Erro!");
        }

    }

    /**
     * @param quantidadeEspacos Método auxiliar para imprimir tantos espaços
     * quantos o número passado como parâmetro.
     */
    public static void imprimeEspacos(int quantidadeEspacos) {
        for (int i = 0; i < quantidadeEspacos; i++) {
            System.out.printf(" ");
        }
    }

    /*Método auxiliar que devolve true para sim, false para não, consoante a resposta do utilizador à oergunta fornecida como parâmetro*/
    public static boolean confirmaSimNao(String pergunta) {
        String resposta;
        do {
            System.out.println(pergunta + " (S/N)");
            Scanner ler = new Scanner(System.in);
            resposta = ler.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                return true;
            } else if (resposta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Inseriu opção inválida! Insira \"S\"+Enter ou \"N\"+Enter");
            }
        } while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
        return true;
    }

    /*Método auxiliar que devolve a resposta do utilizador numa String, a uma pergunta enviada como parâmetro*/
    public static String obtemInput(String pergunta) {
        System.out.println(pergunta);
        Scanner ler = new Scanner(System.in);
        String input = ler.nextLine();
        return input;
    }

    /*Método auxiliar para obter o campo correspondente à coluna. Devolve ID para 0, Nome para 1, Partido para 2 e Data Nascimento para 3. Devolve String vazia para qualquer outro valor.*/
    public static String obtemNomeCampoDeputados(int coluna) {
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

    /*Método auxiliar para obter o valor a ser pesquisado na coluna inserida como parâmetro*/
    public static String obtemValorPesquisa(int coluna) {
        String campo = Utilitarios.obtemNomeCampoDeputados(coluna);
        System.out.println("\nInsira valor a pesquisar na coluna \"" + campo + "\":");
        Scanner ler = new Scanner(System.in);
        String input = ler.nextLine();
        return input;
    }

    /*Método para encontrar qual o índice da linha na matriz de deputados que corresponde ao ID dado como parâmetro. Caso não encontrem, retorna -1*/
    public static int encontraDeputadoPorID(String id, String[][] deputados, int numDeputados) {
        int posicao = 0;
        while (!id.equalsIgnoreCase(deputados[posicao][0]) && posicao < SAVOP.NUMERO_DEPUTADOS) {
            posicao++;
        }
        if (posicao == (SAVOP.NUMERO_DEPUTADOS)) {
            return -1;
        } else {
            return posicao;
        }
    }

    /*Método auxiliar para obter, através da interação com o utilizador, qual a coluna onde efetuar alterações. Devolve -1 caso o utilizador escolha a opcão "terminar". Devolve "0" para ID, "1" para nome, "2" para partido e "3" para data de nascimento*/
    public static int obtemColunaAlterarDeputados() {
        int opcao;
        do {
            System.out.println("\n\nInsira opção, para o campo a alterar:"
                + "\n1 - ID"
                + "\n2 - Nome"
                + "\n3 - Partido"
                + "\n4 - Data Nascimento"
                + "\n"
                + "\n5 - Terminar");
            Scanner ler = new Scanner(System.in);
            while (!ler.hasNextInt()) {
                ler.nextLine();
                System.out.println("Opção inválida!");
            }
            opcao = ler.nextInt();
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

    /*Método auxiliar que devolve uma String referente ao nome do partido do
     * deputado com o ID enviado como parâmetro. Retorna uma String "-1", caso
     * não seja encontrado nenhum deputado com o ID enviado como parâmetro
     */
    public static String retornaPartidoPorID(String id, String[][] deputados, int numeroDeputados) {
        int linhaDoId = Utilitarios.encontraDeputadoPorID(id, deputados, numeroDeputados);
        if (linhaDoId == -1) {
            return "-1";
        }
        String partido = deputados[linhaDoId][2];
        return partido;
    }

    /*Método auxiliar que devolve um vetor de Strings com todos os partidos existentes na matriz de deputados*/
    public static String[] retornaVetorPartidos(String[][] deputados, int numeroDeputados) {
        String[] vazia = {};
        if (numeroDeputados <= 0) {
            return vazia;
        }
        String[] partidosAux = new String[numeroDeputados];
        for (int i = 1; i < numeroDeputados; i++) {
            partidosAux[i] = "vazio";
        }
        partidosAux[0] = deputados[0][2];
        int contadorPartidos = 1;
        for (int i = 1; i < numeroDeputados; i++) {
            boolean novoPartido = true;
            int j = 0;
            while (novoPartido == true && j < contadorPartidos) {
                if (deputados[i][2].equalsIgnoreCase(partidosAux[j])) {
                    novoPartido = false;
                }
                j++;
            }
            if (novoPartido) {
                partidosAux[contadorPartidos] = deputados[i][2];
                contadorPartidos++;
            }
        }
        String[] partidos = new String[contadorPartidos];
        System.arraycopy(partidosAux, 0, partidos, 0, contadorPartidos);
        return partidos;
    }

    public static int[][] criarMatrizVaziaResultadosVotacoes(String vetorPartidos) {
        int numeroPartidos = vetorPartidos.length();
        int[][] matriz = new int[numeroPartidos][4];
        for (int i = 0; i < numeroPartidos; i++) {
            matriz[i][0] = i;
        }
        for (int i = 0; i < numeroPartidos; i++) {
            for (int j = 1; j < 4; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }
    
    
}
