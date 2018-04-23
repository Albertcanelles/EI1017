package uji.es.EI1017.Clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.io.Serializable;
import java.time.LocalDateTime;


public class Cliente implements Fecha, Serializable{

    private String nombre;
    private String nif;
    private String email;
    private String direccion;
    private LocalDateTime fechaAlta;
    private Tarifa tarifa;
    //Si tipo cliente es =true es un particular
    private boolean tipoParticular;

    public Cliente(String nombre, String nif, String email, String direccion ,LocalDateTime fechaAlta, Tarifa tarifa, boolean tipoParticular) {
        this.nombre = nombre;
        this.nif = nif;
        this.email = email;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.tarifa = tarifa;
        this.tipoParticular = tipoParticular;
    }

    public Cliente() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setTipoParticular(boolean tipoParticular) {
        this.tipoParticular = tipoParticular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFecha() {
        return fechaAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public boolean esTipoParticular() { return tipoParticular; }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre=" + nombre +
                ", nif=" + nif +
                ", email=" + email +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", tarifa=" + tarifa +
                ", tipoParticular=" + tipoParticular +
                '}';
    }
}


