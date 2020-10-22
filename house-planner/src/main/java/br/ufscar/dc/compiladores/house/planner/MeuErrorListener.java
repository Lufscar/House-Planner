/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
*/
package br.ufscar.dc.compiladores.house.planner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/*
 * Classe para detecção de erros sintáticos
*/
public class MeuErrorListener extends BaseErrorListener {
    
    // O arquivo de saída é criado usando FileWriter.
    Out saida = new Out();
    boolean hasErros = false;
    
    //Inicialização
    MeuErrorListener(Out saida){
        this.saida = saida;
    }
    
    /*
     * syntaxError é o método de análise sintática criado em BaseErrorListener,
     * BaseErrorListener é uma classe do ANTLR para detecção de erros
     * aqui, fazemos uma sobreposição deste método (override)
    */
   @Override
        public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            
            /*
             * Tratamento de erro no token EOF
            */
            String[] str_token = offendingSymbol.toString().split("'");
            if(str_token[1].equals("<EOF>")){
                str_token[1] = "EOF";
            }
            
            //mensagem de erro sintático
            msg = "Erro Sintatico: Linha "+line+" - proximo a "+str_token[1];
            
        /*
         * escrita de msg no arquivo de saída
         */
        saida.println(msg+"\n");
            
            hasErros = true;
        }
    }
