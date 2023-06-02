public class CaminoCombustible {
  private ListaGenerica<String> camino;
  private int combustible;

  public ListaGenerica<String> getCamino() {
    return camino;
  }

  public void setCamino(ListaGenerica<String> camino) {
    this.camino = camino;
  }

  public int getCombustible() {
    return combustible;
  }

  public void setCombustible(int combustible) {
    this.combustible = combustible;
  }

  public CaminoCombustible(ListaGenerica<String> camino, int combustible) {
    this.camino = camino;
    this.combustible = combustible;
  }

  public CaminoCombustible() {
    this.camino = new ListaGenericaEnlazada<String>();
    this.combustible = 0;
  }

  public void sumarCombustible(int cantidad) {
    this.combustible += cantidad;
  }

}
