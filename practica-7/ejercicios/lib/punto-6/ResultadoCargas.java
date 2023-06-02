public class ResultadoCargas {
  private ListaGenerica<String> camino;
  private int cantidadMinima;

  public ListaGenerica<String> getCamino() {
    return camino;
  }

  public void setCamino(ListaGenerica<String> camino) {
    this.camino = camino;
  }

  public int getCantidadMinima() {
    return cantidadMinima;
  }

  public void setCantidadMinima(int cantidadMinima) {
    this.cantidadMinima = cantidadMinima;
  }

  public ResultadoCargas() {
    this.camino = new ListaGenericaEnlazada<String>();
    this.cantidadMinima = 999999;
  }

}
