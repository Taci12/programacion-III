public class Mapa {

  private Grafo<String> mapaCiudades;

  public Grafo<String> getMapaCiudades() {
    return mapaCiudades;
  }

  public void setMapaCiudades(GrafoImplListAdy<String> mapaCiudades) {
    this.mapaCiudades = mapaCiudades;
  }

  public Mapa(Grafo<String> ciudades) {
    this.mapaCiudades = ciudades;
  }

  // variacion de recorrido BFS que retorna el camino de ciudad1 a ciudad2
  // en forma de lista enlazada
  public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
    if (!this.mapaCiudades.esVacio()) {
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
      boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
      for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)
        marca[i] = false;
      int posicion = obtenerPosicion(ciudad1);
      resultado.comenzar();
      devolverCaminoRecursivo(resultado, posicion, marca, ciudad2);
      return resultado;
    } else
      return null;
  }

  private void devolverCaminoRecursivo(ListaGenerica<String> resultado, int posicion,
      boolean[] marca, String destino) {

    String ciudadActual = mapaCiudades.vertice(posicion).dato();
    marca[posicion] = true;

    if (ciudadActual.equals(destino)) {
      resultado.agregarInicio(ciudadActual);
      return;
    }

    ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
    while ((!adyacentes.fin()) && (resultado.esVacia())) {
      Arista<String> actual = adyacentes.proximo();
      if (!marca[actual.verticeDestino().posicion()])
        devolverCaminoRecursivo(resultado, actual.verticeDestino().posicion(), marca, destino);
      if (!resultado.esVacia())
        resultado.agregarInicio(ciudadActual);
    }
  }

  // Copia una lista "auxiliar" a otra "resultado"
  private void copiarLista(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar) {
    while (!resultado.esVacia())
      resultado.eliminarEn(0);
    auxiliar.comenzar();
    while (!auxiliar.fin())
      resultado.agregarFinal(auxiliar.proximo());
  }

  private void eliminarLista(ListaGenerica<String> lista) {
    lista.comenzar();
    while (!lista.esVacia())
      lista.eliminarEn(0);
  }

  // Encuentra el nodo que contiene a ciudad1
  private int obtenerPosicion(String ciudad1) {
    int i;
    Vertice<String> verticeActual = null;
    ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
    for (i = 0; i < vertices.tamanio() - 1; i++) {
      verticeActual = vertices.elemento(i);
      if (verticeActual.dato() == ciudad1)
        break;
    }
    return verticeActual.posicion();
  }

  private Vertice<String> obtenerVertice(String ciudad1) {
    int i;
    Vertice<String> verticeActual = null;
    ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
    for (i = 0; i < vertices.tamanio() - 1; i++) {
      verticeActual = vertices.elemento(i);
      if (verticeActual.dato().equals(ciudad1))
        break;
    }
    return verticeActual;
  }

  public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
      ListaGenerica<String> ciudades) {
    if (!this.mapaCiudades.esVacio()) {
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
      boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
      for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)
        marca[i] = false;
      int posicion = obtenerPosicion(ciudad1);
      resultado.comenzar();
      devolverCaminoExceptuandoRecursivo(resultado, posicion, marca, ciudad2, ciudades);
      return resultado;
    } else
      return null;
  }

  private void devolverCaminoExceptuandoRecursivo(ListaGenerica<String> resultado, int posicion,
      boolean[] marca, String destino, ListaGenerica<String> ciudades) {

    String ciudadActual = mapaCiudades.vertice(posicion).dato();
    marca[posicion] = true;

    if (ciudadActual.equals(destino)) {
      resultado.agregarInicio(ciudadActual);
      return;
    }

    if (contieneCiudad(ciudades, ciudadActual))
      return;

    ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
    adyacentes.comenzar();
    while ((!adyacentes.fin()) && (resultado.esVacia())) {
      Arista<String> actual = adyacentes.proximo();
      if (!marca[actual.verticeDestino().posicion()])
        devolverCaminoRecursivo(resultado, actual.verticeDestino().posicion(), marca, destino);
      if (!resultado.esVacia())
        resultado.agregarInicio(ciudadActual);
    }
  }

  private boolean contieneCiudad(ListaGenerica<String> ciudades, String ciudad) {
    ciudades.comenzar();
    while (!ciudades.fin() && !ciudades.proximo().equals(ciudad))
      continue;
    return (ciudades.fin()) ? false : true;
  }

  public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
    if (!this.mapaCiudades.esVacio()) {
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
      boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
      for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)
        marca[i] = false;
      int posicion = obtenerPosicion(ciudad1);
      resultado.comenzar();
      ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
      auxiliar.comenzar();
      caminoMasCortoRecursivo(resultado, auxiliar, posicion, marca, ciudad2);
      return resultado;
    } else
      return null;
  }

  private void caminoMasCortoRecursivo(ListaGenerica<String> resultado,
      ListaGenerica<String> auxiliar, int posicion,
      boolean[] marca, String destino) {

    String ciudadActual = mapaCiudades.vertice(posicion).dato();
    marca[posicion] = true;
    auxiliar.agregarFinal(ciudadActual);

    System.out.println("Ciudad Actual: " + ciudadActual); // DEBUG
    System.out.println("Auxiliar: " + auxiliar.toString()); // DEBUG
    System.out.println("Resultado: " + resultado.toString() + "\n"); // DEBUG

    if (ciudadActual.equals(destino) && (resultado.esVacia() || resultado.tamanio() > auxiliar.tamanio()))
      copiarLista(resultado, auxiliar);
    else {
      ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
        Arista<String> actual = adyacentes.proximo();
        if (!marca[actual.verticeDestino().posicion()]) {
          caminoMasCortoRecursivo(resultado, auxiliar, actual.verticeDestino().posicion(), marca, destino);
          marca[actual.verticeDestino().posicion()] = false;
        }
      }
    }

    marca[posicion] = false;
    auxiliar.eliminarEn(auxiliar.tamanio() - 1);
  }

  public ListaGenerica<String> caminoSinCargarCombustible(Grafo<String> grafo, String ciudad1, String ciudad2,
      int tanqueAuto) {
    if (grafo.esVacio())
      return null;
    else {
      Vertice<String> verticeOrigen = obtenerVertice(ciudad1);
      Vertice<String> verticeDestino = obtenerVertice(ciudad2);
      boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
      for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++)
        marca[i] = false;
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
      resultado.comenzar();
      ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
      auxiliar.comenzar();
      caminoSinCargarCombustibleRecursivo(grafo, verticeOrigen, verticeDestino, tanqueAuto, resultado, auxiliar, marca);
      return resultado;
    }
  }

  private void caminoSinCargarCombustibleRecursivo(Grafo<String> grafo, Vertice<String> verticeActual,
      Vertice<String> verticeDestino, int tanqueAuto, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar,
      boolean[] marca) {

    if (tanqueAuto >= 0) {

      auxiliar.agregarFinal(verticeActual.dato());
      marca[verticeActual.posicion()] = true;

      if (verticeActual.dato().equals(verticeDestino.dato())) {
        copiarLista(resultado, auxiliar);
      }

      else {
        Arista<String> aristaActual;
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(verticeActual);
        adyacentes.comenzar();

        while (!adyacentes.fin()) {
          aristaActual = adyacentes.proximo();
          if (!marca[aristaActual.verticeDestino().posicion()])
            caminoSinCargarCombustibleRecursivo(grafo, aristaActual.verticeDestino(), verticeDestino,
                tanqueAuto - aristaActual.peso(), resultado, auxiliar, marca);
        }
      }

      if (resultado.esVacia()) {
        auxiliar.eliminarEn(auxiliar.tamanio() - 1);
        marca[verticeActual.posicion()] = false;
      }
    }

  }

  public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {

    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio()];

    for (int i = 0; i > this.mapaCiudades.listaDeVertices().tamanio(); i++)
      marca[i] = false;

    Vertice<String> origenVertice = obtenerVertice(ciudad1);
    Vertice<String> destinoVertice = obtenerVertice(ciudad2);
    if ((origenVertice != null) && (destinoVertice != null)) {
      resultado.comenzar();
      auxiliar.comenzar();
      menorCargaRecursivo(origenVertice, destinoVertice, tanqueAuto, 999, 0, tanqueAuto, resultado, auxiliar, marca);
    }
    return resultado;
  }

  private void menorCargaRecursivo(Vertice<String> actualVertice, Vertice<String> destinoVertice, int tanqueAuto,
      int cantidadMinima, int cantidadActual, int capacidadTanque,
      ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, boolean[] marca) {

    // si todavia tengo nafta en el tanque
    if (tanqueAuto >= 0) {
      auxiliar.agregarFinal(actualVertice.dato());
      marca[actualVertice.posicion()] = true;
      if (actualVertice.dato().equals(destinoVertice.dato()) && (cantidadActual < cantidadMinima))
        copiarLista(resultado, auxiliar);
      else {
        Arista<String> actualArista;
        ListaGenerica<Arista<String>> adyacentes = this.mapaCiudades.listaDeAdyacentes(actualVertice);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
          actualArista = adyacentes.proximo();
          if (!marca[actualArista.verticeDestino().posicion()])
            menorCargaRecursivo(actualArista.verticeDestino(), destinoVertice, tanqueAuto - actualArista.peso(),
                cantidadMinima, cantidadActual, capacidadTanque, resultado, auxiliar, marca);
        }
      }
    } else {

    }
  }

}