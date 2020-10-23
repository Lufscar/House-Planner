/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Planner {

    public static void main(String args[]) throws IOException {
        Out saida = new Out();
        CharStream cs = CharStreams.fromFileName(args[0]);
        HPLexer lex = new HPLexer(cs);
        Token t = null;
        Builder b = new Builder(saida);
        b.Inicio();
        while ((t = lex.nextToken()).getType() != Token.EOF) {
            if ("ERRO_SIMB".equals(HPLexer.VOCABULARY.getDisplayName(t.getType()))) {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- simbolo " + t.getText() + " nao identificado\n");
                break;
            }
            if ("ERRO_CAD".equals(HPLexer.VOCABULARY.getDisplayName(t.getType()))) {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- cadeia literal nao fechada\n");
                break;
            }
        }

        //Análise Sintática e Semântica
        if (lex.nextToken().getType() == Token.EOF) {
            lex.reset();
            CommonTokenStream tokens = new CommonTokenStream(lex);
            HPParser psr = new HPParser(tokens);
            HPParser.MapContext map = psr.map();
            MeuErrorListener error = new MeuErrorListener(saida);
            psr.addErrorListener(error);
            double val = b.visitMap(map);
        }

        //Gerador de código html
        b.Final();
        try (PrintWriter generated = new PrintWriter(args[1])) {
            generated.print(saida.toString());
        }

    }
}
