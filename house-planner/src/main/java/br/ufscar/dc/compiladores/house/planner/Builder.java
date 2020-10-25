/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Rafael Rodrigues Bordin
* Autor: Vinicius de Oliveira Peixoto
 */
package br.ufscar.dc.compiladores.house.planner;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.antlr.v4.runtime.tree.TerminalNode;

// Classe Visitor do programa
public class Builder extends HPBaseVisitor {
    
    Out saida = new Out();                      // Gera saída
    Escopos escoposAninhados = new Escopos();   // Escopo das variáveis
    boolean noError = true;                     // Checa se ouve 

    Builder(Out saida) {
        this.saida = saida;
    }

    @Override
    public Double visitMap(HPParser.MapContext ctx) {
        
        // Passa por todas as declarações
        for (var dec : ctx.declaration()) {
            visitDeclaration(dec);
        }
        
        // Passa por todos os conjutos de comandos
        for (HPParser.BodyContext bc : ctx.body()) {
            visitBody(bc);
        }

        return null;
    }

    @Override
    public Object visitBody(HPParser.BodyContext ctx) {
        
        // Passa por todos os comandos
        for (var bc : ctx.build()) {
            visitBuild(bc);
        }
        
        // Se não houve erros semânticos, tenta executar o comando de checagem e validação
        if (noError) {
            visitCmdBuildHouse(ctx.cmdBuildHouse());
        }

        return null;
    }

    @Override
    public Double visitDeclaration(HPParser.DeclarationContext ctx) {
        // É obtido o escopo do código
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        // Os tipos básicos são adicionados ao escopo
        escopoAtual.inserir("Bedroom", "Bedroom", 0);
        escopoAtual.inserir("LivingRoom", "LivingRoom", 0);
        escopoAtual.inserir("Bathroom", "Bathroom", 0);
        escopoAtual.inserir("Kitchen", "Kitchen", 0);
        
        // Começa a verificação de qual tipo de declaração é
        
        // Se contém a palavra reservada 'set' está declarando tipo
        if (ctx.SET() != null) {
            if (ctx.USERTYPE() != null) {
                // Verifica se o tipo proposto já existe. Caso sim, gerar erro
                if (escopoAtual.verificar(ctx.USERTYPE().getText()) == null) {
                    escopoAtual.inserir(ctx.USERTYPE().getText(), ctx.USERTYPE().getText(), 0);
                } else {
                    Results("Erro semântico: " + ctx.USERTYPE().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    noError = false;
                }
            }
            
        // Se contém a palavra reservada 'define' entá declarando constante
        } else if (ctx.DEFINE() != null) {
            if (ctx.CONSTANT() != null) {
                // Verifica se a constante proposta já existe. Caso sim, gerar erro
                if (escopoAtual.verificar(ctx.CONSTANT().getText()) == null) {
                    if (ctx.NUMBER() != null) {
                        escopoAtual.inserir(ctx.CONSTANT().getText(), "NUMBER", Double.parseDouble(ctx.NUMBER().getText()));
                    }
                } else {
                    Results("Erro semântico: " + ctx.CONSTANT().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    noError = false;
                }
            }
        
        // Se não foi nenhuma dessas, só pode ser declaração de variável
        } else {
            if (ctx.IDENTIFIER() != null) {
                // Verifica se a variável proposta já existe. Caso sim, gerar erro
                if (escopoAtual.verificar(ctx.IDENTIFIER().getText()) == null) {
                    // Verifica se o tipo proposto já existe. Caso não, gerar erro
                    if (escopoAtual.verificar(ctx.type().getText()) != null) {
                        // Se passar número, está declarando a área junto
                        if (ctx.NUMBER() != null) {
                            escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), Double.parseDouble(ctx.NUMBER().getText()));
                        } else {
                            escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), 0);
                        }
                    } else {
                        Results("Erro semântico: " + ctx.type().getText()
                                + " não foi declarada nesse escopo\n");
                        noError = false;
                    }
                } else {
                    Results("Erro semântico: " + ctx.IDENTIFIER().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    noError = false;
                }
            }
        }

