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
      devolverCaminoRecursivo(resultado, posicion, marca, ciudad2);
      resultado.eliminarEn(resultado.tamanio() - 1);
      return resultado;
    } else
      return null;
  }

  // gracias Mate
  private void devolverCaminoRecursivo(ListaGenerica<String> resultado, int posicion, boolean[] marca,
      String destino) {

    // funciona si pongo que marque la posicion adentro del if
    marca[posicion] = true;
    if (mapaCiudades.vertice(posicion).dato() == destino) {
      resultado.agregarInicio(destino);
      return;
    }

    ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
    int adyacencias = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion)).tamanio();

    // mientras que no haya encontrado al vertice resultado, sigo recorriendo
    for (int i = 0; (i < adyacencias) && (resultado.esVacia()); i++) {
      if (!marca[i])
        devolverCaminoRecursivo(resultado, adyacentes.elemento(i).verticeDestino().posicion(), marca, destino);
      // si encontro el destino, agrego el actual a la lista
      if (!resultado.esVacia())
        resultado.agregarInicio(adyacentes.elemento(i).verticeDestino().dato());
    }
  }

  // encuentra el nodo que contiene a ciudad1
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

  public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
      ListaGenerica<String> ciudades) {
    if (!this.mapaCiudades.esVacio()) {
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
      boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
      for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)
        marca[i] = false;
      int posicion = obtenerPosicion(ciudad1);
      devolverCaminoExceptuandoRecursivo(resultado, posicion, marca, ciudad2, ciudades);
      resultado.eliminarEn(resultado.tamanio() - 1);
      return resultado;
    } else
      return null;
  }

  private void devolverCaminoExceptuandoRecursivo(ListaGenerica<String> resultado, int posicion, boolean[] marca,
      String destino, ListaGenerica<String> ciudades) {

    marca[posicion] = true;
    for (int i = 0; i < ciudades.tamanio() - 1; i++)
      if (ciudades.elemento(i) == mapaCiudades.vertice(posicion).dato())
        return;

    if (mapaCiudades.vertice(posicion).dato() == destino) {
      resultado.agregarInicio(destino);
      return;
    }

    ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
    int adyacencias = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion)).tamanio();

    // mientras que no haya encontrado al vertice resultado, sigo recorriendo
    for (int i = 0; (i < adyacencias) && (resultado.esVacia()); i++) {
      if (!marca[i])
        devolverCaminoRecursivo(resultado, adyacentes.elemento(i).verticeDestino().posicion(), marca, destino);
      // si encontro el destino, agrego el actual a la lista
      if (!resultado.esVacia())
        resultado.agregarInicio(adyacentes.elemento(i).verticeDestino().dato());
    }
  }
}