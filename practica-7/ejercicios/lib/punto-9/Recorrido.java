public class Recorrido {
  private ListaGenerica<String> camino;
  private int mayorCantidad;

  public ListaGenerica<String> camino() {
    return camino;
  }

  public int getMayorCantidad() {
    return mayorCantidad;
  }

  public void setMayorCantidad(int cantidadMaxima) {
    this.mayorCantidad = cantidadMaxima;
  }

  public Recorrido() {
    this.camino = new ListaGenericaEnlazada<String>();
    this.mayorCantidad = 99999;
  }

}