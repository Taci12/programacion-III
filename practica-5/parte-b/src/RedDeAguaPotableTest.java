public class RedDeAguaPotableTest {
  public static void main(String[] args) {
    ArbolGeneral<Float> arbol = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol2 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol3 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol4 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol5 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol6 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol7 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol8 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol9 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol10 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol11 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol12 = new ArbolGeneral<Float>(0f);
    ArbolGeneral<Float> arbol13 = new ArbolGeneral<Float>(0f);

    arbol.agregarHijo(arbol13);
    arbol.agregarHijo(arbol12);
    arbol.agregarHijo(arbol11);

    arbol13.agregarHijo(arbol10);
    arbol13.agregarHijo(arbol9);
    arbol12.agregarHijo(arbol8);
    arbol11.agregarHijo(arbol7);
    arbol11.agregarHijo(arbol6);
    arbol11.agregarHijo(arbol5);

    arbol5.agregarHijo(arbol4);
    arbol5.agregarHijo(arbol3);
    arbol7.agregarHijo(arbol2);

    RedDeAguaPotable red = new RedDeAguaPotable(arbol);
    Float resultado = red.minimoCaudal(arbol, 1000f);
    System.out.println(resultado);
    red.getConfiguracion().enOrden();
  }
}
