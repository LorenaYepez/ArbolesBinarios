
public class Nodo {

    private Nodo hijoIzq;
    private int elem;
    private Nodo hijoDer;

    public Nodo(int x) {
        elem = x;
        hijoIzq = null;
        hijoDer = null;
    }
    public Nodo() {        
        hijoIzq = null;
        hijoDer = null;
    }

    public void setHI(Nodo hi) {
        hijoIzq = hi;
    }

    public void setHD(Nodo hd) {
        hijoDer = hd;
    }

    public void setElem(int x) {
        elem = x;
    }

    public Nodo getHI() {
        return hijoIzq;
    }

    public Nodo getHD() {
        return hijoDer;
    }

    public int getElem() {
        return elem;
    }
}//end class
