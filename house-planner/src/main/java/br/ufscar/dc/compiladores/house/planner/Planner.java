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
        FileWriter outFile = new FileWriter(args[1]); //arquivo de saída de erros
        File out = new File(args[1]);
        Out saida = new Out();//buffer

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
        }

        /*
        Análise Sintática e Semântica
         */
        lex.reset();
        CommonTokenStream tokens = new CommonTokenStream(lex);
        HPParser psr = new HPParser(tokens);
        HPParser.MapContext map = psr.map();
        if (lex.nextToken().getType() == Token.EOF) {
            MeuErrorListener error = new MeuErrorListener(outFile);
            psr.addErrorListener(error);
            Builder b = new Builder(outFile);
            double val = b.visitMap(map);
        }
        outFile.close();

        /*
        Gerador de código html
         */
        if (!saida.ismod()) {
            Gerador ge = new Gerador(saida);
            ge.visitMap(map);
            try (PrintWriter generated = new PrintWriter(args[1])) {
                generated.print(ge.saida.toString());
                generated.flush();
                generated.close();
            }
        } else {
            saida.println("\n ---------- Reveja seu programa antes de gerar uma tabela :) ----------\n");
            System.out.print(saida);
        }

        /*
        Fim Gerador
         */
    }
}
