/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.house.planner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Vinicius Peixoto
 */
public class Builder extends HPBaseVisitor{
    FileWriter fw;
    Escopos escoposAninhados = new Escopos();
    
    Builder(FileWriter fw){
        this.fw = fw;
    }

    @Override
    public Double visitMap(HPParser.MapContext ctx) {
        double areaTotal = 0;
        for(var dec : ctx.declaration()){
            visitDeclaration(dec);
        }
        for(HPParser.BuildContext bc : ctx.build()){
            visitBuild(bc);
        }
        for(HPParser.CmdBuildHouseContext bh : ctx.cmdBuildHouse()){
            areaTotal += visitCmdBuildHouse(bh);
        }
        return areaTotal;
    }

    @Override
    public Double visitDeclaration(HPParser.DeclarationContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        escopoAtual.inserir("Bedroom", "Bedroom", 0);
        escopoAtual.inserir("LivingRoom", "LivingRoom", 0);
        escopoAtual.inserir("Bathroom", "Bathroom", 0);
        escopoAtual.inserir("Kitchen", "Kitchen", 0);
        
        try{
            if(ctx.SET() != null){
                if (ctx.USERTYPE() != null){
                    if(escopoAtual.verificar(ctx.USERTYPE().getText()) == null){
                        escopoAtual.inserir(ctx.USERTYPE().getText(), ctx.USERTYPE().getText(), 0);
                    }else{
                        fw.write("Erro semântico: " + ctx.USERTYPE().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    }
                }
            }else if (ctx.DEFINE() != null){
                if (ctx.CONSTANT() != null){
                    if(escopoAtual.verificar(ctx.CONSTANT().getText()) == null){
                        if (ctx.NUMBER() != null){
                            escopoAtual.inserir(ctx.CONSTANT().getText(), "NUMBER", Double.parseDouble(ctx.NUMBER().getText()));
                        }
                    }else{
                        fw.write("Erro semântico: " + ctx.CONSTANT().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    }
                }
            }else{
                if (ctx.IDENTIFIER() != null){
                    if(escopoAtual.verificar(ctx.IDENTIFIER().getText()) == null){
                        if(escopoAtual.verificar(ctx.type().getText()) != null){
                            if(ctx.NUMBER() != null){
                                escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), Double.parseDouble(ctx.NUMBER().getText()));
                            }else{
                                escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), 0);
                            }
                        }else{
                            fw.write("Erro semântico: " + ctx.type().getText()
                            + " não foi declarada nesse escopo\n");
                        }
                    }else{
                        fw.write("Erro semântico: " + ctx.IDENTIFIER().getText()
                            + " declarada duas vezes num mesmo escopo\n");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Double visitBuild(HPParser.BuildContext ctx) {
        double area = 0;
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        try{
            if(ctx.cmdAddRoom() != null){
                for(TerminalNode tn : ctx.cmdAddRoom().IDENTIFIER()){
                    EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                    if(ntds == null){
                        fw.write("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    }else{
                        ntds.active = true;
                    }
                }
            }else if(ctx.cmdSubRoom() != null){
                for(TerminalNode tn : ctx.cmdSubRoom().IDENTIFIER()){
                    EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                    if(ntds == null){
                        fw.write("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    }else{
                        ntds.active = false;
                    }
                }
            }else if(ctx.cmdCreateAlert() != null){
                for(TerminalNode tn : ctx.cmdCreateAlert().IDENTIFIER()){
                    EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                    if(ntds == null){
                        fw.write("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    }
                }
                for(TerminalNode tn : ctx.cmdCreateAlert().CONSTANT()){
                    EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                    if(ntds == null){
                        fw.write("Erro semântico: " + tn.getText()
                            + " não foi declarada nesse escopo\n");
                    }
                }
            }else if(ctx.cmdMeasureArea()!= null){
                if(ctx.cmdMeasureArea().IDENTIFIER() != null){
                    if(escopoAtual.verificar(ctx.cmdMeasureArea().IDENTIFIER().getText()) == null){
                        fw.write("Erro semântico: " + ctx.cmdMeasureArea().IDENTIFIER().getText()
                                + " não foi declarada nesse escopo\n");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Double visitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx) {
        double areaTotal = 0;
        boolean hasLiv = false;
        boolean hasBed = false;
        boolean hasBath = false;
        boolean hasKit = false;
        
        for(TabelaDeSimbolos ts : escoposAninhados.percorrerEscoposAninhados()){
            EntradaTabelaDeSimbolos max = ts.verificar("MAX");
            for(var num : ts.valor()){
                if(num.active){
                    System.out.println(num.nome + " : " + num.area);
                    areaTotal += num.area;
                }
                if(num.nome == "LivingRoom") hasLiv = true;
                if(num.nome == "Bedroom") hasBed = true;
                if(num.nome == "Bathroom") hasBath = true;
                if(num.nome == "Kitchen") hasKit = true;
            }
            if(max != null){
                if(areaTotal > max.area){
                    areaTotal = -areaTotal;
                }
            }
        }
        
        if(!hasLiv || !hasBed || !hasBath || !hasKit) areaTotal = -9999;
        
        return areaTotal;
    }
}
