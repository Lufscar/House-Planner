/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.house.planner;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Vinicius Peixoto
 */
public class TabelaDeSimbolos {
    private HashMap<String, EntradaTabelaDeSimbolos> tabelaDeSimbolos;
    
    public TabelaDeSimbolos(){
        tabelaDeSimbolos = new HashMap<>();
    }
    
    public void inserir(String nome, String tipo, double area){
        EntradaTabelaDeSimbolos etds = new EntradaTabelaDeSimbolos();
        etds.nome = nome;
        etds.tipo = tipo;
        etds.area = area;
        etds.active = false;
        tabelaDeSimbolos.put(nome, etds);
    }
    
    public EntradaTabelaDeSimbolos verificar(String nome){
        return tabelaDeSimbolos.get(nome);
    }
    
    public void modificar(String nome, boolean active){
        EntradaTabelaDeSimbolos etds = tabelaDeSimbolos.get(nome);
        etds.active = active;
        tabelaDeSimbolos.replace(nome, etds);
    }
    
    public Collection<EntradaTabelaDeSimbolos> valor(){
        return tabelaDeSimbolos.values();
    }
}
