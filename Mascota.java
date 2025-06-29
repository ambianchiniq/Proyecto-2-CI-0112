public class Mascota {
    private int id;
    private String nombre;
    private String especie;
    private String dueno;

    public Mascota(String nombre, String especie, String dueno) {
        this.id = GeneradorIds.generarNuevoId();
        this.nombre = nombre;
        this.especie = especie;
        this.dueno = dueno;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDueno() {
        return dueno;
    }

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String toString() {
        return "ID: " + id + " - Nombre: " + " - Especie: " + especie + " - Dueno: " + dueno;
    }
}
