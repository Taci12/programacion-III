import java.util.List;

public class Delta {
  private Grafo<String> grafo;

  public Grafo<String> getGrafo() {
    return grafo;
  }

  public void setGrafo(Grafo<String> grafo) {
    this.grafo = grafo;
  }

  public Delta() {
  }

  public int maxIslasDistintas(Grafo<String> grafo) {
    int dim = grafo.listaDeVertices().tamanio();
    boolean[] marca = new boolean[dim];
    for (int i = 0; i < dim; i++)
      marca[i] = false;
    Vertice<String> muellePrincipal = encontrarVertice(grafo, "Muelle principal");
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(muellePrincipal);
    marca[muellePrincipal.posicion()] = true;
    ady.comenzar();
    int max = -1, aux;
    while (!ady.fin()) {
      aux = maxIslasDistintas(grafo, muellePrincipal, ady.proximo().verticeDestino(), marca, max);
      if (aux > max)
        max = aux;
    }
    return max;
  }

  private int maxIslasDistintas(Grafo<String> grafo, Vertice<String> muelle, Vertice<String> verticeActual,
      boolean[] marca, int llamados) {

    marca[verticeActual.posicion()] = true;
    int cant = 1;
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(verticeActual);
    Vertice<String> verticeAuxiliar;
    ady.comenzar();
    while (!ady.fin()) {
      verticeAuxiliar = ady.proximo().verticeDestino();
      if (!marca[verticeAuxiliar.posicion()])
        cant += maxIslasDistintas(grafo, muelle, verticeAuxiliar, marca, llamados + 1);
    }
    return cant;
  }

  private void copiarLista(ListaGenerica<String> origen, ListaGenerica<String> destino) {
    destino.comenzar();
    while (!destino.esVacia())
      destino.eliminarEn(0);
    origen.comenzar();
    while (!origen.fin())
      destino.agregarFinal(origen.proximo());
  }

  private Vertice<String> encontrarVertice(Grafo<String> grafo, String dato) {
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    Vertice<String> actual;
    vertices.comenzar();
    while (!vertices.fin()) {
      actual = vertices.proximo();
      if (actual.dato().equals(dato))
        return actual;
    }
    return null;
  }

  public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
    if (!grafo.esVacio()) {
      int dim = grafo.listaDeVertices().tamanio();
      boolean[] marca = new boolean[dim];
      RutaMinima resultado = new RutaMinima();
      Vertice<String> origen = encontrarVertice(grafo, islaO);
      Vertice<String> destino = encontrarVertice(grafo, islaD);
      RutaMinima auxiliar = new RutaMinima();
      int[] pesos = new int[2];
      // peso[0] es el peso minimo, peso[1] es el auxiliar
      auxiliar.getCamino().agregarFinal(islaO);
      if (origen != null && destino != null)
        caminoMasCorto(grafo, origen, destino, resultado, auxiliar, marca, pesos);
      System.out.println("Peso minimo: " + pesos[0]); // DEBUG
      return resultado;
    } else
      return null;
  }

  private void caminoMasCorto(Grafo<String> grafo, Vertice<String> actual, Vertice<String> destino,
      RutaMinima resultado, RutaMinima auxiliar, boolean[] marca, int[] pesos) {

    marca[actual.posicion()] = true;
    // si estoy en el muelle y no quiero ir al muelle
    if (actual.posicion() == 0 && destino.posicion() != 0)
      auxiliar.setUnicoBoleto(false);
    // si llegue al destino, me fijo si tengo que actualizar el resultado
    if (actual.equals(destino)) {
      if (pesos[1] < pesos[0] || resultado.getCamino().esVacia()) {
        copiarLista(auxiliar.getCamino(), resultado.getCamino());
        resultado.setUnicoBoleto(auxiliar.isUnicoBoleto());
        pesos[0] = pesos[1];
      }
    }
    // si no llegue al destino, sigo recorriendo
    else {
      ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
      Arista<String> arista;
      ady.comenzar();
      while (!ady.fin()) {
        arista = ady.proximo();
        if (!marca[arista.verticeDestino().posicion()]) {
          auxiliar.getCamino().agregarFinal(arista.verticeDestino().dato());
          pesos[1] += arista.peso();

          caminoMasCorto(grafo, arista.verticeDestino(), destino, resultado, auxiliar, marca, pesos);

          pesos[1] -= arista.peso();
          auxiliar.getCamino().eliminarEn(auxiliar.getCamino().tamanio() - 1);
        }
      }
    }
    marca[actual.posicion()] = false;
  }
}