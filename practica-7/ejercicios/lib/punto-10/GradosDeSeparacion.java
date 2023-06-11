public class GradosDeSeparacion<T> {
  public int maximoGradoDeSeparacion(Grafo<T> grafo) {
    int dim = grafo.listaDeVertices().tamanio();
    boolean[] marca = new boolean[dim];
    for (int i = 0; i < dim; i++)
      marca[i] = false;
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    int grado = -2, gradoMaximo = -3;
    while (!vertices.fin()) {
      grado = maximoGradoDeSeparacion(grafo, vertices.proximo(), marca);
      if (grado == -1)
        return -1;
      else {
        if (grado > gradoMaximo)
          gradoMaximo = grado;
      }
    }
    return gradoMaximo;
  }

  private int maximoGradoDeSeparacion(Grafo<T> grafo, Vertice<T> inicio, boolean[] marca) {
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(inicio);
    Vertice<T> actual;
    Vertice<T> auxiliar;
    ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
    int grado = -1;
    cola.encolar(inicio);
    cola.encolar(null);
    marca[inicio.posicion()] = true;
    while (!cola.esVacia()) {
      actual = cola.desencolar();
      if (actual == null)
        grado++;
      else {
        ady = grafo.listaDeAdyacentes(actual);
        ady.comenzar();
        while (!ady.fin()) {
          auxiliar = ady.proximo().verticeDestino();
          if (!marca[auxiliar.posicion()]) {
            cola.encolar(auxiliar);
            marca[auxiliar.posicion()] = true;
          }
        }
        cola.encolar(null);
      }
    }
    for (boolean e : marca)
      e = false;
    return grado;
  }
}