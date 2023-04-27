public class TestEmpresa {
  public static void main(String[] args) {
    Empresa empresa = new Empresa(null);
    Empleado jose = new Empleado("Jose", 15, 2);
    Empleado juan = new Empleado("Juan", 11, 2);
    Empleado marcos = new Empleado("Marcos", 7, 2);
    Empleado pipo = new Empleado("Pipo", 3, 3);
    Empleado pepe = new Empleado("Pepe", 2, 4);
    Empleado coscu = new Empleado("Coscu", 20, 4);
    Empleado alberto = new Empleado("Alberto", 20, 1);

    ArbolGeneral<Empleado> arbolito = new ArbolGeneral<Empleado>(alberto);
    ArbolGeneral<Empleado> arbolitoJose = new ArbolGeneral<Empleado>(jose);
    arbolito.agregarHijo(arbolitoJose);
    ArbolGeneral<Empleado> arbolitoJuan = new ArbolGeneral<Empleado>(juan);
    arbolito.agregarHijo(arbolitoJuan);
    ArbolGeneral<Empleado> arbolitoMarcos = new ArbolGeneral<Empleado>(marcos);
    arbolito.agregarHijo(arbolitoMarcos);
    ArbolGeneral<Empleado> arbolitoPipo = new ArbolGeneral<Empleado>(pipo);
    arbolitoJuan.agregarHijo(arbolitoPipo);
    ArbolGeneral<Empleado> arbolitoPepe = new ArbolGeneral<Empleado>(pepe);
    arbolitoJose.agregarHijo(arbolitoPepe);
    ArbolGeneral<Empleado> arbolitoCoscu = new ArbolGeneral<Empleado>(coscu);
    arbolitoPipo.agregarHijo(arbolitoCoscu);
    empresa.setEmpleados(arbolito);

    empresa.getEmpleados().enOrden();
    System.out.println("empleados en categoria 4: " + empresa.empleadosPorCategoria(4));
    System.out.println("Categoria con mas empleados: " + empresa.categoriaConMasEmpleados());
    System.out.println("Cantidad total de empleados: " + empresa.cantidadTotalDeEmpleados());
    empresa.reemplazarPresidente();

  }
}
