public class TestRecorridos<T> {
  public static void main(String[] args) {

    Grafo<Integer> grafo = new GrafoImplListAdy<Integer>();

    Vertice<Integer> uno = new VerticeImplListAdy<Integer>(1);
    Vertice<Integer> dos = new VerticeImplListAdy<Integer>(2);
    Vertice<Integer> tres = new VerticeImplListAdy<Integer>(3);
    Vertice<Integer> cuatro = new VerticeImplListAdy<Integer>(4);
    Vertice<Integer> cinco = new VerticeImplListAdy<Integer>(5);
    Vertice<Integer> seis = new VerticeImplListAdy<Integer>(6);

    grafo.agregarVertice(uno);
    grafo.agregarVertice(dos);
    grafo.agregarVertice(tres);
    grafo.agregarVertice(cuatro);
    grafo.agregarVertice(cinco);
    grafo.agregarVertice(seis);

    grafo.conectar(uno, dos, 0);
    grafo.conectar(uno, seis, 0);
    grafo.conectar(dos, tres, 0);
    grafo.conectar(tres, dos, 0);
    grafo.conectar(tres, cuatro, 0);
    grafo.conectar(cuatro, uno, 0);
    grafo.conectar(cuatro, cinco, 0);
    grafo.conectar(seis, cuatro, 0);

    Recorridos<Integer> r = new Recorridos<Integer>();
    ListaGenerica<Integer> bfs = r.bfs(grafo);
    System.out.println("BFS: " + bfs.toString());
  }
}