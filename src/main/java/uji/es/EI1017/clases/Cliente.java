package uji.es.EI1017.clases;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import java.util.Date;

public class Cliente {

    private String nombre;
    private String nif;
    private String email;
    private String direccion;
    private Date fechaAlta;
    private double tarifa;
    //Si tipo cliente es =true es un particular
    private boolean tipoParticular;

    public Cliente(String nombre, String nif, String email, String direccion ,Date fechaAlta, double tarifa, boolean tipoParticular) {
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

    public Date getFecha() {
        return fechaAlta;
    }

    public double getTarifa() {
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


