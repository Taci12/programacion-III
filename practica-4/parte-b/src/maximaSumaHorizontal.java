public class maximaSumaHorizontal {
  public static int hacerSuma(ArbolBinario<Integer> original) {
    if (original.esVacio()) {
      return 0;
    }
    ArbolBinario<Integer> arbol = original;
    ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
    cola.encolar(arbol);
    cola.encolar(null);
    int maxSuma = 0, suma = 0;
    while (!cola.esVacia()) {
      arbol = cola.desencolar();
      if (arbol != null) {
        suma += arbol.getDato();
        if (arbol.tieneHijoIzquierdo()) {
          cola.encolar(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()) {
          cola.encolar(arbol.getHijoDerecho());
        }
      } else {
        if (suma > maxSuma) {
          maxSuma = suma;
        }
        suma = 0;
        if (!cola.esVacia()) {
          cola.encolar(null);
        }
      }
    }
    return maxSuma;
  }
}
