package prog3.listaenteros;

public class ListaDeEnterosEnlazadaTestBasico {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        lista.comenzar();
        int i;
        for (i = 15; i > 0; i--) {
            lista.agregarFinal(i);
        }
        ListaDeEnterosEnlazada listaOrdenada = lista.mergeSort();
    }
    public static void generarLista(ListaDeEnteros lista) {
        int i;
        lista.comenzar();
        for (i = 9; i > 0; i--) {
            lista.agregarFinal(i);
        }
    }
    private static void anidadoImrimirInverso(ListaDeEnteros lista) {
        if (!lista.fin()) {
            int aux = lista.proximo();
            anidadoImrimirInverso(lista);
            System.out.println(aux);
        }
    }
    public static void imprimirInverso(ListaDeEnteros lista) {
        lista.comenzar();
        anidadoImrimirInverso(lista);
    }
}
