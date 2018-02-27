package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;

public class Particular extends Cliente {

    private String apellidos;
    //Si tipo cliente es =true es un particular
    private boolean tipoCliente;
    public Particular(String nombre, String nif, String email, Date fechaAlta, double tarifa, String apellidos, boolean tipoCliente) {
        super(nombre, nif, email, fechaAlta, tarifa);
        this.apellidos= apellidos;
        this.tipoCliente=tipoCliente;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
