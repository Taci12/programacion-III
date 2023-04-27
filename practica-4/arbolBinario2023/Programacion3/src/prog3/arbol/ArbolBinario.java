package prog3.arbol;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	// imprime el arbol en preorden
	public void printPreorden() {
		System.out.println(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printInorden(ArbolBinario<T> arbol) {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		System.out.println(this.getDato());
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
		System.out.println(this.getDato());
	}

	public void recorridoPorNiveles() {

	}

	private void fronteraRecursivo(ListaGenericaEnlazada<T> lista) {
		if (!(this.tieneHijoIzquierdo() && this.tieneHijoDerecho())) {
			lista.agregarFinal(this.getDato());
		}
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().fronteraRecursivo(lista);
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().fronteraRecursivo(lista);
		}
	}

	public ListaGenericaEnlazada<T> frontera() {
		ListaGenericaEnlazada<T> l = new ListaGenericaEnlazada<T>();
		this.fronteraRecursivo(l);
		return l;
	}

	public int contarHojas() {
		int contador = 0;
		contador = this.contarHojasRecursivo();
		return contador;
	}

	private int contarHojasRecursivo() {
		int contador = 0;
		if (!(this.tieneHijoIzquierdo() && this.tieneHijoDerecho())) {
			return 1;
		}
		if (this.tieneHijoIzquierdo()) {
			contador = this.getHijoIzquierdo().contarHojasRecursivo();
		}
		if (this.tieneHijoDerecho()) {
			contador += this.getHijoDerecho().contarHojasRecursivo();
		}
		return contador;
	}

	public boolean esLleno() {
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		ArbolBinario<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		int cantidadNodos = 0, nivel = 0;
		boolean lleno = true;

		while (!cola.esVacia() && lleno) {

			if (arbol != null) {
				System.out.println(arbol.getDato());

				if (!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cantidadNodos++;
				}

				if (!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
					cantidadNodos++;
				}
			}

			else if (!cola.esVacia()) {

				if (cantidadNodos == Math.pow(2, nivel)) {
					cola.encolar(null);
					cantidadNodos = 0;
					System.out.println();
				}

				else {
					lleno = false;
				}
			}
		}
		return lleno;
	}

	public boolean esCompleto() {

	}

}
