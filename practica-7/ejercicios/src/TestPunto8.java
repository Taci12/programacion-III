public class TestPunto8 {
  public static void main(String[] args) {
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> muelle = new VerticeImplListAdy<String>("Muelle principal");
    Vertice<String> isla1 = new VerticeImplListAdy<String>("isla1");
    Vertice<String> isla2 = new VerticeImplListAdy<String>("isla2");
    Vertice<String> isla3 = new VerticeImplListAdy<String>("isla3");
    Vertice<String> isla4 = new VerticeImplListAdy<String>("isla4");
    Vertice<String> isla5 = new VerticeImplListAdy<String>("isla5");

    grafo.agregarVertice(muelle);
    grafo.agregarVertice(isla1);
    grafo.agregarVertice(isla2);
    grafo.agregarVertice(isla3);
    grafo.agregarVertice(isla4);
    grafo.agregarVertice(isla5);

    grafo.conectar(muelle, isla1, 0);
    grafo.conectar(isla1, muelle, 0);

    grafo.conectar(muelle, isla2, 0);
    grafo.conectar(isla2, muelle, 0);

    grafo.conectar(muelle, isla5, 0);
    grafo.conectar(isla5, muelle, 0);

    grafo.conectar(isla1, isla2, 0);
    grafo.conectar(isla2, isla1, 0);

    grafo.conectar(isla3, isla1, 0);
    grafo.conectar(isla1, isla3, 0);

    grafo.conectar(isla4, isla2, 0);
    grafo.conectar(isla2, isla4, 0);

    Delta delta = new Delta();
    delta.setGrafo(grafo);

    int resultado = delta.maxIslasDistintas(grafo);
    System.out.println("La cantidad de islas distintas es " + resultado);

  }
}