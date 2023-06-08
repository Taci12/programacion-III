public class RutaMinima {
  private ListaGenerica<String> camino;
  private boolean unicoBoleto;

  public ListaGenerica<String> getCamino() {
    return camino;
  }

  public void setCamino(ListaGenerica<String> camino) {
    this.camino = camino;
  }

  public boolean isUnicoBoleto() {
    return unicoBoleto;
  }

  public void setUnicoBoleto(boolean unicoBoleto) {
    this.unicoBoleto = unicoBoleto;
  }

  public RutaMinima() {
    this.camino = new ListaGenericaEnlazada<String>();
    this.unicoBoleto = true;
  }

}