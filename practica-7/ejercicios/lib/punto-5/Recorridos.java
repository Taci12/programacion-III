public class Recorridos<T> {
  public ListaGenerica<T> bfs(Grafo<T> grafo) {
    ListaGenerica<T> recorrido = new ListaGenericaEnlazada<T>();
    if (!grafo.esVacio()) {
      recorrido.comenzar();
      ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
      int dim = vertices.tamanio();
      boolean[] marca = new boolean[dim];
      for (int i = 0; i < dim; i++)
        marca[i] = false;
      Vertice<T> inicio;
      vertices.comenzar();
      while (!vertices.fin()) {
        inicio = vertices.proximo();
        if (!marca[inicio.posicion()])
          bfs(grafo, inicio, recorrido, marca);
      }
    }
    return recorrido;
  }

  private void bfs(Grafo<T> grafo, Vertice<T> inicio, ListaGenerica<T> recorrido, boolean[] marca) {
    ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
    marca[inicio.posicion()] = true;
    cola.encolar(inicio);
    Vertice<T> actual;
    Vertice<T> siguiente;
    ListaGenerica<Arista<T>> ady;
    int pos;
    while (!cola.esVacia()) {
      actual = cola.desencolar();
      recorrido.agregarFinal(actual.dato());
      ady = grafo.listaDeAdyacentes(actual);
      ady.comenzar();
      while (!ady.fin()) {
        siguiente = ady.proximo().verticeDestino();
        pos = siguiente.posicion();
        if (!marca[pos]) {
          marca[pos] = true;
          cola.encolar(siguiente);
        }
      }
    }
  }
}