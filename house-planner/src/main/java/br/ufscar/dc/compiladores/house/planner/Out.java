
package br.ufscar.dc.compiladores.house.planner;

class Out {
    StringBuffer cont; //content
    boolean mod; //modified

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

    public boolean ismod() {
        return mod;
    }

    @Override
    public String toString() {
        return cont.toString();
    }
}