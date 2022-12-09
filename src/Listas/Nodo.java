package Listas;

public class Nodo {
    public String Valor;

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public Nodo Sig;

    public Nodo getSig() {
        return Sig;
    }

    public void setSig(Nodo sig) {
        Sig = sig;
    }

    public Nodo Ant;

    public Nodo getAnt() {
        return Ant;
    }

    public void setAnt(Nodo ant) {
        Ant = ant;
    }

    public Nodo()
    {
        Valor = null;
        Sig = null;
        Ant = null;
    }
}
