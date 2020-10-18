/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Planner {

    public static void main(String args[]) throws IOException {

        FileWriter outFile = new FileWriter(args[1]);

        CharStream cs = CharStreams.fromFileName(args[0]);
        HPLexer lex = new HPLexer(cs);
        Token t = null;
        while ((t = lex.nextToken()).getType() != Token.EOF) {
            if (lex.VOCABULARY.getDisplayName(t.getType()) == "ERRO_SIMB") {

                // Identifica o erro e para todo o processo
                outFile.write("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n");
                break;
            }
            if (lex.VOCABULARY.getDisplayName(t.getType()) == "ERRO_CAD") {

                // Identifica o erro e para todo o processo
                outFile.write("Linha " + t.getLine() + ": cadeia literal nao fechada\n");
                break;
            }
            outFile.write("<" + lex.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">\n");
        }
        if (lex.nextToken().getType() == Token.EOF) {
            //função reset() possibilita o uso repetido do mesmo token e viabiliza a análise sintática
            lex.reset();
            //Análise do tokens
            CommonTokenStream tokens = new CommonTokenStream(lex);
            //Conversão do token       

            HPParser psr = new HPParser(tokens);
            /*
                 * Análise Sintática e tratamento de erros
             */
            MeuErrorListener error = new MeuErrorListener(outFile);
            psr.addErrorListener(error);
            psr.map();
        }
        outFile.write("Fim da compilação!\n");

        outFile.close();
    }
}
