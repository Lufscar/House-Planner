package br.ufscar.dc.compiladores.house.planner;

import java.util.List;
import org.antlr.v4.runtime.Token;

public class Room {

    private String nome;
    private String tipo;
    private float area;
    
    public Room(float area, String nome, String tipo) {
        this.area = area;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
