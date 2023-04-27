public class Adivinanza {
  private ArbolBinario<String> adivinanza;

  public ArbolBinario<String> getAdivinanza() {
    return adivinanza;
  }

  public void setAdivinanza(ArbolBinario<String> adivinanza) {
    this.adivinanza = adivinanza;
  }

  public Adivinanza(ArbolBinario<String> adivinanza) {
    this.adivinanza = adivinanza;
  }

  public Adivinanza() {
  }

  public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> arbol) {
    ListaGenericaEnlazada<String> auxiliar = new ListaGenericaEnlazada<String>();
    ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();

    if (arbol.tieneHijoIzquierdo()) {
      auxiliar = secuenciaConMasPreguntas(arbol.getHijoIzquierdo());
      if (auxiliar.tamanio() > result.tamanio())
        result = auxiliar;
    }
    if (arbol.tieneHijoDerecho()) {
      auxiliar = secuenciaConMasPreguntas(arbol.getHijoDerecho());
      if (auxiliar.tamanio() > result.tamanio())
        result = auxiliar;
    }

    result.agregarFinal(arbol.getDato());
    return result;
  }

  public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(
      ArbolBinario<String> arbol) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> aux = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();

    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> nueva = new ListaGenericaEnlazada<String>();
      nueva.agregarFinal(arbol.getDato());
      result.comenzar();
      result.agregarFinal(nueva);
    } else {
      if (arbol.tieneHijoIzquierdo()) {
        // llamado recursivo
        aux = secuenciaConMasPreguntasVersion2(arbol.getHijoIzquierdo());
        System.out.println(aux.elemento(0).tamanio());
        // ! RESULT QUEDA EN NULL, PREGUNTAR EN CLASE
        if (aux.elemento(0).tamanio() > result.elemento(0).tamanio()) {
          // elimino las listas de result
          while (!result.esVacia())
            result.eliminarEn(0);
          // copio las listas de aux a result
          aux.comenzar();
          while (!aux.fin())
            result.agregarFinal(aux.proximo());
        }

        else if (aux.elemento(0).tamanio() == result.elemento(0).tamanio()) {
          // si son iguales de tamaño, copio las listas de aux al final de result
          aux.comenzar();
          while (!aux.fin())
            result.agregarFinal(aux.proximo());
        }
      }
      // hago el mismo procedimiento para el hijo derecho
      if (arbol.tieneHijoDerecho()) {
        aux = secuenciaConMasPreguntasVersion2(arbol.getHijoDerecho());
        System.out.println(aux.elemento(0).tamanio());
        if (aux.elemento(0).tamanio() > result.elemento(0).tamanio()) {
          while (!result.esVacia())
            result.eliminarEn(0);
          aux.comenzar();
          while (!aux.fin())
            result.agregarFinal(aux.proximo());
        }

        else if (aux.elemento(0).tamanio() == result.elemento(0).tamanio()) {
          aux.comenzar();
          while (!aux.fin())
            result.agregarFinal(aux.proximo());
        }
      }
      // cuando no sea hoja, agrego a las listas de result el dato actual
      // result en el llamado recursivo es asignado a aux
      result.comenzar();
      while (!result.fin())
        result.proximo().agregarFinal(arbol.getDato());
    }
    return result;
  }
}
