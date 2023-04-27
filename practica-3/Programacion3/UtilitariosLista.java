package prog3.util;
public class UtilitariosLista {
    public static mergeSort(ListaDeEnterosEnlazada lista, int principio, int fin) {
        if (principio < fin) {
            int medio = Math.floor((principio + fin) / 2);
            mergeSort(lista, medio + 1, fin);
            mergeSort(lista, principio, medio);

        }
    }
}
