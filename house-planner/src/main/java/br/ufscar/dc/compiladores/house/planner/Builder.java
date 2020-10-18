/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.house.planner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Vinicius Peixoto
 */
public class Builder extends HPBaseVisitor{
    Escopos escoposAninhados = new Escopos();

    @Override
    public Double visitMap(HPParser.MapContext ctx) {
        double areaTotal = 0;
        for(var dec : ctx.declaration()){
            visitDeclaration(dec);
        }
        for(HPParser.BuildContext bc : ctx.build()){
            areaTotal += visitBuild(bc);
        }
        
        return areaTotal;
    }

    @Override
    public Double visitDeclaration(HPParser.DeclarationContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        if(ctx.SET() != null){
            if(escopoAtual.verificar(ctx.USERTYPE().getText()) == null){
                escopoAtual.inserir(ctx.USERTYPE().getText(), ctx.USERTYPE().getText(), 0);
            }else{
                throw new RuntimeException("Erro semântico: " + ctx.USERTYPE().getText()
                    + " declarada duas vezes num mesmo escopo");
            }            
        }else if (ctx.DEFINE() != null){
            if(escopoAtual.verificar(ctx.IDENTIFIER().getText()) == null){
                escopoAtual.inserir(ctx.IDENTIFIER().getText(), "NUMBER", Double.parseDouble(ctx.NUMBER().getText()));
            }else{
                throw new RuntimeException("Erro semântico: " + ctx.IDENTIFIER().getText()
                    + " declarada duas vezes num mesmo escopo");
            }
        }else{
            if(escopoAtual.verificar(ctx.IDENTIFIER().getText()) == null){
                escopoAtual.inserir(ctx.IDENTIFIER().getText(), ctx.type().getText(), 0);
            }else{
                throw new RuntimeException("Erro semântico: " + ctx.IDENTIFIER().getText()
                    + " declarada duas vezes num mesmo escopo");
            }
        }
        
        return null;
    }

    @Override
    public Double visitBuild(HPParser.BuildContext ctx) {
        double area = 0;
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        if(ctx.cmdAddRoom() != null){
            for(TerminalNode tn : ctx.cmdAddRoom().IDENTIFIER()){
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if(ntds == null){
                    throw new RuntimeException("Erro semântico: " + tn.getText()
                        + " não foi declarada nesse escopo");
                }else{
                    ntds.active = true;
                }
            }
        }else if(ctx.cmdSubRoom() != null){
            for(TerminalNode tn : ctx.cmdSubRoom().IDENTIFIER()){
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if(ntds == null){
                    throw new RuntimeException("Erro semântico: " + tn.getText()
                        + " não foi declarada nesse escopo");
                }else{
                    ntds.active = false;
                }
            }
        }else if(ctx.cmdCreateAlert() != null){
            for(TerminalNode tn : ctx.cmdCreateAlert().IDENTIFIER()){
                EntradaTabelaDeSimbolos ntds = escopoAtual.verificar(tn.getText());
                if(ntds == null){
                    throw new RuntimeException("Erro semântico: " + tn.getText()
                        + " não foi declarada nesse escopo");
                }
            }
        }else if(ctx.cmdImportArea()!= null){
            if(escopoAtual.verificar(ctx.cmdImportArea().IDENTIFIER().getText()) == null){
                throw new RuntimeException("Erro semântico: " + ctx.cmdImportArea().IDENTIFIER().getText()
                        + " não foi declarada nesse escopo");
            }else{
                escopoAtual.modificar(ctx.cmdImportArea().IDENTIFIER().getText(), true);
            }
        }
        
        area = visitCmdBuildHouse(ctx.cmdBuildHouse());
        
        return area;
    }

    @Override
    public Double visitCmdBuildHouse(HPParser.CmdBuildHouseContext ctx) {
        double areaTotal = 0;
        for(TabelaDeSimbolos ts : escoposAninhados.percorrerEscoposAninhados()){
            for(var num : ts.valor()){
                if(num.active){
                    areaTotal += num.area;
                }
                
            }
        }
        
        return areaTotal;
    }
}
