/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class Gerador extends HPBaseVisitor<String> {

    final Out saida;
    Escopos escoposAninhados = new Escopos();
    private final List<EntradaTabelaDeSimbolos> listaDeComodos;

    public Gerador(Out saida) {
        this.saida = saida;
        this.listaDeComodos = new ArrayList<>();
    }

    @Override
    public String visitMap(HPParser.MapContext ctx) {
        this.saida.println("<html>");

        this.saida.println("<head>\n");
        this.saida.println("</head>\n");

        this.saida.println("<title> House Planner </title>");

        this.saida.println("<body>\n");
        this.saida.println("<center>\n");

        ctx.declaration().forEach(dec -> visitDeclaration(dec));
        ctx.body().forEach(body -> visitBody(body));

        Room();

        return null;
    }

    public void Room() {
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 70%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #E25822; color: white;\">");
        this.saida.println("<th style=\"border: 1px solid black;\">Tipo</th>");
        this.saida.println("<th style=\"border: 1px solid black;\">Nome</th>");
        this.saida.println("<th style=\"border: 1px solid black;\">Área</th>");
        this.saida.println("</tr>");

        for (TabelaDeSimbolos ts : escoposAninhados.percorrerEscoposAninhados()) {
            for (var comodo : ts.valor()) {
                if (comodo.active) {
                    String tipo = comodo.tipo;
                    float area = (float) comodo.area;
                    String nome = comodo.nome;
                    this.saida.println("<tr>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + tipo + "</td>");
                    this.saida.println("<td style=\"border: 1px solid black;\"><a href=\"#" + nome + "\" style=\"text-decoration: none; color: black\">" + nome.replaceAll("\"", "") + "</a></td>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + area + "</td>");
                    this.saida.println("</tr>");
                }

            }
        }
        this.saida.println("</table>");
        this.saida.println("<br>");
    }

}
