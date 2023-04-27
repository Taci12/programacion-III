public class Trie {
  private ArbolGeneral<Character> arbol;

  public ArbolGeneral<Character> getArbol() {
    return arbol;
  }

  public void setArbol(ArbolGeneral<Character> arbol) {
    this.arbol = arbol;
  }

  public Trie() {
  }

  public Trie(ArbolGeneral<Character> arbol) {
    this.arbol = arbol;
  }

  public void agregarPalabra(String palabra) {
    int i = 0;
    agregarPalabraRecursivo(palabra, this.arbol, i);
  }

  private void agregarPalabraRecursivo(String palabra, ArbolGeneral<Character> arbol, int i) {
    if (!arbol.esVacio()) {
      boolean esHijo = false;
      // hago el recorrido siempre mirando a los hijos del nodo donde estoy parado
      if (arbol.tieneHijos()) {
        ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
        hijos.comenzar();
        ArbolGeneral<Character> hijo;
        // me fijo si la letra es hijo del nodo donde estoy parado
        while (!(hijos.fin() || esHijo)) {
          hijo = hijos.proximo();
          // si es, recorro por esa rama
          if (hijo.getDato() == palabra.charAt(i)) {
            agregarPalabraRecursivo(palabra, hijo, i + 1);
            esHijo = true;
          }
        }
      }
      // sino, hago una rama que contenga la letra
      if (!esHijo) {
        ArbolGeneral<Character> nuevoHijo = new ArbolGeneral<Character>(palabra.charAt(i),
            new ListaGenericaEnlazada<ArbolGeneral<Character>>());
        // si no tiene hijos, agrego
        if (!arbol.tieneHijos()) {
          arbol.agregarHijo(nuevoHijo);
        }
        // si tiene hijos, me fijo en que lugar va la letra a agregar
        // (tienen que esta en orden alfabetico)
        else {
          int posicion = obtenerPosicion(arbol.getHijos(), palabra.charAt(i));
          if (posicion != -1)
            arbol.getHijos().agregarEn(nuevoHijo, posicion);
          else
            arbol.getHijos().agregarFinal(nuevoHijo);
        }
        // antes de llamar de nuevo me fijo si llegue al final de la palabra a agregar
        if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1))
          agregarPalabraRecursivo(palabra, nuevoHijo, ++i);
      }

    }
  }

  private int obtenerPosicion(ListaGenerica<ArbolGeneral<Character>> lista, Character caracter) {
    int posicion = 0;
    // mientras que la posicion no se pase del maximo
    // y mientras el caracter sea mayor al almacenado en la lista, recorro
    while ((posicion < lista.tamanio()) && (caracter.compareTo(lista.elemento(posicion).getDato()) == -1)) {
      posicion++;
    }
    // si hay que agregar al final, retorno -1
    if (posicion == (lista.tamanio()))
      return -1;

    return posicion;
  }

  public ListaGenerica<String> palabrasQueEmpiezanCon(String prefijo) {
    ListaGenericaEnlazada<String> lista = new ListaGenericaEnlazada<String>();
    ArbolGeneral<Character> nodoPrefijo = nodoDelPrefijo(prefijo, 0, this.arbol);
    String stringActual = " ";
    llenarListaDePalabras(lista, nodoPrefijo, stringActual);
    lista.eliminarEn(0); // elimino la posicion donde me queda el ultimo caracter del prefijo
    int i;
    int size = lista.tamanio();
    // agrego al principio de todos los elementos de la lista el prefijo
    for (i = 0; i < size - 1; i++)
      lista.agregarFinal(prefijo.concat(lista.elemento(i)));
    for (i = 0; i < size - 1; i++)
      lista.eliminarEn(i);
    return lista;
  }

  // agarro raiz
  // si tiene hijos, me fijo si alguno coincide con el primero del prefijo
  // si alguno coincide, sigo por esa rama
  // hago el mismo proceso, hasta que complete el prefijo
  // cuando complete el prefijo, empiezo a recorrer agregando a la lista
  // agrego hasta que termine el arbol

  // para encontrar el nodo donde termina el prefijo
  // a partir del nodo resultado, agrego en la lista de posibles palabras
  private ArbolGeneral<Character> nodoDelPrefijo(String prefijo, int i, ArbolGeneral<Character> arbol) {
    Character caracterActual = prefijo.charAt(i);
    ArbolGeneral<Character> hijo = null;
    if (arbol.tieneHijos()) {
      ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
      hijos.comenzar();
      while (!hijos.fin()) {
        hijo = hijos.proximo();
        if (caracterActual.compareTo(hijo.getDato()) == 0) {
          // si es el ultimo caracter
          if (i == (prefijo.length() - 1))
            return hijo;
          // sino, me fijo si los caracteres siguen coincidiendo
          else
            return nodoDelPrefijo(prefijo, i + 1, hijo);
        }
      }
    }
    return hijo;
  }

  // si el arbol no es vacio,
  // hago una nueva string, y la igualo a la stringActual + caracterActual.
  // lo agrego al final de la lista
  // si tiene hijos, paso la string local como parametro
  // hago llamado recursivo

  private void llenarListaDePalabras(ListaGenericaEnlazada<String> lista, ArbolGeneral<Character> arbol,
      String stringActual) {
    if (!arbol.esVacio()) {
      String local = stringActual + arbol.getDato();
      lista.agregarFinal(local);
      if (arbol.tieneHijos()) {
        ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
        ArbolGeneral<Character> hijo;
        hijos.comenzar();
        while (!hijos.fin()) {
          hijo = hijos.proximo();
          llenarListaDePalabras(lista, hijo, local);
        }
      }
    }
  }
}
// tamanio = 3, posicion 0, 1, 2
// si posicion == 3, agregar al final