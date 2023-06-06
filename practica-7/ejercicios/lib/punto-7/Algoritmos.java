public class Algoritmos<T> {

  public Algoritmos() {

  }

  public boolean subgrafoCuadrado(Grafo<T> grafo) {
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

  private boolean subgrafoCuadradoRecursivo(Grafo<T> grafo, Vertice<T> actualVertice, Vertice<T> origenVertice,
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

  public int getGrado(Grafo<T> grafo) {
    if (!grafo.esVacio()) {
      int dim = grafo.listaDeVertices().tamanio();
      boolean[] marca = new boolean[dim];
      for (boolean b : marca)
        b = false;
      int[] gradoVertice = new int[dim];
      for (int v : gradoVertice)
        v = 0;
      Vertice<T> verticeActual = grafo.listaDeVertices().elemento(0);
      getGrado(grafo, gradoVertice, marca, verticeActual);
      int max = -1;
      for (int vertice : gradoVertice)
        if (vertice > max)
          max = vertice;
      return max;
    }
    return 0;
  }

  private void getGrado(Grafo<T> grafo, int[] gradoVertice, boolean[] marca, Vertice<T> verticeActual) {
    int pos = verticeActual.posicion();
    marca[pos] = true;
    ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(verticeActual);
    gradoVertice[pos] += adyacentes.tamanio();
    Vertice<T> verticeAuxiliar;
    adyacentes.comenzar();
    while (!adyacentes.fin()) {
      verticeAuxiliar = adyacentes.proximo().verticeDestino();
      int posicionAuxiliar = verticeAuxiliar.posicion();
      if (!marca[posicionAuxiliar]) {
        gradoVertice[posicionAuxiliar] += 1;
        getGrado(grafo, gradoVertice, marca, verticeAuxiliar);
      }
    }
  }

  public boolean tieneCiclo(Grafo<T> grafo) {
    if (!grafo.esVacio()) {
      int dim = grafo.listaDeVertices().tamanio();
      boolean[] marca = new boolean[dim];
      int i;
      for (i = 0; i < dim; i++)
        marca[i] = false;
      Vertice<T> verticeActual;
      Vertice<T> verticeOrigen;
      ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
      boolean resultado = false;
      vertices.comenzar();
      while (!vertices.fin() && !resultado) {
        verticeActual = vertices.proximo();
        verticeOrigen = verticeActual;
        resultado = tieneCiclo(grafo, verticeActual, verticeOrigen, marca, true);
      }
      return resultado;
    }
    return false;
  }

  private boolean tieneCiclo(Grafo<T> grafo, Vertice<T> verticeActual, Vertice<T> verticeOrigen, boolean[] marca,
      boolean primeraIteracion) {

    System.out.println("Vertice origen: " + verticeOrigen.dato()); // DEBUG
    System.out.println("Vertice actual: " + verticeActual.dato() + "\n"); // DEBUG

    boolean estoyEnOrigen = verticeActual.equals(verticeOrigen);
    boolean resultado = false;
    // si marco cuando estoy en el origen nunca voy a saber si hice un ciclo
    if (!estoyEnOrigen) {
      marca[verticeActual.posicion()] = true;
    }

    if (estoyEnOrigen && !primeraIteracion)
      return true;

    else {
      ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(verticeActual);
      Vertice<T> verticeAuxiliar;
      adyacentes.comenzar();
      while (!adyacentes.fin() && !resultado) {
        verticeAuxiliar = adyacentes.proximo().verticeDestino();
        if (!marca[verticeAuxiliar.posicion()])
          resultado = tieneCiclo(grafo, verticeAuxiliar, verticeOrigen, marca, false);
      }
    }
    marca[verticeActual.posicion()] = false;
    return resultado;
  }
}