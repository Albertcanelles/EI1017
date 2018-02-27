package uji.es.EI1017.clases;

import java.util.Date;

public class Cliente {

    private String nombre;
    private String nif;
    private String email;
    private Date fechaAlta;
    private double tarifa;

    public Cliente(String nombre, String nif, String email, Date fechaAlta, double tarifa) {
        this.nombre = nombre;
        this.nif = nif;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.tarifa = tarifa;
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public double getTarifa() {
        return tarifa;
    }

}
