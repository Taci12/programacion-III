package prog3.listaenteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}
	private int buscarMinimo() {
		this.comenzar();
		int actual, minimo = 9999999;
		while (!this.fin()) {
			actual = this.proximo();
			if (actual < minimo) {
				minimo = actual;
			}
		}
		return minimo;
	}
	private int buscarMayorSiguiente(int minimoAnterior) {
		this.comenzar();
		int actual, minimo = 9999999;
		while (!this.fin()) {
			actual = this.proximo();
			if ((actual < minimo) && (actual > minimoAnterior)) {
				minimo = actual;
			}
		}
		return minimo;
	}
	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	public ListaDeEnterosEnlazada ordenar() {
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
		this.comenzar();
		resultado.comenzar();
		int valor, minimoAnterior;
		boolean continua = true;
		valor = this.buscarMinimo();
		resultado.agregarFinal(valor);
		while (resultado.tamanio() != this.tamanio()) {
			minimoAnterior = valor;
			valor = this.buscarMayorSiguiente(minimoAnterior);
			resultado.agregarFinal(valor);
		}
		return resultado;
	}
	public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada lista) {
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
		resultado.comenzar();
		lista.comenzar();
		this.comenzar();
		int actual1 = this.actual.getDato(), actual2 = lista.actual.getDato();
		while ((this.actual.getSiguiente() != null) && (lista.actual.getSiguiente() != null)) {
			if (actual1 < actual2) {
				resultado.agregarFinal(actual1);
				if (this.actual.getSiguiente() != null) {
					this.proximo();
					actual1 = this.actual.getDato();
				}
			} else {
				resultado.agregarFinal(actual2);
				if (lista.actual.getSiguiente() != null) {
					lista.proximo();
					actual2 = lista.actual.getDato();
				}
			}
		}
		return resultado;
	}
	private void copiarDe(ListaDeEnterosEnlazada lista, int principio, int fin) {
		int i;
		for (i = principio; i <= fin; i++) {
			this.agregarFinal(lista.elemento(i));
		}
	}
	private ListaDeEnterosEnlazada recursivoMergeSort(ListaDeEnterosEnlazada lista) {
		if (lista.tamanio() <= 1) {
			return lista;
		}
		else {
			ListaDeEnterosEnlazada izquierda = new ListaDeEnterosEnlazada();
			ListaDeEnterosEnlazada derecha = new ListaDeEnterosEnlazada();
			izquierda.comenzar(); derecha.comenzar();
			int medio = lista.tamanio() / 2;

			izquierda.copiarDe(lista, 0, medio);
			derecha.copiarDe(lista, medio + 1, lista.tamanio());
			recursivoMergeSort(izquierda);
			recursivoMergeSort(derecha);
			return izquierda.combinarOrdenado(derecha);
		}
	}
	public ListaDeEnterosEnlazada mergeSort() {
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
		resultado.comenzar();
		resultado = recursivoMergeSort(this);
		return resultado;
	}
}
