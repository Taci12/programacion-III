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
    ciudades.conectar(buenosAires, madagascar, 7);
    ciudades.conectar(madagascar, buenosAires, 7);
    ciudades.conectar(santiago, buenosAires, 3);
    ciudades.conectar(buenosAires, lima, 4);
    ciudades.conectar(lima, buenosAires, 4);
    ciudades.conectar(lima, miami, 6);
    ciudades.conectar(santiago, lima, 5);
    ciudades.conectar(santiago, miami, 6);
    ciudades.conectar(miami, nuevaYork, 2);
    ciudades.conectar(miami, madagascar, 7);
    ciudades.conectar(nuevaYork, madagascar, 7);
    ciudades.conectar(nuevaYork, lima, 5);

    Mapa m = new Mapa(ciudades);
    // ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    // camino = m.devolverCamino("Buenos Aires", "Miameee");
    // System.out.println("camino: " + camino.toString());
    // System.out.println("camino2: " + m.devolverCamino("Buenos Aires",
    // "Pluton").toString());
    // ListaGenerica<String> listaEvitar = new ListaGenericaEnlazada<String>();
    // listaEvitar.agregarInicio("Lima");
    // System.out.println(
    // "camino exceptuando Lima: " + m.devolverCaminoExceptuando("Buenos Aires",
    // "Miameee", listaEvitar).toString());
    // ListaGenerica<String> caminoMasCorto = new ListaGenericaEnlazada<String>();
    // caminoMasCorto = m.caminoMasCorto("Buenos Aires", "Madagascar");
    // System.out.println("Camino mas corto de Buenos Aires a Miame: " +
    // caminoMasCorto.toString());
    // ListaGenerica<String> caminoSinCargar = new ListaGenericaEnlazada<String>();
    // caminoSinCargar = m.caminoSinCargarCombustible(ciudades, "Buenos Aires", "New
    // York", 5);
    // System.out.println("Camino sin cargar combustible: " +
    // caminoSinCargar.toString() + "\n");
    ListaGenerica<String> caminoMenosCargas = new ListaGenericaEnlazada<String>();
    caminoMenosCargas = m.caminoConMenorCargaDeCombustible("Buenos Aires", "Madagascar", 10);
    System.out.println("Camino con menos cargas combustible: " + caminoMenosCargas.toString() + "\n");
  }

}