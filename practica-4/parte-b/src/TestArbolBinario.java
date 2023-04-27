public class TestArbolBinario {
  public static void main(String[] args) {
    ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(10);
    ArbolBinario<Integer> arbol2 = new ArbolBinario<Integer>(9);
    ArbolBinario<Integer> arbol3 = new ArbolBinario<Integer>(8);
    ArbolBinario<Integer> arbol4 = new ArbolBinario<Integer>(11);
    ArbolBinario<Integer> arbol5 = new ArbolBinario<Integer>(5);
    ArbolBinario<Integer> arbol6 = new ArbolBinario<Integer>(3);
    ArbolBinario<Integer> arbol7 = new ArbolBinario<Integer>(2);
    ArbolBinario<Integer> arbol8 = new ArbolBinario<Integer>(20);
    ArbolBinario<Integer> arbol9 = new ArbolBinario<Integer>(19);
    ArbolBinario<Integer> arbol10 = new ArbolBinario<Integer>(21);
    arbol.agregarHijoDerecho(arbol2);
    arbol.agregarHijoIzquierdo(arbol3);
    arbol2.agregarHijoIzquierdo(arbol4);
    arbol2.agregarHijoDerecho(arbol5);
    arbol3.agregarHijoDerecho(arbol6);
    arbol3.agregarHijoIzquierdo(arbol7);
    arbol4.agregarHijoDerecho(arbol8);
    arbol6.agregarHijoIzquierdo(arbol9);
    arbol9.agregarHijoDerecho(arbol10);
    arbol.printInorden();

    ListaGenericaEnlazada<Integer> lista = trayectoriaPesada.calcular(arbol);
    System.out.println(lista.toString());
  }
}
