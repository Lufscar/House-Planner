/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Vinicius de Oliveira Peixoto
*/

package br.ufscar.dc.compiladores.house.planner;

import java.util.Collection;
import java.util.HashMap;

public class TabelaDeSimbolos {
    private final HashMap<String, EntradaTabelaDeSimbolos> tabelaDeSimbolos;
    
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
