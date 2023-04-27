import java.lang.Math;
import java.util.Objects;

public class Circulo extends Figura{
    private double radio;
    public Circulo() {
    }
    public Circulo(double radio, String color, boolean relleno) {
        super(color, relleno);
        this.radio = radio;
    }
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return (Math.pow(Math.PI * getRadio(), 2));
    }

    @Override
    public double getPerimetro() {
        return (2 * Math.PI * this.getRadio());
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }
}
