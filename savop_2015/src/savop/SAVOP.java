/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[][] deputados = new String[230][4];
        int numeroDeputados = 0;

        int opcao;

        do {
            System.out.println("Insira opção: ");
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    /*Ler ficheiro deputados e armazená-la na memória principal*/
                    numeroDeputados = lerParaMemoriaFicheiroDeputados(deputados, numeroDeputados);
                    break;
                case 2:
                    /*Visualizar ficheiro deputados existente em memória (depois de iniciada a opção 1) usando paginação*/
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
    public static int lerParaMemoriaFicheiroDeputados(String[][] deputados, int numeroDeputados) {
        String userDir = System.getProperty("user.home");
        JFileChooser fc = new JFileChooser(userDir);
        fc.setDialogTitle("Selecione ficheiro para leitura");
        fc.showOpenDialog(null);
        String nomeFicheiro = fc.getSelectedFile().getAbsolutePath();
        if (nomeFicheiro.endsWith(FILE_DEPUTADOS)) {
            Scanner lerFicheiro;
            try {
                lerFicheiro = new Scanner(new File(nomeFicheiro));
                while (lerFicheiro.hasNextLine() && numeroDeputados < MAX_DEPUTADOS) {
                    String conteudo = lerFicheiro.nextLine();
                    if (!conteudo.isEmpty()) {
                        numeroDeputados = guardarDadosDeputado(conteudo, deputados, numeroDeputados);
                    }
                }
                lerFicheiro.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SAVOP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Para leitura para a memória, o ficheiro selecionado tem de ter o nome \"Deputados.txt\".");
        }
        return numeroDeputados;

    }
    /*Método para passar os dados de uma linha presente no ficheiro de texto Deputados.txt para a matriz da memória principal "deputados". Para essa linha ser passada para a matriz, a mesma não pode ser vazia; tem de ter o número de colunas certas; na coluna do ID, o ID tem de ser válido (recorre-se ao método "validaID") e o ID dessa linha não pode já estar presente na matriz "deputados" (recorre-se ao método "validaIDUnico")*/

    /*TODO: corrigir a linha específica onde é detetado um erro. atualmente se um ficheiro tiver mais que uma linha errada, a mensagem de erro vai dar um número errado quanto ao número da linha do erro.*/
    private static int guardarDadosDeputado(String linha, String[][] deputados, int numeroDeputados) {
        String[] temp = linha.split(";");
        if (temp.length == 4) {
            String id = temp[0].trim();
            if (Utilitarios.validaID(id, COD_REGIOES)) {
                if (Utilitarios.validaIDUnico(id, deputados, numeroDeputados)) {
                    deputados[numeroDeputados][0] = id;
                    deputados[numeroDeputados][1] = temp[1].trim();
                    deputados[numeroDeputados][2] = temp[2].trim();
                    deputados[numeroDeputados][3] = temp[3].trim();
                    numeroDeputados++;
                    return numeroDeputados;
                } else {
                    System.out.println("A linha " + (numeroDeputados + 1) + " é uma linha inválida, dado o ID desta linha já existir para outro deputado registado previamente.");
                    return numeroDeputados;
                }
            } else {
                System.out.println("A linha " + (numeroDeputados + 1) + " é uma linha inválida, dado o ID ser inválido.");
                return numeroDeputados;
            }

        } else {
            System.out.println("A linha " + (numeroDeputados + 1) + " é uma linha inválida, dado não ter número de colunas suficientes.");
            return numeroDeputados;
        }
    }

    public static void mostraDeputadosPaginado(String[][] deputados, int numeroDeputados, int linhasPorPagina) {
        System.out.println("Total de páginas: " + devolveNumeroPaginas(deputados, numeroDeputados, linhasPorPagina));
        System.out.println("Total de resultados por página: " + linhasPorPagina);

        int[] iniciosPagina = devolveIniciosPagina(deputados, numeroDeputados, linhasPorPagina);
        
        int posicao = 0;
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Insira número de página pretendida");
    }

    public static int[] devolveIniciosPagina(String[][] deputados, int numeroDeputados, int linhasPorPagina) {
        int numeroPaginas = devolveNumeroPaginas(deputados, numeroDeputados, linhasPorPagina);
        int[] iniciosPagina = new int[numeroPaginas];
        int pagina = 0;
        for (int i = 0; i < numeroPaginas; i++) {
            iniciosPagina[i] = pagina;
            pagina += linhasPorPagina;
        }
        return iniciosPagina;
    }

    public static int devolveNumeroPaginas(String[][] deputados, int numeroDeputados, int linhasPorPagina) {
        int numeroPaginas = (numeroDeputados % linhasPorPagina) + 1;
        return numeroPaginas;
    }
}
