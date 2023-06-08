public class GuiaDeTurismo {
  private Vertice<String> obtenerVertice(Grafo<String> grafo, String dato) {
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    Vertice<String> actual;
    while (!vertices.fin()) {
      actual = vertices.proximo();
      if (actual.dato().equals(dato))
        return actual;
    }
    return null;
  }

  private void copiarLista(ListaGenerica<String> origen, ListaGenerica<String> destino) {
    destino.comenzar();
    while (!destino.esVacia())
      destino.eliminarEn(0);
    origen.comenzar();
    while (!origen.fin())
      destino.agregarFinal(origen.proximo());
  }

  public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen,
      String puntoInteresDestino) {

    Recorrido resultado = new Recorrido();
    if (!grafo.esVacio()) {
      Vertice<String> origen = obtenerVertice(grafo, puntoInteresOrigen);
      Vertice<String> destino = obtenerVertice(grafo, puntoInteresDestino);
      Recorrido auxiliar = new Recorrido();
      if (origen != null && destino != null) {
        int dim = grafo.listaDeVertices().tamanio();
        boolean[] marca = new boolean[dim];
        for (int i = 0; i < dim; i++)
          marca[i] = false;
        marca[origen.posicion()] = true;
        resultado.camino().comenzar();
        resultado.setMayorCantidad(0);
        auxiliar.camino().comenzar();
        auxiliar.setMayorCantidad(9999);
        caminoConMenorNrodeViajes(grafo, origen, destino, resultado, auxiliar, marca);
      }
    }
    System.out.println("Mayor cantidad por viaje: " + resultado.getMayorCantidad());
    return resultado.camino();
  }

  private void caminoConMenorNrodeViajes(Grafo<String> grafo, Vertice<String> actual, Vertice<String> destino,
      Recorrido resultado, Recorrido auxiliar, boolean[] marca) {

    marca[actual.posicion()] = true;
    auxiliar.camino().agregarFinal(actual.dato());

    if ((actual.equals(destino))) {
      if (auxiliar.getMayorCantidad() > resultado.getMayorCantidad()) {
        copiarLista(auxiliar.camino(), resultado.camino());
        resultado.setMayorCantidad(auxiliar.getMayorCantidad());
      }
    }

    else {
      ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(actual);
      Arista<String> arista;
      ady.comenzar();
      while (!ady.fin()) {
        arista = ady.proximo();
        if (!marca[arista.verticeDestino().posicion()]) {
          // si la arista por la que voy a viajar me reduce la cantidad de pasajeros,
          // actualizo la cantidad maxima de pasajeros que puedo llevar
          int peso = arista.peso();
          int anteriorMinimo = auxiliar.getMayorCantidad();
          if (peso < auxiliar.getMayorCantidad())
            auxiliar.setMayorCantidad(peso);

          caminoConMenorNrodeViajes(grafo, arista.verticeDestino(), destino, resultado, auxiliar, marca);

          auxiliar.setMayorCantidad(anteriorMinimo);
        }
      }
    }
    auxiliar.camino().eliminarEn(auxiliar.camino().tamanio() - 1);
    marca[actual.posicion()] = false;

  }
}