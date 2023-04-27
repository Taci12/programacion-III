public class SmartPhone extends Mobile{
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public SmartPhone(String marca, String sistemaOperativo, String modelo, double costo, int numero) {
        super(marca, sistemaOperativo, modelo, costo);
        this.numero = numero;
    }

    public String toString() {
        return("Marca: " + super.getMarca() + " Sistema Operativo: " + super.getSistemaOperativo() + " Modelo: " + super.getModelo() +
                " Costo: " + super.getModelo() + " Numero: " + getNumero());
    }

    public boolean equals(Object objeto) {
        boolean result = false;
        if ((objeto != null) && (objeto instanceof SmartPhone)) {
            SmartPhone smartPhone = (SmartPhone) objeto;
            if (smartPhone.getNumero() == this.getNumero()) {
                result = true;
            }
        }
        return result;
    }
}
