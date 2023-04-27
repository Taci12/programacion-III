public class TestTrie {
  public static void main(String[] args) {
    Trie arbol = new Trie(new ArbolGeneral<Character>('R', new ListaGenericaEnlazada<ArbolGeneral<Character>>()));
    arbol.agregarPalabra("taxi");
    arbol.agregarPalabra("taci");
    System.out.println(arbol.getArbol().preOrden().toString());
    arbol.agregarPalabra("taai");
    System.out.println(arbol.getArbol().preOrden().toString());
    arbol.agregarPalabra("taco");
    System.out.println(arbol.getArbol().preOrden().toString());
    arbol.agregarPalabra("taza");
    System.out.println(arbol.getArbol().preOrden().toString());
    arbol.agregarPalabra("maxi");
    System.out.println(arbol.getArbol().preOrden().toString());
    ListaGenerica<String> resultado = arbol.palabrasQueEmpiezanCon("tac");
    System.out.println(resultado.toString());
  }
}
