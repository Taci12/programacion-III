public class TestArbolGeneral {
  public static void main(String[] args) {

    ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(40);
    ArbolGeneral<Integer> arbol2 = new ArbolGeneral<Integer>(2);
    ArbolGeneral<Integer> arbol3 = new ArbolGeneral<Integer>(3);
    ArbolGeneral<Integer> arbol4 = new ArbolGeneral<Integer>(4);
    ArbolGeneral<Integer> arbol5 = new ArbolGeneral<Integer>(5);
    ArbolGeneral<Integer> arbol6 = new ArbolGeneral<Integer>(6);
    ArbolGeneral<Integer> arbol7 = new ArbolGeneral<Integer>(7);
    ArbolGeneral<Integer> arbol8 = new ArbolGeneral<Integer>(8);
    ArbolGeneral<Integer> arbol9 = new ArbolGeneral<Integer>(9);
    ArbolGeneral<Integer> arbol10 = new ArbolGeneral<Integer>(10);
    ArbolGeneral<Integer> arbol11 = new ArbolGeneral<Integer>(11);
    ArbolGeneral<Integer> arbol12 = new ArbolGeneral<Integer>(12);
    ArbolGeneral<Integer> arbol13 = new ArbolGeneral<Integer>(13);

    arbol.agregarHijo(arbol2);
    arbol.agregarHijo(arbol3);
    arbol.agregarHijo(arbol4);
    arbol3.agregarHijo(arbol5);
    arbol2.agregarHijo(arbol6);
    arbol6.agregarHijo(arbol7);
    arbol6.agregarHijo(arbol8);
    arbol4.agregarHijo(arbol9);
    arbol7.agregarHijo(arbol10);
    arbol10.agregarHijo(arbol11);
    arbol7.agregarHijo(arbol12);
    arbol11.agregarHijo(arbol13);
    // arbol
    // 40
    // 2 3 4
    // 6 9
    // 7 8 5
    // 10 12
    // 11

    // System.out.println(arbol.altura());
    // System.out.println(arbol.include(4));
    // System.out.println(arbol.nivel(11));
    // arbol.enOrden();
    System.out.println(arbol.ancho());

  }

}
