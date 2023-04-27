public class PruebaRetorno {
    public static ClaseRetorno procesarArreglo(int[] vector, int dimL) {
        ClaseRetorno resultado = new ClaseRetorno(-99999, 9999);
        int i;
        for (i = 0; i < dimL; i++) {
            if (vector[i] > resultado.getMaximo()) { //por que me dice de hacer el metodo estatico???
                resultado.setMaximo(vector[i]);
                resultado.setIndiceMaximo(i);
            }
            if (vector[i] < resultado.getMinimo()) { //por que me dice de hacer el metodo estatico???
                resultado.setMinimo(vector[i]);
                resultado.setIndiceMinimo(i);
            }
        }
        return resultado;
    }
}
