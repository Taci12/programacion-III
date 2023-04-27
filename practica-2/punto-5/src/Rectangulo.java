public class Rectangulo extends Figura {
    private double ancho;
    private double largo;

    public Rectangulo() {
    }

    public Rectangulo(double ancho, double largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public Rectangulo(String color, boolean relleno, double ancho, double largo) {
        super(color, relleno);
        this.ancho = ancho;
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }
    @Override
    public double getArea() {
        return (getAncho() * getLargo());
    }
    @Override
    public double getPerimetro() {
        return (2 * (getAncho() + getLargo()));
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "ancho=" + ancho +
                ", largo=" + largo +
                '}';
    }
}
