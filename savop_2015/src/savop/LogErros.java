/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author RicardoMoreira(11402
 */
public class LogErros {

    /**
     * @return Método auxiliar para criar um objeto do tipo File cujo caminho do
     * ficheiro é [home_utilizador]/log_erros.txt. Devolve esse objeto.
     * Diferencia as barras de endereçamento para Windows e outros sistemas
     * operativos.
     */
    public static File criaFicheiroErros() {
        
        /* código para colocar o ficheiro de log erros noutra localização qualquer que não a pasta src do programa. Aponta para a pasta home do utilizador. Código comentado devido ao objetivo ser colocar os ficheiros na src do programa*/
        /*        
        String userDir = System.getProperty("user.home");
        String sistemaOperativo = System.getProperty("os.name");
        String nomeFicheiro;
        if (sistemaOperativo.startsWith("Windows")) {
            nomeFicheiro = userDir.concat("\\log_erros.txt");
        } else {
            nomeFicheiro = userDir.concat("/log_erros.txt");
        }
        */
        File logErros = new File("LogErros.txt");
        return logErros;
    }

    public static String nomeSistemaOperativo () {
        return System.getProperty("os.name");
    }

    /**
     *
     * @param mensagemErro
     * @param escrever
     * @throws FileNotFoundException Método auxiliar para escrever no ficheiro
     * de erros dado como parâmetro a mensagem de erro dada como parâmetro.
     */
    public static void escreveNoFicheiroErros(String mensagemErro, Formatter escrever) throws FileNotFoundException {
        escrever.format("%n%s", mensagemErro);
    }
}
