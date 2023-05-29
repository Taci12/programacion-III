public class testMapa {
  public static void main(String[] args) {
    Vertice<String> buenosAires = new VerticeImplListAdy<String>("Buenos Aires");
    Vertice<String> santiago = new VerticeImplListAdy<String>("Santiago");
    Vertice<String> lima = new VerticeImplListAdy<String>("Lima");
    Vertice<String> londres = new VerticeImplListAdy<String>("London");
    Vertice<String> nuevaYork = new VerticeImplListAdy<String>("New York");
    Vertice<String> madagascar = new VerticeImplListAdy<String>("Madagascar");
    Vertice<String> miami = new VerticeImplListAdy<String>("Miameee");

    Grafo<String> ciudades = new GrafoImplListAdy<String>();
    ciudades.agregarVertice(buenosAires);
    ciudades.agregarVertice(santiago);
    ciudades.agregarVertice(lima);
    ciudades.agregarVertice(londres);
    ciudades.agregarVertice(nuevaYork);
    ciudades.agregarVertice(madagascar);
    ciudades.agregarVertice(miami);

    ciudades.conectar(buenosAires, santiago, 3);
    ciudades.conectar(buenosAires, lima, 2);
    ciudades.conectar(lima, miami, 2);
    ciudades.conectar(santiago, lima, 1);
    ciudades.conectar(miami, nuevaYork, 0);
    ciudades.conectar(nuevaYork, madagascar, 1);
    ciudades.conectar(miami, madagascar, 0);

    ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    Mapa m = new Mapa(ciudades);
    camino = m.devolverCamino("Buenos Aires", "Miameee");
    System.out.println("camino: " + camino.toString());
  }
}