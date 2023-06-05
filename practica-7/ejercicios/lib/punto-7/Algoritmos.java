public class Algoritmos {

  public Algoritmos() {

  }

  public <T> boolean subgrafoCuadrado(Grafo<T> grafo) {
    boolean resultado = false;
    if (!grafo.esVacio()) {
      int dim = grafo.listaDeVertices().tamanio();
      boolean[] marca = new boolean[dim];
      int i;
      for (i = 0; i < dim; i++)
        marca[i] = false;
      Vertice<T> actualVertice;
      Vertice<T> origenVertice;
      for (i = 0; (i < dim) && !(resultado); i++) {
        actualVertice = grafo.listaDeVertices().elemento(i);
        origenVertice = actualVertice;
        resultado = subgrafoCuadradoRecursivo(grafo, actualVertice, origenVertice, marca, 0);
      }
    }
    return resultado;
  }

  private <T> boolean subgrafoCuadradoRecursivo(Grafo<T> grafo, Vertice<T> actualVertice, Vertice<T> origenVertice,
      boolean[] marca, int cuenta) {

    System.out.println("Vertice actual: " + actualVertice.dato()); // DEBUG
    System.out.println("Vertice origen: " + origenVertice.dato() + "\n"); // DEBUG
    boolean resultado = false;
    boolean estoyEnOrigen = origenVertice.dato().equals(actualVertice.dato());
    // no marco el origen como visitado, sino no puedo saber si volvi
    if (!estoyEnOrigen)
      marca[actualVertice.posicion()] = true;

    if ((estoyEnOrigen) && (cuenta == 4))
      return true;

    else {
      ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(actualVertice);
      Arista<T> aristaAuxiliar;
      adyacentes.comenzar();
      while (!adyacentes.fin() && !resultado) {
        aristaAuxiliar = adyacentes.proximo();
        if (!marca[aristaAuxiliar.verticeDestino().posicion()])
          resultado = subgrafoCuadradoRecursivo(grafo, aristaAuxiliar.verticeDestino(), origenVertice, marca,
              cuenta + 1);
      }
    }
    marca[actualVertice.posicion()] = false;
    return resultado;
  }

}