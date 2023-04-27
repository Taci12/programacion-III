package prog3.listagenerica;
//La lista generica contiene al wrapper o al primitivo?
public class test {
    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
        generarListaDeEnteros(lista);
        System.out.println("Lista al inicio:\n" + lista.toString());
        ListaGenericaEnlazada<Integer> listaInvertida = new ListaGenericaEnlazada<Integer>();
        listaInvertida = lista.invertir();
        System.out.println("\nLista invertida:\n" + listaInvertida.toString());
    }
    public static void generarListaDeEnteros(ListaGenericaEnlazada<Integer> lista) {
        int i;
        for (i = 0; i < 9; i++) {
            lista.agregarInicio((int) (Math.floor(Math. random()*50)));
        }
    }
}
