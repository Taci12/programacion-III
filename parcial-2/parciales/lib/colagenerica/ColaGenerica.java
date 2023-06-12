public class ColaGenerica<T> {
  private ListaGenericaEnlazada<T> cola;
  int size;

  public ColaGenerica() {
    this.cola = new ListaGenericaEnlazada<T>();
    this.size = -1;
  }

  public boolean esVacia() {
    return (this.size == -1);
  }

  public void encolar(T elemento) {
    this.cola.agregarFinal(elemento);
    this.size++;
  }

  public T desencolar() {
    T elemento = this.cola.elemento(0);
    this.cola.eliminarEn(0);
    this.size--;
    return elemento;
  }

  public T tope() {
    return this.cola.elemento(this.size);
  }

  public String toString() {
    return this.cola.toString();
  }
}
