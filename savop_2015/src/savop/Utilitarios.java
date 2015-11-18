/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author RicardoMoreira(11402
 */
public class Utilitarios {

    public static void calculaIdade() {
    }

    ;
  public static void mostraDataHoje() {
    }

    ;
  public static void reduzNome() {
    }

    ;
  public static void ordenaMatrizColuna() {
    }

    ;
  
  /*valida o ID recebido como parâmetro. permite no futuro que se possam detalhar melhor o reporte do erro em questão dado guardar um vetor de boleanos que guarda qual a situação em que foi detetado o erro*/
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

    /*valida que o "id" recebido como parâmetro ainda não se encontra presente na listagem "deputados" enviada como parâmetro até à linha indicada como parâmetro na variável "maxProcura"*/
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

    /*Obtem o nome de um ficheiro selecionado pelo utilizador através de um objeto do tipo JFileChooser*/
    public static String selecionarFicheiro(JFileChooser fc) throws FileNotFoundException {
        fc.setDialogTitle("Selecione ficheiro para leitura");
        fc.showOpenDialog(fc);
        return fc.getSelectedFile().getAbsolutePath();
    }

    /*Retorna um vetor de Strings com o conteúdo de um ficheiro cujo nome é dado como parâmetro. O vetor tem tamanho máximo de 230 linhas mas terá o tamanho correspondente ao número de linhas não vazias que o ficheiro tiver e respetivo conteúdo*/
    public static String[] lerFicheiro(String ficheiro) throws FileNotFoundException {
        Scanner ler = new Scanner(new File(ficheiro));
        String conteudo[] = new String[230];
        int numeroLinhasCarregadas = 0;
        while (ler.hasNextLine() && numeroLinhasCarregadas <= 230) {
            if (!ler.nextLine().isEmpty()) {
                conteudo[numeroLinhasCarregadas] = ler.nextLine();
                numeroLinhasCarregadas++;
            }
        }
        ler.close();
        String[] retorno = new String[numeroLinhasCarregadas];
        System.arraycopy(conteudo, 0, retorno, 0, numeroLinhasCarregadas);
        return retorno;
    }

    /*Retorna um vetor de booleans contendo as posicões do ficheiro passado por parâmetro que têm conteúdo a false e as que estão vazias a true. É útil para, por exemplo, poder especificar em que linhas do ficheiro existem erros ou obter o número total de linhas de um ficheiro, através do método length aplicado ao vetor retornado*/
    public static boolean[] linhasVaziasFicheiro(String ficheiro) throws FileNotFoundException {
        Scanner ler1 = new Scanner(new File(ficheiro));
        int totalLinhas = 0;
        while (ler1.hasNextLine()) {
            totalLinhas++;
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
        totalLinhas++;
        return linhasVazias;
    }
}
