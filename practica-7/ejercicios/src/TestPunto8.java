public class TestPunto8 {
  public static void main(String[] args) {
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> muelle = new VerticeImplListAdy<String>("Muelle principal");
    Vertice<String> isla1 = new VerticeImplListAdy<String>("isla1");
    Vertice<String> isla2 = new VerticeImplListAdy<String>("isla2");
    Vertice<String> isla3 = new VerticeImplListAdy<String>("isla3");
    Vertice<String> isla4 = new VerticeImplListAdy<String>("isla4");
    Vertice<String> isla5 = new VerticeImplListAdy<String>("isla5");
    Vertice<String> isla6 = new VerticeImplListAdy<String>("isla6");

    grafo.agregarVertice(muelle);
    grafo.agregarVertice(isla1);
    grafo.agregarVertice(isla2);
    grafo.agregarVertice(isla3);
    grafo.agregarVertice(isla4);
    grafo.agregarVertice(isla5);
    grafo.agregarVertice(isla6);

    grafo.conectar(muelle, isla1, 2);
    grafo.conectar(isla1, muelle, 2);

    grafo.conectar(muelle, isla2, 4);
    grafo.conectar(isla2, muelle, 4);

    grafo.conectar(muelle, isla5, 1);
    grafo.conectar(isla5, muelle, 1);

    grafo.conectar(isla3, isla1, 3);
    grafo.conectar(isla1, isla3, 3);

    grafo.conectar(isla4, isla2, 2);
    grafo.conectar(isla2, isla4, 2);

    grafo.conectar(isla4, isla6, 5);
    grafo.conectar(isla6, isla4, 5);

    Delta delta = new Delta();
    delta.setGrafo(grafo);

    // int resultado = delta.maxIslasDistintas(grafo);
    // System.out.println("La cantidad de islas distintas es " + resultado);
    RutaMinima ruta = delta.caminoMasCorto(grafo, "isla3", "isla6");
    System.out.println("El camino minimo es " + ruta.getCamino().toString());
    if (ruta.isUnicoBoleto())
      System.out.println("Hay que comprar un unico boleto");
    else
      System.out.println("Hay que comprar mas de un boleto");

  }
}