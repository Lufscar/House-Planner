/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Rafael Rodrigues Bordin
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
        
        // Geração da saída
        Out saida = new Out();
        
        // Pega o código proveniente de um arquivo txt passado como argumento
        CharStream cs = CharStreams.fromFileName(args[0]);
        
        // Gera o analisador léxico usando o programa
        HPLexer lex = new HPLexer(cs);
        Token t = null;
        
        // Constrói o builder para geração dos códigos HTML
        Builder b = new Builder(saida);
        b.Inicio();
        
        // Começa a análise léxica
        while ((t = lex.nextToken()).getType() != Token.EOF) {
            // Verifica erro léxico de símbolo
            if ("ERRO_SIMB".equals(HPLexer.VOCABULARY.getDisplayName(t.getType()))) {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- simbolo " + t.getText() + " nao identificado\n");
                break;
            }
            // Verifica erro léxico de cadeia
            if ("ERRO_CAD".equals(HPLexer.VOCABULARY.getDisplayName(t.getType()))) {
                b.Results("Erro Lexico: Linha " + t.getLine() + "- cadeia literal nao fechada\n");
                break;
            }
            // Se qualquer erro léxico acontecer, a análise para no meio do caminho
        }

        //Análise Sintática e Semântica
        
        // Se a análise léxica foi interrompida antes de chegar no final, houve erro léxico,
        // então todo o resto é ignorado
        if (lex.nextToken().getType() == Token.EOF) {
            // Reiniciar os tokens para serem usados novamente na análise sintática
            lex.reset();
            CommonTokenStream tokens = new CommonTokenStream(lex);
            
            // Geração do parser
            HPParser psr = new HPParser(tokens);
            
            // Criação e adição do ErrorListener construído
            MeuErrorListener error = new MeuErrorListener(saida);
            psr.addErrorListener(error);
            
            // Análise sintática
            HPParser.MapContext map = psr.map();
            
            // Só prossegue para a nálise semântica se não ouve erro sintático
            if(error.noError){
                b.visitMap(map);
            }
        }

        //Gerador de código HTML
        b.Final();
        try (PrintWriter generated = new PrintWriter(args[1])) {
            generated.print(saida.toString());
        }

    }
}
