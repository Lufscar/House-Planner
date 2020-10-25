/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Rafael Rodrigues Bordin
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/*
 * Classe para detecção de erros sintáticos
 */
public class MeuErrorListener extends BaseErrorListener {

    Out saida = new Out();
    boolean noError = true;
    Builder b = new Builder(saida);

    //Inicialização
    MeuErrorListener(Out saida) {
        this.saida = saida;
    }

    /*
     * syntaxError é o método de análise sintática criado em BaseErrorListener,
     * BaseErrorListener é uma classe do ANTLR para detecção de erros
     * aqui, fazemos uma sobreposição deste método (override)
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        //Tratamento de erro no token EOF
        String[] str_token = offendingSymbol.toString().split("'");
        if (str_token[1].equals("<EOF>")) {
            str_token[1] = "EOF";
        }

        //Mensagem de erro sintático
        msg = "Linha " + line + ": erro sintatico proximo a " + str_token[1];

        //Escrita de msg no arquivo de saída
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 80%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #8B0000; color: white;\">");
        this.saida.println("<th style=\"border: 1px solid black;\">" + msg + " </th>");
        this.saida.println("</tr>");
        
        noError = false;
    }
}
