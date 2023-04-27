package prog3.arbol;

public class PilaGenerica<T> {

    private ListaGenericaEnlazada<T> pila;
    private int actual;

    public PilaGenerica() {
        pila = new ListaGenericaEnlazada<T>();
        pila.comenzar();
        this.actual = -1;
    }

    public void apilar(T elem) {
        this.pila.agregarFinal(elem);
        actual++;
    }

    public T desapilar() {
        T elemento = pila.elemento(actual);
        this.pila.eliminarEn(actual);
        actual--;
        return elemento;
    }

    public T tope() {
        return pila.elemento(actual);
    }

    public boolean esVacia() {
        return pila.esVacia();
    }

    public String toString() {
        return this.pila.toString();
    }
}
