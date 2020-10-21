/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Vinicius Peixoto
 */
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
            
            HPParser.MapContext map = psr.map();
            
            Builder b = new Builder();
            double val = b.visitMap(map);
            System.out.println("A casa tera " + val + " metros quadrados.");
        }
        outFile.close();
    }
}
