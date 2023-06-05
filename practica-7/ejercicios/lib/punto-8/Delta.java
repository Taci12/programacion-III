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
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
    int dim = grafo.listaDeVertices().tamanio();
    boolean[] marca = new boolean[dim];
    for (int i = 0; i < dim; i++)
      marca[i] = false;
    Vertice<String> muellePrincipal = encontrarVertice(grafo, "Muelle principal");
    marca[muellePrincipal.posicion()] = true;
    maxIslasDistintasRecursivo(grafo, resultado, auxiliar, muellePrincipal, muellePrincipal, marca);
    return resultado.tamanio();
  }

  // ! no funciona
  private void maxIslasDistintasRecursivo(Grafo<String> grafo, ListaGenerica<String> resultado,
      ListaGenerica<String> auxiliar, Vertice<String> muellePrincipal, Vertice<String> verticeActual, boolean[] marca) {

    System.out.println("Vertice Actual: " + verticeActual.dato());
    System.out.println("auxiliar: " + auxiliar.toString());
    System.out.println("resultado: " + resultado.toString() + "\n");

    marca[verticeActual.posicion()] = true;

    // si no es el primer llamado y la lista resultado es vacia o mas chica que la
    // auxiliar
    if (((resultado.esVacia()) || (auxiliar.tamanio() > resultado.tamanio())) && !auxiliar.esVacia()) {
      // copio a resultado la lista auxiliar
      resultado.comenzar();
      while (!resultado.esVacia())
        resultado.eliminarEn(0);
      auxiliar.comenzar();
      while (auxiliar.fin())
        resultado.agregarFinal(auxiliar.proximo());
    }

    auxiliar.agregarFinal(verticeActual.dato());
    ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(verticeActual);
    adyacentes.comenzar();
    Vertice<String> verticeAuxiliar;
    while (!adyacentes.fin()) {
      verticeAuxiliar = adyacentes.proximo().verticeDestino();
      if (!marca[verticeAuxiliar.posicion()])
        maxIslasDistintasRecursivo(grafo, resultado, auxiliar, muellePrincipal, verticeAuxiliar, marca);
    }

    marca[verticeActual.posicion()] = false;
    auxiliar.eliminarEn(auxiliar.tamanio() - 1);
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
}