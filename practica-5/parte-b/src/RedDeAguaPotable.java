public class RedDeAguaPotable {

  ArbolGeneral<Float> configuracion;

  public ArbolGeneral<Float> getConfiguracion() {
    return configuracion;
  }

  public void setConfiguracion(ArbolGeneral<Float> configuracion) {
    this.configuracion = configuracion;
  }

  public RedDeAguaPotable(ArbolGeneral<Float> configuracion) {
    this.configuracion = configuracion;
  }

  public RedDeAguaPotable() {
  }

  public void imprimirRed() {
    configuracion.enOrden();
  }

  public float minimoCaudal(ArbolGeneral<Float> configuracion, float litros) {
    Float caudalHijos = 0f;
    if (!configuracion.esVacio()) {
      ListaGenerica<ArbolGeneral<Float>> hijos = configuracion.getHijos();
      hijos.comenzar();
      caudalHijos = litros / hijos.tamanio();
      ArbolGeneral<Float> hijo;
      while (!hijos.fin()) {
        hijo = hijos.proximo();
        hijo.setDato(caudalHijos);
        minimoCaudal(hijo, caudalHijos);
      }
      if (configuracion.esHoja()) {
        return caudalHijos.floatValue();
      }
    }
    return caudalHijos.floatValue();
  }
}
