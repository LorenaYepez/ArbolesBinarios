
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    private boolean esHoja(Nodo p) {
        return (p.getHI() == null && p.getHD() == null);
    }

    public void insertar(int x) {
        Nodo q = new Nodo(x);
        if (raiz == null) {
            raiz = q;
            return;
        }
        Nodo p = raiz;
        Nodo ap = null;
        while (p != null) {
            ap = p;
            if (x < p.getElem()) {
                p = p.getHI();
            } else if (x > p.getElem()) {
                p = p.getHD();
            } else {
                return;
            }
        }
        if (x < ap.getElem()) {
            ap.setHI(q);
        } else {
            ap.setHD(q);
        }
    }

    private void preOrden(Nodo p, JTextArea jta) {
        if (p != null) {
            jta.append(String.valueOf(p.getElem() + "  "));
            preOrden(p.getHI(), jta);
            preOrden(p.getHD(), jta);
        }
    }

    public void preOrden(JTextArea jta) {
        preOrden(raiz, jta);
    }

    private void inOrden(Nodo p, JTextArea jta) {
        if (p != null) {
            inOrden(p.getHI(), jta);
            jta.append(String.valueOf(p.getElem() + "  "));
            inOrden(p.getHD(), jta);
        }
    }

    public void inOrden(JTextArea jta) {
        inOrden(raiz, jta);
    }

    public int suma() {
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p)) {
            return p.getElem();
        }
        int ai = suma(p.getHI());
        int ad = suma(p.getHD());
        return ai + ad + p.getElem();
    }
    public int sumarElementos(){
        return sumarElementos(raiz);
    }
    
    private int sumarElementos(Nodo nodoActual){
        if (nodoActual == null) {
            return 0;
        }        
        return sumarElementos(nodoActual.getHI()) + sumarElementos(nodoActual.getHD())+nodoActual.getElem();
    }

    public int sumaPar() {
        return sumaPar(raiz);
    }

    private int sumaPar(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p) && (p.getElem() % 2 == 0)) {
            return p.getElem();
        }
        int si = sumaPar(p.getHI());
        int sd = sumaPar(p.getHD());
        if (p.getElem() % 2 == 0) {
            return si + sd + p.getElem();
        } else {
            return si + sd;
        }
    }
    public int sumarElementosPares(){
        return sumarElementosPares(raiz);
    }
    private int sumarElementosPares(Nodo nodoActual){
        if (nodoActual == null) {
            return 0;
        }
        int suma = 0;
        if ((nodoActual.getElem() % 2) == 0) {
            suma+=nodoActual.getElem();
        }
        return sumarElementosPares(nodoActual.getHI()) + 
                sumarElementosPares(nodoActual.getHD()) + suma;
    }
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p)) {
            return 1;
        }
        int ai = altura(p.getHI());
        int ad = altura(p.getHD());
        if (ai > ad) {
            return ai + 1;
        } else {
            return ad + 1;
        }
    }
    public int altura2(){
        return altura2(raiz);
    }
    
    private int altura2(Nodo nodoActual){
        if (nodoActual == null) {
            return 0;
        }
        if (esHoja(nodoActual)) {
            return 1;
        }
        return Math.max(altura2(nodoActual.getHI()), altura(nodoActual.getHD())) + 1;
    }

    public int cantNodos() {
        return cantNodos(raiz);
    }

    private int cantNodos(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p)) {
            return 1;
        }
        int ni = cantNodos(p.getHI());
        int nd = cantNodos(p.getHD());
        return ni + nd + 1;
    }
    public int cantidadElementos(){
        return cantidadElementos(raiz);
    }
    
    private int cantidadElementos(Nodo nodoActual){
        if (nodoActual == null) {
            return 0;
        }
        if (esHoja(nodoActual)) {
            return 1;
        }
        return cantidadElementos(nodoActual.getHI()) + 
                cantidadElementos(nodoActual.getHD()) + 1;
    }

    public int cantNodosIncompletos() {
        return cantNodosIncompletos(raiz);
    }

    private int cantNodosIncompletos(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p)) {
            return 0;
        }
        int cni = cantNodosIncompletos(p.getHI());
        int cnd = cantNodosIncompletos(p.getHD());
        if (p.getHI() == null || p.getHD() == null) {
            return cni + cnd + 1;
        } else {
            return cni + cnd;
        }
    }

    public int cantHijosIzqoDer() {
        return cantNodosIzqoDer(raiz);
    }

    public int cantNodosIzqoDer(Nodo p) {
        if (p == null || esHoja(p)) {
            return 0;
        }
        int ci = cantNodosIzqoDer(p.getHI());
        if (p.getHI() != null || p.getHD() != null) {
            return ci + 1;
        } else {
            return ci;
        }
    }

    public boolean arbolLleno() {
        return arbolLleno(raiz);
    }

    private boolean arbolLleno(Nodo p) {
        if (p == null) {
            return false;
        }
        return ((int) Math.pow(2, altura(p)) - 1 == cantNodos(p));
    }

    public int cantHojas() {
        return cantHojas(raiz);
    }

    private int cantHojas(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (esHoja(p)) {
            return 1;
        }
        int ci = cantHojas(p.getHI());
        int cd = cantHojas(p.getHD());
        return ci + cd;
    }

    public int cantPadres() {
        return cantPadres(raiz);
    }

    private int cantPadres(Nodo p) {
        if (p == null) {
            return 0;
        }
        int cpi = cantPadres(p.getHI());
        int cpd = cantPadres(p.getHD());
        if (p.getHI() != null || p.getHD() != null) {
            return cpi + cpd + 1;
        } else {
            return cpi + cpd;
        }
    }

    public void mostrarPares(JTextArea jta) {
        mostrarPares(raiz, jta);
    }

    private void mostrarPares(Nodo p, JTextArea jta) {
        if (p == null) {
            return;
        }
//        if (esHoja(p)) {
//            if (p.getElem() % 2 == 0) {
//                jta.append(String.valueOf(p.getElem() + "  "));
//            }
//        }

        mostrarPares(p.getHI(), jta);
        mostrarPares(p.getHD(), jta);
        if (p.getElem() % 2 == 0) {
            jta.append(String.valueOf(p.getElem() + "  "));
        }
    }

    public String mostrarPares2() {
        return mostrarPares2(raiz, "");
    }

    private String mostrarPares2(Nodo p, String s) {
        if (p == null) {
            return "";
        }
//        if (esHoja(p)&&p.getElem()%2==0)
//            return p.getElem()+", ";
        String mpi = mostrarPares2(p.getHI(), s);
        String mpd = mostrarPares2(p.getHD(), s);
        if (p.getElem() % 2 == 0) {
            return mpi + mpd + p.getElem() + ", ";
        } else {
            return mpi + mpd;
        }
    }

    public void mostrarPadres(JTextArea jta) {
        mostrarPadres(raiz, jta);
    }

    private void mostrarPadres(Nodo p, JTextArea jta) {
        if (p == null) {
            return;
        }

        mostrarPadres(p.getHI(), jta);
        mostrarPadres(p.getHD(), jta);
        if (p.getHI() != null || p.getHD() != null) {
            jta.append(String.valueOf(p.getElem() + "  "));
        }
    }
    public void mostrarPadres2(JTextArea jta){
        mostrarPadres2(raiz,jta);
    }
    
    private void mostrarPadres2(Nodo nodoActual,JTextArea jta){
        if (nodoActual == null) {
            return;
        }        
        if (esHoja(nodoActual)) {
            return;
        }        
        mostrarPadres2(nodoActual.getHI(),jta);
        jta.append(String.valueOf(nodoActual.getElem()) + " ");
        mostrarPadres2(nodoActual.getHD(),jta);
    }
    public boolean existe(int x) {
        return existe(raiz, x);
    }

    private boolean existe(Nodo p, int x) {
        if (p == null) {
            return false;
        }
        if (esHoja(p) && p.getElem() == x) {
            return true;
        }
        boolean ei = existe(p.getHI(), x);
        boolean ed = existe(p.getHI(), x);
        if (ei == true || ed == true) {
            return true;
        } else {
            return false;
        }
    }
    

    public boolean existe2(int x) {
        return existe2(raiz, x);
    }

    private boolean existe2(Nodo p, int x) {
        if (p == null) {
            return false;
        }
        if (esHoja(p)) {
            return p.getElem() == x;
        } else if (p.getElem() == x) {
            return true;
        } else if (x < p.getElem()) {
            return existe(p.getHI(), x);
        } else {
            return existe(p.getHD(), x);
        }
    }
    public boolean existe3(int elemento){
        return existe3(raiz,elemento);
    }
    
    private boolean existe3(Nodo nodo,int elemento){
        if (nodo == null) {
            return false;
        }
        if (elemento < nodo.getElem()) {
            return existe3(nodo.getHI(),elemento);
        }else if(elemento > nodo.getElem()){
            return existe3(nodo.getHD(),elemento);
        }
        return true;
    }

    public boolean hermano(int x, int y) {
        return hermano(raiz, x, y);
    }
    private boolean hermano(Nodo p, int x, int y) {
        if (p == null) {
            return false;
        } else if (esHoja(p)) {
            return false;
        } else {
            if (hermano(p.getHI(), x, y)) {
                return true;
            }
            if (hermano(p.getHD(), x, y)) {
                return true;
            } else {
                if (p.getHI().getElem() == x && p.getHD().getElem() == y || p.getHI().getElem() == y && p.getHD().getElem() == x) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }//end brother

    public boolean hermano2(int x,int y){
        return hermano2(raiz, x, y);
    }
    private boolean hermano2(Nodo p, int x, int y){
        if (p==null||esHoja(p))
            return false;
        if (p.getHI()!=null&&p.getHD()!=null){
            hermano2(p.getHI(), x, y);
            hermano2(p.getHD(), x, y); 
            if (p.getHI().getElem()==x&&p.getHD().getElem()==y||p.getHI().getElem()==y&&p.getHD().getElem()==x)
                return true;
            else
                return hermano2(p.getHI(), x, y)&&hermano2(p.getHD(), x, y);
        }            
        return false;
    }
    private boolean esNodoCompleto(Nodo nodoActual){
        return nodoActual.getHI() != null && nodoActual.getHD() != null;
    }
    public boolean sonHermanos(int x,int y){
        return sonHermanos(raiz,x,y);
    }
    private boolean sonHermanos(Nodo nodoActual,int x,int y){
        if (nodoActual == null)
            return false;
        else
        if (esHoja(nodoActual))
            return false;
        else
        {

                if (sonHermanos(nodoActual.getHI(),x, y))
                    return true;        
                if (sonHermanos(nodoActual.getHD(), x, y))
                    return true;
                else{        
                    //if (nodoActual.getHijoIzq() != null && nodoActual.getHijoDer() != null) {
                    if(esNodoCompleto(nodoActual)){
                        
                        if ((nodoActual.getHI().getElem() == x && nodoActual.getHD().getElem() == y || 
                        nodoActual.getHI().getElem() == y && nodoActual.getHD().getElem() == x))
                            return true;
                        else
                            return false;
                        
                    }else{
                        return false;
                    }                            
                }
            }
    }
    public boolean sonHermanos2(int x,int y){
        return sonHermanos2(raiz,x,y);
    }
    
    private boolean sonHermanos2(Nodo nodoActual,int x,int y){
        if (nodoActual == null || esHoja(nodoActual)) {
            return false;
        }
        if (esNodoCompleto(nodoActual)) {
            if ((nodoActual.getHI().getElem() == x && nodoActual.getHD().getElem() == y || 
                nodoActual.getHI().getElem() == y && nodoActual.getHD().getElem() == x))
                return true;
        }
        return sonHermanos2(nodoActual.getHI(), x, y) || sonHermanos2(nodoActual.getHD(), x, y);
    }
    public void MostrarNietos(int x,JTextArea jta){
        MostrarNietos(raiz, x, jta);
    }
    private void MostrarNietos(Nodo p,int x,JTextArea jta){
        if (p==null)                            
            return;        
        MostrarNietos(p.getHI(), x, jta);
        MostrarNietos(p.getHD(), x, jta);
        if (p.getElem()==x){
            if (altura(p)>2){
                if (p.getHI()!=null&&p.getHI().getHI()!=null)
                    jta.append(String.valueOf(p.getHI().getHI().getElem()+", "));
                if (p.getHI()!=null&&p.getHI().getHD()!=null)
                    jta.append(String.valueOf(p.getHI().getHD().getElem()+", "));
                if (p.getHD()!=null&&p.getHD().getHI()!=null)
                    jta.append(String.valueOf(p.getHD().getHI().getElem()+", "));
                if (p.getHD()!=null&&p.getHD().getHD()!=null)
                    jta.append(String.valueOf(p.getHD().getHD().getElem()+", "));                
            }else{
                jta.append(String.valueOf("No hay nietos"));
            }
        }                                
    }
    public boolean ArbolesIguales(Arbol a,Arbol b){        
        return ArbolesIguales(a.raiz,b.raiz);
    }
    private boolean ArbolesIguales(Nodo a, Nodo b){
        if (a==null&&b==null)
            return true;
        if (a==null&&b!=null||a!=null&&b==null)
            return false;        
        if (a!=null&&b!=null){
            if (a.getElem()!=b.getElem())
                return false;
            else
//                return ArbolesIguales(a.getHI(), b.getHI())&&ArbolesIguales(a.getHD(), b.getHD());
                if (ArbolesIguales(a.getHI(), b.getHI())&&ArbolesIguales(a.getHD(), b.getHD()))
                    return true;            
        }   
        return false;
    }
    public boolean sonIguales(Arbol otroArbol){
        return sonIguales(this.raiz,otroArbol.raiz);
    }
    
    private boolean sonIguales(Nodo x,Nodo y){
        if (x == null && y == null) return true;
        
        if (x == null && y != null) return false;
        
        if (x != null && y == null) return false;        
        
        if (x.getHI() != null && y.getHI() == null) return false;
        
        if (x.getHI() == null && y.getHI() != null) return false;        
        
        if (x.getElem() != y.getElem()) return false;        
        
        if (sonIguales(x.getHI(), y.getHI()) && sonIguales(x.getHD(), y.getHD())) return true;
        
        return false;
    }
    public void mostrarDescendientes(JTextArea jta,int x){
        mostrarDescendientes(raiz,x,jta);
    }
    
    private void mostrarDescendientes(Nodo nodoActual,int x,JTextArea jta){
        if (nodoActual == null) {
            return;
        }
        if (nodoActual.getElem() == x) {
            preOrden(nodoActual, jta);
        }
        mostrarDescendientes(nodoActual.getHI(), x, jta);
        mostrarDescendientes(nodoActual.getHD(), x, jta);
    }
    public void mostrarHermanoDeX(JTextArea jta,int x)throws Exception{
        mostrarHemanoDeX(raiz,x,jta);
    }
    
    
    private void mostrarHemanoDeX(Nodo nodoActual,int x,JTextArea jta) throws Exception{
        if (nodoActual == null || esHoja(nodoActual))  {
            throw new Exception();
        }
        if (nodoActual.getHI() != null && nodoActual.getHD() != null) {
            if (nodoActual.getHI().getElem() == x) {
                jta.append(nodoActual.getHD().getElem() + " ");
                return;
            }
        }
        if (nodoActual.getHI() != null && nodoActual.getHD() != null) {
            if (nodoActual.getHD().getElem() == x) {
                jta.append(nodoActual.getHI().getElem() + " ");
                return;
            }
        }
        mostrarHemanoDeX(nodoActual.getHI(), x, jta);
        mostrarHemanoDeX(nodoActual.getHD(), x, jta);
    }
    public void mostrarHermanoDeXx(int x){        
        Nodo nodo = mostrarHemanoDeXx(raiz, x);
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No tiene hermano");
        }else{
            JOptionPane.showMessageDialog(null, "El hermano es: " + nodo.getElem());
        }
    }
    
    
    private Nodo mostrarHemanoDeXx(Nodo nodoActual,int x){
        if (nodoActual == null || esHoja(nodoActual))  {
            return null;
        }                                
        if (nodoActual.getHI() != null) {
            if (nodoActual.getHI().getElem() == x) {
                return nodoActual.getHD();
            }
        }
        if (nodoActual.getHD() != null) {
            if (nodoActual.getHD().getElem() == x) {
                return nodoActual.getHI();
            }
        }
        Nodo hi = mostrarHemanoDeXx(nodoActual.getHI(),x);
        Nodo hd = mostrarHemanoDeXx(nodoActual.getHD(),x);
        if (hi !=null) {
            return hi;
        }else{
            return hd;
        }
    }
    public boolean primo(int x){
        return primo(x, 2);        
    }
    private boolean primo(int num, int div){
        if (num<2)
            return true;
        if (num%div==0&&num!=2)
            return false;
        if (div>num/2)
            return true;
        else
            return primo(num, div+1);        
    }
    
    public boolean arbolPrimos(){
        return arbolPrimos(raiz);
    }
    private boolean arbolPrimos(Nodo p){
        if (p==null)
            return true;
        if (esHoja(p)&&primo(p.getElem()))
            return true;
        arbolPrimos(p.getHI());
        arbolPrimos(p.getHD());
        if (!primo(p.getElem()))
            return false;
        else
            return arbolPrimos(p.getHI())&&arbolPrimos(p.getHD());
        
    }
    public void podarArbol(){
        podarArbol(raiz);
    }
    private Nodo podarArbol(Nodo p){
        if (p==null)
            return null;        
        if (esHoja(p))
            return null;                        
        p.setHI(podarArbol(p.getHI()));
        p.setHD(podarArbol(p.getHD()));
        return p;
    }
    public boolean esPadre(int x, int y){
        return esPadre(raiz, x, y);
    }
    private boolean esPadre(Nodo p, int x, int y){
        if (p==null)
            return false;
        if (p.getElem()==x&&p.getHI()!=null&&p.getHI().getElem()==y)
            return true;
        if (p.getElem()==x&&p.getHD()!=null&&p.getHD().getElem()==y)
            return true;
        boolean si=esPadre(p.getHI(), x, y);
        boolean sd=esPadre(p.getHD(), x, y);                    
        return si||sd;
    }
    public boolean esPadre2(int padre,int hijo){
        return esPadre2(raiz,padre,hijo);
    }
    
    private boolean esPadre2(Nodo nodoActual,int padre,int hijo){
        if (nodoActual == null || esHoja(nodoActual)) {
            return false;
        }
        if (nodoActual.getElem() == padre) {
            if (nodoActual.getHI() != null) {
                if (nodoActual.getHI().getElem() == hijo)
                    return true;
                }
            if (nodoActual.getHD() != null) {
                if (nodoActual.getHD().getElem() == hijo) {
                    return true;
                }
            }
        }       
        return esPadre2(nodoActual.getHI(), padre, hijo) || esPadre2(nodoActual.getHD(), padre, hijo);
    }
    public boolean esTio(int tio,int sobrino){
        return esTio(raiz,tio,sobrino);
    }
    private boolean esTio(Nodo nodoActual,int tio,int sobrino){
        if (nodoActual == null || esHoja(nodoActual)) {
            return false;
        }
        
        if (sonHermanos(nodoActual.getElem(), tio)) {                        
            if (esPadre2(nodoActual.getElem(), sobrino)) {
                return true;
            }
        }
        return esTio(nodoActual.getHI(), tio, sobrino) || esTio(nodoActual.getHD(), tio, sobrino);
    }
    public boolean esSobrino(int sobrino,int tio){
        return esSobrino(raiz,sobrino,tio);
    }
    
    private boolean esSobrino(Nodo nodoActual,int sobrino,int tio){
        if (nodoActual == null) {
            return false;
        }
        if (esTio(tio, sobrino)) {
            return true;
        }
        return esSobrino(nodoActual.getHI(),sobrino,tio) || esSobrino(nodoActual.getHD(),sobrino,tio);
    }
    public boolean esAbuelo(int abuelo,int nieto){
        return esAbuelo(raiz,abuelo,nieto);
    }
    private boolean esAbuelo(Nodo nodoActual,int abuelo,int nieto){
        if (nodoActual == null || esHoja(nodoActual)) {
            return false;
        }
        if (nodoActual.getElem() == abuelo) {
            if (nodoActual.getHI() != null) {
                if (esPadre( nodoActual.getHI().getElem(), nieto)) {
                    return true;
                }
            }
            if (nodoActual.getHD() != null) {
                if (esPadre( nodoActual.getHD().getElem(), nieto)) {
                    return true;
                }
            }            
        }        
        return esAbuelo(nodoActual.getHI(), abuelo, nieto) || esAbuelo(nodoActual.getHD(), abuelo, nieto);
    }
    public boolean sonPrimosHermanos(int x,int y){
        return sonPrimosHermanos(raiz, x,y);
    }
    private boolean sonPrimosHermanos(Nodo nodoActual,int x,int y){
        if (nodoActual == null) {
            return false;
        }        
        if (esAbuelo(nodoActual.getElem(), x) && esAbuelo(nodoActual.getElem(), y)) {
            return true;
        }
        return sonPrimosHermanos(nodoActual.getHI(), x, y) || sonPrimosHermanos(nodoActual.getHD(), x, y);
    }
    public int cantNodosDeAltura(int h){
        return cantNodosDeAltura(raiz, h, 0);
    }
    private int cantNodosDeAltura(Nodo p, int h, int c){ //ERROR
        if (p==null)
            return 0;  
        if (esHoja(p)&&h==1)
            return 1;                
        int cai=cantNodosDeAltura(p.getHI(),h,c);
        int cad=cantNodosDeAltura(p.getHD(),h,c);   
        if (c<=h)
            return cai+cad+1;
        else{
            c++;
            return cai+cad;
        }
            

    }
    
    public void mostrarDescendientes2(int x, JTextArea jta){
        Nodo p=raiz;
        Nodo ap=null;
        if (p==null)
            return ;
        while(p!=null){
            ap=p;
            if (x>p.getElem())
                p=p.getHD();
            else
                if(x<p.getElem())
                    p=p.getHI();
                else
                    p=null;
            preOrden(ap, jta);
        }
    }
    public void mostrarHermano(int x, JTextArea jta){
        mostrarHermano(raiz, x, jta);
    }
    private void mostrarHermano(Nodo p, int x, JTextArea jta){
        if (p==null)
            return ;
        if (esHoja(p))
            return ;
        mostrarHermano(p.getHI(), x, jta);
        mostrarHermano(p.getHD(), x, jta);        
        if (altura(p)>1){
            if (p.getHI().getElem()==x)
                jta.append(String.valueOf(p.getHD().getElem()+", "));
            if (p.getHD().getElem()==x)
                jta.append(String.valueOf(p.getHI().getElem()+", "));                            
        }else
            jta.append(String.valueOf("No hay Hermanos"));        
    }
    public void mostrarHermano2(int x){
        Nodo p=mostrarHermano2(raiz,x);
        if (p==null)
            JOptionPane.showMessageDialog(null, "No tiene hermano");
        else
            JOptionPane.showMessageDialog(null, String.valueOf(p.getElem()));
    }
    private Nodo mostrarHermano2(Nodo p, int x){//cuando devuelve un nodo se hace con NODO
        if (p==null||esHoja(p))
            return null;        
        if (p.getHI().getElem()==x)//p.gethi!=null
            return p.getHD();
        if (p.getHD().getElem()==x)//p.gethd!=null
            return p.getHI();
        Nodo ni=mostrarHermano2(p.getHI(), x);
        Nodo nd=mostrarHermano2(p.getHD(), x);        
        if (ni!=null)
            return ni;
        else
            return nd;
    }
    public void mostrarAbuelo(int x, JTextArea jta){
        mostrarAbuelo(raiz, x, jta);
    }
    private void mostrarAbuelo(Nodo p, int x,JTextArea jta){
        if (p==null)
            return ;
        mostrarAbuelo(p.getHI(), x,jta);
        mostrarAbuelo(p.getHD(), x,jta);
        if (altura(p)>2){
            if ((p.getHI()!=null&&p.getHI().getHI()!=null&&p.getHI().getHI().getElem()==x)||
                (p.getHI()!=null&&p.getHI().getHD()!=null&&p.getHI().getHD().getElem()==x)||
                (p.getHD()!=null&&p.getHD().getHI()!=null&&p.getHD().getHI().getElem()==x)||
                (p.getHD()!=null&&p.getHD().getHD()!=null&&p.getHD().getHD().getElem()==x))
                jta.append(String.valueOf("Padre: "+p.getElem()));            
        }else{
            jta.append(String.valueOf("No hay abuelo"));            
        }        
    }
    public void mostrarAbuelo(JTextArea jta,int x)throws Exception{
        mostrarAbuelo(raiz,jta,x);
    }
    
    public void mostrarAbuelo(Nodo nodoActual,JTextArea jta,int x)throws Exception{
        if (nodoActual == null || esHoja(nodoActual)) {
            return;
        }       
            if (nodoActual.getHI() != null) {
                if (nodoActual.getHI().getHI() != null) {
                    if (nodoActual.getHI().getHI().getElem() == x) {
                        jta.append(nodoActual.getElem() + " ");
                        return;
                    }
                }
                if (nodoActual.getHI().getHD() != null) {
                    if (nodoActual.getHI().getHD().getElem() == x) {
                        jta.append(nodoActual.getElem() + " ");
                        return;
                    }
                }
            }
            if (nodoActual.getHD() != null) {
                if (nodoActual.getHD().getHI() != null) {
                    if (nodoActual.getHD().getHI().getElem()== x) {
                        jta.append(nodoActual.getElem() + " ");
                        return;
                    }
                }
                if (nodoActual.getHD().getHD() != null) {
                    if (nodoActual.getHD().getHD().getElem() == x) {
                        jta.append(nodoActual.getElem() + " ");
                        return;
                    }
                }
            }
        mostrarAbuelo(nodoActual.getHI(), jta, x);
        mostrarAbuelo(nodoActual.getHD(), jta, x);
    }
    public void mostrarAbuelo2(int x){
        Nodo p=mostrarAbuelo2(raiz,x);
        if (p==null)
            JOptionPane.showMessageDialog(null, "No tiene abuelo");
        else
            JOptionPane.showMessageDialog(null, String.valueOf(p.getElem()));
    }
    private Nodo mostrarAbuelo2(Nodo p, int x){//cuando devuelve un nodo se hace con NODO
        if (p==null||esHoja(p))
            return null;        
        if (p.getHI()!=null&&p.getHI().getHI()!=null&&p.getHI().getHI().getElem()==x)//p.gethi!=null
            return p;
        if (p.getHI()!=null&&p.getHI().getHD()!=null&&p.getHI().getHD().getElem()==x)//p.gethi!=null
            return p;
        if (p.getHD()!=null&&p.getHD().getHI()!=null&&p.getHD().getHI().getElem()==x)//p.gethi!=null
            return p;
        if (p.getHD()!=null&&p.getHD().getHD()!=null&&p.getHD().getHD().getElem()==x)//p.gethd!=null
            return p;
        Nodo ni=mostrarAbuelo2(p.getHI(), x);
        Nodo nd=mostrarAbuelo2(p.getHD(), x);        
        if (ni!=null)
            return ni;
        else
            return nd;
    }
    public boolean esPadre(Nodo nodo){
        if (nodo == null) {
            return false;
        }
        if (nodo.getHI() != null || nodo.getHD() != null) {
            return true;
        }
        return false;
    }
    public boolean esAbuelo(Nodo nodo){
        if (nodo == null || esHoja(nodo)) {
            return false;
        }
        if (esPadre(nodo.getHI()) || esPadre(nodo.getHD())) {
            return true;
        }
        return false;
    }
    public void mostrarAbuelos(JTextArea jta){
        mostrarAbuelos(raiz,jta);
    }
    private void mostrarAbuelos(Nodo nodoActual,JTextArea  jta){
        if (nodoActual == null || esHoja(nodoActual)) {
            return;
        }
        mostrarAbuelos(nodoActual.getHI(), jta);        
        if (esAbuelo(nodoActual)) {
            jta.append(String.valueOf(nodoActual.getElem()) + " ");            
        }        
        mostrarAbuelos(nodoActual.getHD(), jta);
    }
    
    public void mostrarAbuelos2(JTextArea jta){
        mostrarAbuelos2(raiz,jta);
    }
    private void mostrarAbuelos2(Nodo nodoActual,JTextArea jta){
        if (nodoActual == null) {
            return;
        }        
        if (nodoActual.getHI() != null) {
            if (esHoja(nodoActual.getHI())) {
                return;
            }
        }
        if (nodoActual.getHD() != null) {
            if (esHoja(nodoActual.getHD())) {
                return;
            }
        }
        mostrarAbuelos2(nodoActual.getHI(), jta);
        jta.append(String.valueOf(nodoActual.getElem()) + " ");
        mostrarAbuelos2(nodoActual.getHD(), jta);
    }
    public void mostrarNietos(JTextArea jta){
        mostrarNietos(raiz,jta);
    }
    private void mostrarNietos(Nodo nodo,JTextArea jta){
        if (nodo == null) {
            return;
        }
        mostrarNietos(nodo.getHI(), jta);
        if (esNieto(nodo)) {
            jta.append(String.valueOf(nodo.getElem()) + " ");
        }
        mostrarNietos(nodo.getHD(), jta);
    }
    private boolean esNieto(Nodo nodo){
        if (nodo == null) {
            return false;
        }
        if (tieneAbuelo(nodo)) {
            return true;
        }
        return false;
    }
    public boolean esNieto(int nieto,int abuelo){
        return esNieto(raiz,nieto, abuelo);
    }
    private boolean esNieto(Nodo nodoActual,int nieto,int abuelo){
        if (nodoActual == null) {
            return false;
        }
        if (esAbuelo(abuelo, nieto)) {
            return true;
        }
        return esNieto(nodoActual.getHI(), nieto, abuelo) || esNieto(nodoActual.getHD(), nieto, abuelo);
    }
    private boolean tieneAbuelo(Nodo nodo){
        return tieneAbuelo(raiz,nodo);
    }
    private boolean tieneAbuelo(Nodo nodoActual,Nodo nodo){
        if (nodoActual == null || esHoja(nodoActual)) {
            return false;
        }
        if (esNieto(nodo.getElem(), nodoActual.getElem())) {
            return true;
        }
        return tieneAbuelo(nodoActual.getHI(), nodo) || tieneAbuelo(nodoActual.getHD(), nodo);
    }
    public void eliminar(int x){
        Nodo p=raiz;
        Nodo ap=null;
        while (p!=null &&p.getElem()!=x){
            ap=p;
            if (x>p.getElem())
                p=p.getHD();
            else
                p=p.getHI();
        }
        if (p==null)
            return;
        if (esHoja(p))
            elimCaso1(ap,p);
        else
            if ((p.getHD()!=null&&p.getHI()==null)||(p.getHD()==null&&p.getHI()!=null))
                elimCaso2(ap,p);
            else
                elimCaso3(p);
    }
    private void elimCaso1(Nodo ap,Nodo p){
        if (ap==null){
            raiz=null;
        }else{
            if (p==ap.getHD())
                ap.setHD(null);
            else
                ap.setHD(null);
        }
    }
    private void elimCaso2(Nodo ap, Nodo p){
        if (ap==null){
            if (p.getHD()!=null)
                raiz=p.getHD();
            else
                raiz=p.getHI();
        }else{
            if (p==ap.getHD())
                if (p.getHD()!=null)
                    ap.setHD(p.getHD());
                else
                    ap.setHD(p.getHI());
            else
                if (p.getHD()!=null)
                    ap.setHD(p.getHD());
                else
                    ap.setHI(p.getHI());
        }        
    }
    private void elimCaso3(Nodo p){
        Nodo s=p.getHD();
        Nodo as=null;
        while (s.getHI()!=null){
            as=s;
            s=s.getHI();
        }
        int aux=p.getElem();
        p.setElem(s.getElem());
        s.setElem(aux);
        if (as==null)
            p.setHD(null);
        else
            as.setHI(null);
    }
    public void eliminar2(int elemento){//ERROR
        Nodo nodoAux = eliminar2(raiz,elemento);
        if (nodoAux != null) {
            raiz = nodoAux;
        }        
    }
    
    private Nodo eliminar2(Nodo nodoActual,int elemento){
        if (nodoActual == null) {
            return null;
        }        
        if (elemento < nodoActual.getElem()) {
            nodoActual = eliminar2(nodoActual.getHI(), elemento);
            return nodoActual;
        }else if(elemento > nodoActual.getElem()){
            nodoActual = eliminar2(nodoActual.getHD(), elemento);
            return nodoActual;
        }
        
        if (esHoja(nodoActual)) {
            return null;
        }
        if (nodoActual.getHI() == null && nodoActual.getHD() != null) {
            return nodoActual.getHD();
        }
        if(nodoActual.getHI() != null && nodoActual.getHD() == null){
            return nodoActual.getHI();
        }
        // 3er Caso: El nodoActual tiene ambos hijos.
        int elementoSucesor = encontrarSucesor(nodoActual.getHD());
        nodoActual.setHD(eliminar2(nodoActual.getHD(), elementoSucesor));
        nodoActual.setElem(elementoSucesor);
        return nodoActual;
    }
    
    public int encontrarSucesor(Nodo nodo){
        return 0;
    }
    public boolean AsubArbolDeB(Arbol B){
        return AsubArbolDeB(raiz, B.raiz);
    }
    private boolean AsubArbolDeB(Nodo A,Nodo B){
        if (B==null)
            return true;
        if (altura(A)<altura(B))
            return false;        
        if (esHoja(B)){
            if (A.getElem()==B.getElem()){
                return true;
            }            
        }            
        if (altura(B)<=altura(A)){
            if (A.getElem()==B.getElem()){
                AsubArbolDeB(A.getHI(), B.getHI());
                AsubArbolDeB(A.getHD(), B.getHD());                
            }else{
                AsubArbolDeB(A.getHI(), B);
                AsubArbolDeB(A.getHD(), B);
            }
        }        
        return false;
    }
    public static void main(String [] args){
        System.out.println(esPrimo(7));
    }
    
    public static boolean esPrimo(int n){
        return esPrimo(n,n-1);
    }
    
    private static boolean esPrimo(int n,int i){        
        if (n == 1 || n == 2) {
            return true;
        }
        if (i == 2 && n % i == 0) {
            return false;
        }
        if (n % i == 0) {
            return false;
        }
        if (!esPrimo(n, i-1)) {
            return false;
        }
        return true;
    }
    public boolean esLista1(){
        return esLista1(raiz);
    }
    
    private boolean esLista1(Nodo nodoActual){
        if (nodoActual == null) {
            return true;
        }
        if (nodoActual.getHD() != null) {
            return false;
        }
        if (nodoActual.getHI() != null) {
            if (nodoActual.getHI().getElem() > nodoActual.getElem()) {
                return false;
            }
        }
        if (!esLista1(nodoActual.getHI())) {
            return false;
        }
        return true;
    }
    
    public boolean esLista(){
        return esLista(raiz);
    }
    
    private boolean esLista(Nodo nodoActual){
        if (nodoActual == null) {
            return true;
        }
        
        if (esHoja(nodoActual)) {
            return true;
        }
        
        if (nodoActual.getHI() != null) {
            if (nodoActual.getHI().getElem() > nodoActual.getElem()) {
                return false;
            }
        }
        if (nodoActual.getHD() != null) {
            if (nodoActual.getHD().getElem() < nodoActual.getElem()) {
                return false;
            }
        }
        
        if (esLista(nodoActual.getHI()) && esLista(nodoActual.getHD()))
            return true;
        else
            return true;
    }
}


