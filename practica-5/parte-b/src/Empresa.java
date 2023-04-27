public class Empresa {

  private ArbolGeneral<Empleado> empleados;

  public Empresa() {
  }

  public Empresa(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  public ArbolGeneral<Empleado> getEmpleados() {
    return empleados;
  }

  public void setEmpleados(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  private int porCategoriaRecursivo(int categoria, ArbolGeneral<Empleado> arbol) {
    int cantidad = 0;
    if (!(arbol.esVacio())) {

      if (arbol.getDato().getCategoria() == categoria) {
        cantidad++;
      }
      ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol.getHijos();
      hijos.comenzar();
      while (!(hijos.fin())) {
        ArbolGeneral<Empleado> hijo = hijos.proximo();
        cantidad += porCategoriaRecursivo(categoria, hijo);
      }
    }
    return cantidad;
  }

  public int empleadosPorCategoria(int categoria) {
    ArbolGeneral<Empleado> arbol = this.getEmpleados();
    return porCategoriaRecursivo(categoria, arbol);
  }

  public int categoriaConMasEmpleados() {
    int actual;
    int max = -1;
    int maxCategoria = 0;
    for (int i = 1; i <= 4; i++) {
      actual = empleadosPorCategoria(i);
      if (actual > max) {
        max = actual;
        maxCategoria = i;
      }
    }
    return maxCategoria;
  }

  private int cantidadTotalDeEmpleadosRecursivo(ArbolGeneral<Empleado> arbol) {
    int cantidad = 0;
    if (!arbol.esVacio()) {
      cantidad++;
      ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol.getHijos();
      hijos.comenzar();
      while (!hijos.fin()) {
        ArbolGeneral<Empleado> hijo = hijos.proximo();
        cantidad += cantidadTotalDeEmpleadosRecursivo(hijo);
      }
    }
    return cantidad;
  }

  public int cantidadTotalDeEmpleados() {
    ArbolGeneral<Empleado> arbol = this.getEmpleados();
    return cantidadTotalDeEmpleadosRecursivo(arbol);
  }

  // empleadoMasAntiguo y empleadoMasAntiguoRecursivo.
  // public void reemplazarPresidente() {
  // Empleado masAntiguo = this.empleadoMasAntiguo();
  // System.out.println(masAntiguo.toString());
  // ArbolGeneral<Empleado> nuevoPresidente = new
  // ArbolGeneral<Empleado>(masAntiguo);
  // ArbolGeneral<Empleado> viejoPresidente = this.getEmpleados();
  // nuevoPresidente.setHijos(viejoPresidente.getHijos());
  // nuevoPresidente.setDato(masAntiguo);
  // viejoPresidente.setHijos(null);
  // this.setEmpleados(nuevoPresidente);
  // System.out.println(nuevoPresidente.getDato().toString());
  // }

  // private Empleado empleadoMasAntiguo() {
  // int maximaAntiguedad = 0;
  // Empleado masAntiguo = empleadoMasAntiguoRecursivo(this.getEmpleados(),
  // maximaAntiguedad);
  // System.out.println(masAntiguo == null);
  // return masAntiguo;
  // }

  // private Empleado empleadoMasAntiguoRecursivo(ArbolGeneral<Empleado> arbol,
  // int maximaAntiguedad) {
  // Empleado masAntiguo = null;
  // if (!arbol.esVacio()) {
  // int antiguedadActual = arbol.getDato().getAntiguedad();
  // if (antiguedadActual > maximaAntiguedad) {
  // maximaAntiguedad = antiguedadActual;
  // masAntiguo = arbol.getDato();
  // }
  // ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol.getHijos();
  // hijos.comenzar();
  // while (!hijos.fin()) {
  // ArbolGeneral<Empleado> hijo = hijos.proximo();
  // empleadoMasAntiguoRecursivo(hijo, maximaAntiguedad);
  // }
  // }
  // return masAntiguo;
  // }

  public void reemplazarPresidente() {
    ArbolGeneral<Empleado> arbol = this.getEmpleados();
    Empleado masAntiguo = null;
    reemplazarPresidenteRecursivo(arbol, masAntiguo);
  }

  public void reemplazarPresidenteRecursivo(ArbolGeneral<Empleado> arbol, Empleado masAntiguo) {
    if (!(arbol.esVacio())) {
      if (!arbol.esHoja()) {
        ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
          ArbolGeneral<Empleado> hijo = hijos.proximo();
          if (hijo.getDato().getAntiguedad() > masAntiguo.getAntiguedad()) {
            masAntiguo = hijo.getDato();
          }
          reemplazarPresidenteRecursivo(hijo, masAntiguo);
        }
      } else {

      }
    }
  }

}
