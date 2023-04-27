public class Mobile {
    private String marca;
    private String sistemaOperativo;
    private String modelo;
    private double costo;
    private float pulgadas;

    public Mobile(String marca, String sistemaOperativo, String modelo, double costo) {
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String devolverDatos() {
        return ("Marca: " + this.marca + "\n" +
        "Sistema Operativo: " + this.sistemaOperativo + "\n" +
        "Modelo: " + this.modelo + "\n" +
        "Costo: " + this.costo + "\n");
    }
}










