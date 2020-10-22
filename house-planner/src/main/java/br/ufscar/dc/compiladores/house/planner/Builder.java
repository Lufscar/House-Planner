/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Builder extends HPBaseVisitor {

    Out saida = new Out();
    Escopos escoposAninhados = new Escopos();
    boolean hasErros = false;

    Builder(Out saida) {
        this.saida = saida;
    }

    @Override
    public Double visitMap(HPParser.MapContext ctx) {
        double areaTotal = 0;
        for (var dec : ctx.declaration()) {
            visitDeclaration(dec);
        }
        for (HPParser.BodyContext bc : ctx.body()) {
            visitBody(bc);
        }

        return areaTotal;
    }

    @Override
    public Object visitBody(HPParser.BodyContext ctx) {

        for (var bc : ctx.build()) {
            visitBuild(bc);
        }
        if (!hasErros) {
            visitCmdBuildHouse(ctx.cmdBuildHouse());
        }

        return null;
    }

    @Override
    public Double visitDeclaration(HPParser.DeclarationContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        escopoAtual.inserir("Bedroom", "Bedroom", 0);
        escopoAtual.inserir("LivingRoom", "LivingRoom", 0);
        escopoAtual.inserir("Bathroom", "Bathroom", 0);
        escopoAtual.inserir("Kitchen", "Kitchen", 0);

        if (ctx.SET() != null) {
            if (ctx.USERTYPE() != null) {
                if (escopoAtual.verificar(ctx.USERTYPE().getText()) == null) {
                    escopoAtual.inserir(ctx.USERTYPE().getText(), ctx.USERTYPE().getText(), 0);
                } else {
                    Results("Erro semântico: " + ctx.USERTYPE().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    hasErros = true;
                }
            }
        } else if (ctx.DEFINE() != null) {
            if (ctx.CONSTANT() != null) {
                if (escopoAtual.verificar(ctx.CONSTANT().getText()) == null) {
                    if (ctx.NUMBER() != null) {
                        escopoAtual.inserir(ctx.CONSTANT().getText(), "NUMBER", Double.parseDouble(ctx.NUMBER().getText()));
                    }
                } else {
                    Results("Erro semântico: " + ctx.CONSTANT().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    hasErros = true;
                }
            }
        } else {
            if (ctx.IDENTIFIER() != null) {
                if (escopoAtual.verificar(ctx.IDENTIFIER().getText()) == null) {
                    if (escopoAtual.verificar(ctx.type().getText()) != null) {
                        if (ctx.NUMBER() != null) {
                            escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), Double.parseDouble(ctx.NUMBER().getText()));
                        } else {
                            escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), 0);
                        }
                    } else {
                        Results("Erro semântico: " + ctx.type().getText()
                                + " não foi declarada nesse escopo\n");
                        hasErros = true;
                    }
                } else {
                    Results("Erro semântico: " + ctx.IDENTIFIER().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    hasErros = true;
                }
            }
        }

        return null;
    }

    @Override
    public Double visitBuild(HPParser.BuildContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();

        if (ctx.cmdAddRoom() != null) {
            for (TerminalNode tn : ctx.cmdAddRoom().IDENTIFIER()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    hasErros = true;
                } else {
                    ntds.active = true;
                }
            }
        } else if (ctx.cmdSubRoom() != null) {
            for (TerminalNode tn : ctx.cmdSubRoom().IDENTIFIER()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    hasErros = true;
                } else {
                    ntds.active = false;
                }
            }
        } else if (ctx.cmdCreateAlert() != null) {
            for (TerminalNode tn : ctx.cmdCreateAlert().IDENTIFIER()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    hasErros = true;
                }
            }
            for (TerminalNode tn : ctx.cmdCreateAlert().CONSTANT()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    hasErros = true;
                }
            }
        } else if (ctx.cmdMeasureArea() != null) {
            if (ctx.cmdMeasureArea().IDENTIFIER() != null) {
                if (escopoAtual.verificar(ctx.cmdMeasureArea().IDENTIFIER().getText()) == null) {
                    Results("Erro semântico: " + ctx.cmdMeasureArea().IDENTIFIER().getText()
                            + " não foi declarada nesse escopo\n");
                    hasErros = true;
                }
            }
        }
        return null;
    }

    @Override
    public Double visitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx) {
        Tabela();
        double areaTotal = 0;
        boolean hasLiv = false;
        boolean hasBed = false;
        boolean hasBath = false;
        boolean hasKit = false;
        boolean hasCub = false;

        int bathCount = 0;
        double taxArea = 0;
        double tax = 0;
        double inssFinal = 0;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (TabelaDeSimbolos ts : escoposAninhados.percorrerEscoposAninhados()) {
            EntradaTabelaDeSimbolos max = ts.verificar("MAX");
            EntradaTabelaDeSimbolos cub = ts.verificar("CUB");
            for (var num : ts.valor()) {
                if (num.active) {
                    this.saida.println("<tr>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + num.tipo + "</td>");
                    this.saida.println("<td style=\"border: 1px solid black;\"><a href=\"#" + num.nome + "\" style=\"text-decoration: none; color: black\">" + num.nome.replaceAll("\"", "") + "</a></td>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + num.area + "</td>");
                    this.saida.println("</tr>");

                    if (num.tipo.equals("Garage") || num.tipo.equals("Garagem")
                            || num.tipo.equals("Balcony") || num.tipo.equals("Varanda")) {
                        taxArea += num.area / 2;
                        areaTotal += num.area;
                    } else {
                        taxArea += num.area;
                        areaTotal += num.area;
                    }
                    if (num.tipo.equals("LivingRoom") || num.tipo.equals("Sala")) {
                        hasLiv = true;
                    }
                    if (num.tipo.equals("Bedroom") || num.tipo.equals("Quarto")) {
                        hasBed = true;
                    }
                    if (num.tipo.equals("Kitchen") || num.tipo.equals("Cozinha")) {
                        hasKit = true;
                    }
                    if (num.tipo.equals("Bathroom") || num.tipo.equals("Banheiro")) {
                        hasBath = true;
                        bathCount++;
                    }
                }

            }
            if (max != null) {
                if (areaTotal > max.area) {
                    areaTotal = -areaTotal;
                }
            }
            if (cub == null) {
                String msg;
                msg = "CUB nao definido. Impossivel calcular imposto!\n";
                Results(msg);
            } else {
                hasCub = true;
                if (taxArea <= 100) {
                    tax = taxArea * cub.area * 0.04;
                } else {
                    if (taxArea <= 200) {
                        tax = 100 * cub.area * 0.04 + (taxArea - 100) * cub.area * 0.08;
                    } else if (taxArea <= 300) {
                        tax = 100 * cub.area * 0.04 + (taxArea - 100) * cub.area * 0.14;
                    } else {
                        tax = 100 * cub.area * 0.04 + (taxArea - 100) * cub.area * 0.2;
                    }
                }

            }
        }

        if (!hasLiv || !hasBed || !hasBath || !hasKit) {
            areaTotal = -9999;
        }
        String msg;
        if (areaTotal == -9999) {
            msg = "O imovel nao atende os requisitos minimos de comodos!\n";
            Results(msg);
        } else if (areaTotal < 0) {
            msg = "Area maior do que o maximo permitido!\n";
            Results(msg);
        } else {
            msg = "A casa tera " + df.format(areaTotal) + " metros quadrados.\n";
            Results(msg);
            if (hasCub) {
                inssFinal = tax * 0.368;
                msg = "Construcao tera custo adicional de " + df.format(inssFinal) + " em imposto.\n";
                Results(msg);
            }

        }

        return areaTotal;
    }

    public void Tabela(){
        this.saida.println("<html>");
        this.saida.println("<head>\n");
        this.saida.println("</head>\n");
        this.saida.println("<title> House Planner </title>");
        this.saida.println("<body>\n");
        this.saida.println("<center>\n");
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 70%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #E25822; color: white;\">");
        this.saida.println("<th style=\"border: 1px solid black;\">Tipo</th>");
        this.saida.println("<th style=\"border: 1px solid black;\">Nome</th>");
        this.saida.println("<th style=\"border: 1px solid black;\">Área</th>");
        this.saida.println("</tr>");
    }
    
    public void Results(String msg) {
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 70%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #8B0000; color: white;\">");
        this.saida.println("<th style=\"border: 1px solid black;\">" + msg + " </th>");
        this.saida.println("</tr>");
        this.saida.println("<tr>");
    }
}
