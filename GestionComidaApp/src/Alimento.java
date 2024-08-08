/**
 *
 * @author USER
 */
public class Alimento {
    private String nombre;
    private String caracteristicas;

    public Alimento(String nombre, String caracteristicas) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }
}
