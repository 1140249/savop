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

    public static File criaFicheiroErros() {
        String userDir = System.getProperty("user.home");
        String nomeFicheiro = userDir.concat("\\Desktop\\log_erros.txt");
        File logErros = new File(nomeFicheiro);
        return logErros;
    }

    public static void escreveNoFicheiroErros(String mensagemErro, Formatter escrever) throws FileNotFoundException {
        escrever.format("%n%s", mensagemErro);
    }
}
