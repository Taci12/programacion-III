public class TestPunto9 {
  public static void main(String[] args) {
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> laPlata = new VerticeImplListAdy<String>("La Plata");
    Vertice<String> hernandez = new VerticeImplListAdy<String>("Hernandez");
    Vertice<String> gonnet = new VerticeImplListAdy<String>("Gonnet");
    Vertice<String> cityBell = new VerticeImplListAdy<String>("City Bell");
    Vertice<String> losHornos = new VerticeImplListAdy<String>("Los Hornos");
    Vertice<String> gorina = new VerticeImplListAdy<String>("Gorina");
    Vertice<String> villaElisa = new VerticeImplListAdy<String>("Villa Elisa");

    grafo.agregarVertice(villaElisa);
    grafo.agregarVertice(gorina);
    grafo.agregarVertice(losHornos);
    grafo.agregarVertice(cityBell);
    grafo.agregarVertice(gonnet);
    grafo.agregarVertice(hernandez);
    grafo.agregarVertice(laPlata);

    grafo.conectar(laPlata, hernandez, 20);
    grafo.conectar(hernandez, laPlata, 20);

    grafo.conectar(laPlata, gonnet, 40);
    grafo.conectar(gonnet, laPlata, 40);

    grafo.conectar(hernandez, losHornos, 15);
    grafo.conectar(losHornos, hernandez, 15);

    grafo.conectar(hernandez, gorina, 15);
    grafo.conectar(gorina, hernandez, 15);

    grafo.conectar(gonnet, gorina, 20);
    grafo.conectar(gorina, gonnet, 20);

    grafo.conectar(gonnet, cityBell, 35);
    grafo.conectar(cityBell, gonnet, 35);

    grafo.conectar(gorina, cityBell, 25);
    grafo.conectar(cityBell, gorina, 25);

    grafo.conectar(losHornos, villaElisa, 25);
    grafo.conectar(villaElisa, losHornos, 25);

    grafo.conectar(gorina, villaElisa, 30);
    grafo.conectar(villaElisa, gorina, 30);

    grafo.conectar(cityBell, villaElisa, 30);
    grafo.conectar(villaElisa, cityBell, 30);

    GuiaDeTurismo g = new GuiaDeTurismo();
    ListaGenerica<String> camino = g.caminoConMenorNrodeViajes(grafo, "La Plata", "Villa Elisa");
    System.out.println("El camino es: " + camino.toString());
  }
}