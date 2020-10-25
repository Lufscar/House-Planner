/*
* Autora: Luciana Oliveira de Souza Gomes
* Autor: Rafael Rodrigues Bordin
* Autor: Vinicius de Oliveira Peixoto
 */

package br.ufscar.dc.compiladores.house.planner;

class Out {
    StringBuffer cont;  //content
    boolean mod;        //modified

    public Out() {
        cont = new StringBuffer();
        mod = false;
    }

    public void println(String texto) {
        if (!mod) {
            mod = true;
        }
        cont.append(texto);
        cont.append("\n");
    }

    @Override
    public String toString() {
        return cont.toString();
    }
}
