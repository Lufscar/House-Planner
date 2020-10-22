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
    public static void main(String args[]) throws IOException{
        
        FileWriter outFile = new FileWriter(args[1]);
        
        CharStream cs = CharStreams.fromFileName(args[0]);
        HPLexer lex = new HPLexer(cs);
        Token t = null;
        while ((t = lex.nextToken()).getType() != Token.EOF){
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
            //outFile.write("<" + lex.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">\n");
        }
        
        if (lex.nextToken().getType() == Token.EOF) {
            lex.reset();
            CommonTokenStream tokens = new CommonTokenStream(lex);
            HPParser psr = new HPParser(tokens);
            MeuErrorListener error = new MeuErrorListener(outFile);
            psr.addErrorListener(error);
            HPParser.MapContext map = psr.map();
            
            Builder b = new Builder(outFile);
            double val = b.visitMap(map);
            if(val < 0){
                System.out.println("Area maior do que o maximo permitido!");
            }else{
                System.out.println("A casa tera " + val + " metros quadrados.");
            }
        }
        outFile.write("Fim da compilação!\n");
        outFile.close();
    }
}
