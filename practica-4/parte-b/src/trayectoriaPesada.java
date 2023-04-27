public class trayectoriaPesada {

  public static ListaGenericaEnlazada<Integer> calcular(ArbolBinario<Integer> arbol) {
    ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
    lista.comenzar();
    if (!(arbol == null)) {
      calcularRecursivo(arbol, lista, 0, 0);
    }
    return lista;
  }

  public static void calcularRecursivo(ArbolBinario<Integer> arbol, ListaGenericaEnlazada<Integer> lista, int suma,
      int nivel) {
    suma += (nivel * arbol.getDato());
    if (arbol.esHoja()) {
      lista.agregarFinal(suma);
    } else {
      if (arbol.tieneHijoIzquierdo())
        calcularRecursivo(arbol.getHijoIzquierdo(), lista, suma, nivel + 1);
      if (arbol.tieneHijoDerecho())
        calcularRecursivo(arbol.getHijoDerecho(), lista, suma, nivel + 1);
    }
  }
}
