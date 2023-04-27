import javax.swing.text.TableView;

public class Tablet extends Mobile{
    private int pulgadas;

    public Tablet(String marca, String sistemaOperativo, String modelo, double costo, int pulgadas) {
        super(marca, sistemaOperativo, modelo, costo);
        this.pulgadas = pulgadas;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean equals(Object objeto) {
        boolean result = false;
        if ((objeto != null) && (objeto instanceof Tablet)) {
            Tablet tablet = (Tablet) objeto;
            if (tablet.getPulgadas() == this.getPulgadas()) {
                result = true;
            }
        }
        return result;
    }

    public String toString() {
        return("Marca: " + super.getMarca() + " Sistema Operativo: " + super.getSistemaOperativo() + " Modelo: " + super.getModelo() +
                " Costo: " + super.getModelo() + " Pulgadas: " + getPulgadas());
    }
}
