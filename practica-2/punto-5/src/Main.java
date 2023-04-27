public class Main {
    public static void main(String[] args) {
        Figura[] vector = new Figura[3];
        vector[0] = new Circulo(4.5, "Rojo", true);
        vector[1] = new Rectangulo("Verde", false, 4, 8);
        vector[2] = new Cuadrado("Azul", false, 5, 5);

        for (Figura elemento : vector) {
            System.out.println(elemento.toString());
        }
    }
}