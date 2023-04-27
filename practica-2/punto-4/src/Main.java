import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int[] vector = new int[14];
        ClaseRetorno resultado = new ClaseRetorno();
        int i;
        for (i = 0; i < 14; i++) {
            vector[i] = i;
        }
        resultado = PruebaRetorno.procesarArreglo(vector, i);
        System.out.println("Maximo = " + resultado.getMaximo());
        System.out.println("Mi" +
                "Minimo = " + resultado.getMinimo());
    }
}