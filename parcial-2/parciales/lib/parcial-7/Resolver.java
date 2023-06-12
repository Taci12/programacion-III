public class Resolver {
  public Camino resolver(Grafo<String> ciudades, String origen, String destino, int maxMonto) {
    Vertice<String> inicio = obtenerVertice(origen, ciudades);
    Vertice<String> fin = obtenerVertice(destino, ciudades);
    if (inicio == null || fin == null)
      return null;
    Camino resultado = new Camino();
    ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
    resultado.lista().comenzar();
    auxiliar.comenzar();
    boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
    for (boolean e : marca)
      e = false;
    resolver(ciudades, inicio, fin, maxMonto, resultado, auxiliar, marca);
    return resultado;
  }

  private void resolver(Grafo<String> grafo, Vertice<String> actual, Vertice<String> destino, int maxMonto,
      Camino resultado, ListaGenerica<String> auxiliar, boolean[] marca) {

    int pos = actual.posicion();
    marca[pos] = true;
    auxiliar.agregarFinal(actual.dato());
    if (actual.equals(destino)) {
      if ((auxiliar.tamanio() > resultado.lista().tamanio())
          || (auxiliar.tamanio() == resultado.lista().tamanio() && maxMonto > resultado.ahorro())) {
        copiarLista(auxiliar, resultado.lista());
        resultado.setAhorro(maxMonto);
      }
    } else {
      ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
      ady.comenzar();
      Arista<String> arista;
      while (!ady.fin()) {
        arista = ady.proximo();
        int posAux = arista.verticeDestino().posicion();
        if (!marca[posAux] && maxMonto - arista.peso() >= 0) {
          resolver(grafo, arista.verticeDestino(), destino, maxMonto - arista.peso(), resultado, auxiliar, marca);
        }
      }
    }
    marca[pos] = false;
    auxiliar.eliminarEn(auxiliar.tamanio() - 1);
  }

  public void copiarLista(ListaGenerica<String> origen, ListaGenerica<String> destino) {
    destino.comenzar();
    while (!destino.esVacia())
      destino.eliminarEn(0);
    origen.comenzar();
    while (!origen.fin())
      destino.agregarFinal(origen.proximo());
  }

  private Vertice<String> obtenerVertice(String dato, Grafo<String> grafo) {
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    Vertice<String> resultado;
    while (!vertices.fin()) {
      resultado = vertices.proximo();
      if (resultado.dato().equals(dato))
        return resultado;
    }
    return null;
  }
}