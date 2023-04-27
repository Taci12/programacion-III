public class ClaseRetorno {
    private int maximo;
    private int minimo;
    private int indiceMaximo;
    private int indiceMinimo;

    public int getIndiceMaximo() {
        return indiceMaximo;
    }

    public void setIndiceMaximo(int indiceMaximo) {
        this.indiceMaximo = indiceMaximo;
    }

    public int getIndiceMinimo() {
        return indiceMinimo;
    }

    public void setIndiceMinimo(int indiceMinimo) {
        this.indiceMinimo = indiceMinimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public ClaseRetorno(int maximo, int minimo) {
        this.maximo = maximo;
        this.minimo = minimo;
    }
    public ClaseRetorno() {

    }
}
