public class sumaMaximaVertical {
  // funciona!!!!
  public static int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
    return sumaMaximaVerticalRecursivo(arbol);
  }

  private static int sumaMaximaVerticalRecursivo(ArbolBinario<Integer> arbol) {
    if (arbol == null) {
      return 0;
    } else {
      int suma_izquierda = sumaMaximaVerticalRecursivo(arbol.getHijoIzquierdo());
      int suma_derecha = sumaMaximaVerticalRecursivo(arbol.getHijoDerecho());
      if (suma_derecha > suma_izquierda) {
        return suma_derecha + arbol.getDato();
      } else {
        return suma_izquierda + arbol.getDato();
      }
    }
  }
}