        return null;
    }

    @Override
    public Double visitBuild(HPParser.BuildContext ctx) {
        // É obtido o escopo do código
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        // Começa a verificação de qual tipo de comando é
        
        // Caso seja addRoom
        if (ctx.cmdAddRoom() != null) {
            // Verifica todas as variáveis que foram passadas
            for (TerminalNode tn : ctx.cmdAddRoom().IDENTIFIER()) {
                // Procura as variáveis no escopo
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                // Se a variável não foi encontrada, então ela não foi declarada. Erro
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    noError = false;
                    
                // Se ela foi encontrada, ela se torna um cômodo ativo
                } else {
                    ntds.active = true;
                }
            }
            
        // Caso seja subRoom
        } else if (ctx.cmdSubRoom() != null) {
            // Verifica todas as variáveis que foram passadas
            for (TerminalNode tn : ctx.cmdSubRoom().IDENTIFIER()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                // Se a variável não foi encontrada, então ela não foi declarada. Erro
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    noError = false;
                    
                // Se ela foi encontrada, ela se torna um cômodo inativo
                } else {
                    ntds.active = false;
                }
            }
            
        // Caso seja createAlert
        } else if (ctx.cmdCreateAlert() != null) {
            // Strings e números não precisam de verificação
            
            // Verifica todas as variáveis que foram passadas
            for (TerminalNode tn : ctx.cmdCreateAlert().IDENTIFIER()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                // Se a variável não foi encontrada, então ela não foi declarada. Erro
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    noError = false;
                }
            }
            // Depois verifica todas as constantes que foram passadas
            for (TerminalNode tn : ctx.cmdCreateAlert().CONSTANT()) {
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                // Se a constante não foi encontrada, então ela não foi declarada. Erro
                if (ntds == null) {
                    Results("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    noError = false;
                }
            }
            
        // Caso seja measureArea
        } else if (ctx.cmdMeasureArea() != null) {
            // Verifica todas as variáveis que foram passadas
            if (ctx.cmdMeasureArea().IDENTIFIER() != null) {
                // Se a variável não foi encontrada, então ela não foi declarada. Erro
                if (escopoAtual.verificar(ctx.cmdMeasureArea().IDENTIFIER().getText()) == null) {
                    Results("Erro semântico: " + ctx.cmdMeasureArea().IDENTIFIER().getText()
                            + " não foi declarada nesse escopo\n");
                    noError = false;
                }
            }
        }
        return null;
    }

    @Override
    public Double visitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx) {
        // Construção da tabela HTML
        Tabela();
        
        // Variáveis de controle
        
        // Áreas e taxas
        double areaTotal = 0;
        double taxArea = 0;
        double tax = 0;
        double inssFinal = 0;
        boolean hasCub = false;
        
        // Verificação de cômodos
        boolean hasLiv = false;
        boolean hasBed = false;
        boolean hasBath = false;
        boolean hasKit = false;
        
        // Embora tenha sido dito que quantidade de banheiros afeta o resultado
        // não foram encontradas informações para suportar essa afirmação
        int bathCount = 0;
        
        // Formatação do modo de exibição forçando dois dígitos decimais
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        
        // Varrer todos os escopos (basicamente só existe 1 escopo
        for (TabelaDeSimbolos ts : escoposAninhados.percorrerEscoposAninhados()) {
            // Verificar se foi declarado a constante MAX, limitando a área
            EntradaTabelaDeSimbolos max = ts.verificar("MAX");
            // Verificar se foi declarado a constante CUB, para calculo do INSS
            EntradaTabelaDeSimbolos cub = ts.verificar("CUB");
            
            // Varrer todas as variáveis, constantes, tipos, etc
            for (var num : ts.valor()) {
                // Verifica se a variável é ativa, isto é, um cômodo que foi adicionado
                if (num.active) {
                    // Coloca no HTML
                    this.saida.println("<tr>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + num.tipo + "</td>");
                    this.saida.println("<td style=\"border: 1px solid black;\"><a href=\"#" + num.nome + "\" style=\"text-decoration: none; color: black\">" + num.nome.replaceAll("\"", "") + "</a></td>");
                    this.saida.println("<td style=\"border: 1px solid black;\">" + num.area + "</td>");
                    this.saida.println("</tr>");
                    
                    // Garagens e Sacadas possuem desconto no imposto
                    if (num.tipo.equals("Garage") || num.tipo.equals("Garagem")
                            || num.tipo.equals("Balcony") || num.tipo.equals("Varanda")) {
                        taxArea += num.area / 2;
                        areaTotal += num.area;
                    } else {
                        taxArea += num.area;
                        areaTotal += num.area;
                    }
                    
                    // Verificação dos tipos de cômodos
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
                        bathCount++;    // Caso ache utilidade, usar o número de banheiros
                    }
                }

            }
            
            // Verifica se há limite máximo de área
            if (max != null) {
                if (areaTotal > max.area) {
                    areaTotal = -areaTotal;
                }
            }
            
            // Verifica se há CUB definido, senão é impossível calcular os impostos
            if (cub == null) {
                Results("CUB nao definido. Impossivel calcular imposto!\n");
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
        
        // É obrigatório ter ao menos um cômodo básico
        if (!hasLiv || !hasBed || !hasBath || !hasKit) {
            areaTotal = -9999;
        }
        
        // Mensagens de aviso ao final dos cálculos
        String msg;
        if (areaTotal == -9999) {
            msg = "ATENÇÃO! O imovel ainda nao atende os requisitos minimos de comodos!\n";
            Results(msg);
        } else if (areaTotal < 0) {
            msg = "ATENÇÃO! Area maior do que o maximo permitido!\n";
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
    
    // Criando estrutura HTML
    public void Inicio() {
        this.saida.println("<html>");
        this.saida.println("<head>\n");
        this.saida.println("<font size=\"+2\" face=\"Verdana\">");
        this.saida.println("<title> House Planner Project </title>"); 
        this.saida.println("</font>");
        this.saida.println("</head>\n");
        this.saida.println("<body>\n");
        this.saida.println("<font face=\"Verdana\">");
        this.saida.println("<center>\n");
    }
    
    // Criando Tabela HTML
    public void Tabela() {
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 80%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #E25822; color: white;\">");
        this.saida.println("<th style=\"border: 2px solid black;\">Tipo</th>");
        this.saida.println("<th style=\"border: 2px solid black;\">Nome</th>");
        this.saida.println("<th style=\"border: 2px solid black;\">Área</th>");
        this.saida.println("</tr>");
    }

    // Adiciona texto no HTML
    public void Results(String msg) {
        this.saida.println("<table style=\"border-collapse: collapse; border: 1px solid black; text-align: center; width: 80%; table-layout: fixed\">");
        this.saida.println("<tr style=\"border: 1px solid black; background-color: #8B0000; color: white;\">");
        this.saida.println("<th style=\"border: 1px solid black;\">" + msg + " </th>");
        this.saida.println("</tr>");
    }
    
    // Fecha a estrutura HTML
    public void Final() {
        this.saida.println("</table>");
        this.saida.println("</center>");
        this.saida.println("</font>");
        this.saida.println("</body>");
        this.saida.println("</html>");
    }
}
