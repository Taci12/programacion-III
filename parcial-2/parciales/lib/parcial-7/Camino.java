public class Camino {
  private ListaGenerica<String> lista;
  private int ahorro;

  public Camino(int ahorro, String origen) {
    this.ahorro = ahorro;
    lista = new ListaGenericaEnlazada<String>();
    lista.agregarFinal(origen);
  }

  public Camino() {
    lista = new ListaGenericaEnlazada<String>();
    ahorro = 0;
  }

  public ListaGenerica<String> lista() {
    return lista;
  }

  public void agregarFinal(String elemento) {
    lista.agregarFinal(elemento);
  }

  public void eliminarFinal() {
    lista.eliminarEn(lista.tamanio() - 1);
  }

  public int ahorro() {
    return ahorro;
  }

  public void setAhorro(int ahorro) {
    this.ahorro = ahorro;
  }

}