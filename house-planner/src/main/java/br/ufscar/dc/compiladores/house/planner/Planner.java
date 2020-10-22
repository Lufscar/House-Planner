/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class Planner {

    public static void main(String args[]) throws IOException {
        //FileWriter outFile = new FileWriter(args[1]); //arquivo de saída de erros
        Out saida = new Out();//buffer

        CharStream cs = CharStreams.fromFileName(args[0]);
        HPLexer lex = new HPLexer(cs);
        Token t = null;
        Builder b = new Builder(saida);
        while ((t = lex.nextToken()).getType() != Token.EOF) {
            if (lex.VOCABULARY.getDisplayName(t.getType()) == "ERRO_SIMB") {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- simbolo " + t.getText() + " nao identificado\n");
            }
            if (lex.VOCABULARY.getDisplayName(t.getType()) == "ERRO_CAD") {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- cadeia literal nao fechada\n");
            }
        }

        /*
        Análise Sintática e Semântica
         */
        if (lex.nextToken().getType() == Token.EOF && !saida.mod) {
            lex.reset();
            CommonTokenStream tokens = new CommonTokenStream(lex);
            HPParser psr = new HPParser(tokens);
            HPParser.MapContext map = psr.map();
            MeuErrorListener error = new MeuErrorListener(saida);
            psr.addErrorListener(error);
            double val = b.visitMap(map);
        }
        //outFile.close();

        
       //Gerador de código html
        try (PrintWriter generated = new PrintWriter(args[1])) {
            generated.print(saida.toString());
        }
        //Fim Gerador
         
    }
}
