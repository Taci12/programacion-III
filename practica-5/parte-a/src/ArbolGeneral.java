public class ArbolGeneral<T> {
  private T dato;

  private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

  public T getDato() {
    return dato;
  }

  public void setDato(T dato) {
    this.dato = dato;
  }

  public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
    this.hijos = hijos;
  }

  public ArbolGeneral(T dato) {
    this.dato = dato;
    this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
  }

  public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
    this(dato);
    this.hijos = hijos;
  }

  public ListaGenerica<ArbolGeneral<T>> getHijos() {
    return this.hijos;
  }

  public void agregarHijo(ArbolGeneral<T> unHijo) {

    this.getHijos().agregarFinal(unHijo);
  }

  public boolean esHoja() {

    return !this.tieneHijos();
  }

  public boolean tieneHijos() {
    return this.hijos != null && !this.hijos.esVacia();
  }

  public boolean esVacio() {

    return this.dato == null && !this.tieneHijos();
  }

  public void eliminarHijo(ArbolGeneral<T> hijo) {
    if (this.tieneHijos()) {
      ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
      if (hijos.incluye(hijo))
        hijos.eliminar(hijo);
    }
  }

  public void enOrden() {
    if (!(this.esVacio() || this.esHoja())) {
      ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
      hijos.comenzar();

      while (!(hijos.fin())) {
        ArbolGeneral<T> hijo = hijos.proximo();
        hijo.enOrden();
        System.out.println(hijo.getDato());
      }
    }

  }

  public ListaGenericaEnlazada<T> preOrden() {
    return null;
  }

  public boolean include(T dato) {
    if (!(this.esVacio() || this.esHoja())) {
      ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
      hijos.comenzar();

      while (!(hijos.fin())) {
        ArbolGeneral<T> hijo = hijos.proximo();
        if (hijo.getDato().equals(dato))
          return true;
        else if (!(hijo.esHoja()))
          hijo.include(dato);
      }
    }
    return false;
  }

  // guardar el hijo en variable
  // lista siempre con comenzar, !fin() y proximo
  public Integer altura() {
    int altura = 0;

    if (this.esVacio() || this.esHoja())
      return altura;
    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
    hijos.comenzar();

    while (!(hijos.fin())) {
      // el primero de la lista es vacio
      ArbolGeneral<T> hijo = hijos.proximo();
      int alturaHijo = hijo.altura();

      if (alturaHijo + 1 > altura)
        altura = alturaHijo + 1;
    }
    return altura;
  }

  public Integer nivel(T dato) {
    int nivel = 0;
    return nivelRecursivo(dato, nivel);
  }

  public Integer nivelRecursivo(T dato, int nivel) {
    if (this.getDato().equals(dato)) {
      return nivel;
    }
    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
    hijos.comenzar();
    while (!(hijos.fin())) {
      ArbolGeneral<T> hijo = hijos.proximo();
      return hijo.nivelRecursivo(dato, nivel + 1);
    }
    return nivel;
  }

  // ! Preguntar ancho()
  public Integer ancho() {
    if (this.esVacio()) {
      return 0;
    }

    ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
    ArbolGeneral<T> arbol = this;
    ListaGenerica<ArbolGeneral<T>> hijos;
    int anchoNivel = 1;
    int anchoMax = 0;

    cola.encolar(this);
    cola.encolar(null);

    while (!(cola.esVacia())) {
      arbol = cola.desencolar();
      // me fijo si el nivel llego a su fin
      if (arbol == null) {
        // si llego, me fijo si es maximo y reinicio contador
        if (anchoNivel > anchoMax) {
          anchoMax = anchoNivel;
        }
        // para no encolar dos null seguidos
        if (!cola.esVacia()) {
          cola.encolar(null);
        }
        anchoNivel = 0;
      }
      // si no llegue al final del nivel
      else {
        anchoNivel++;
        hijos = arbol.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
          cola.encolar(hijos.proximo());
        }
      }
    }
    return anchoMax;
  }

}