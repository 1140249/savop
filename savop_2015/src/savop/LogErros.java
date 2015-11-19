/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author RicardoMoreira(11402
 */
public class LogErros {

    public static File criaFicheiroErros() {
        String userDir = System.getProperty("user.home");
        String nomeFicheiro = userDir.concat("log_erros.txt");
        File logErros = new File(nomeFicheiro);
        return logErros;
    }

    public static void escreveNoFicheiroErros(File logErros, String mensagemErro) throws FileNotFoundException {
        String nomeFicheiro = logErros.getAbsolutePath();
        Formatter escrever = new Formatter(nomeFicheiro);
        escrever.format("%s", mensagemErro);
        escrever.close();
    }
}
