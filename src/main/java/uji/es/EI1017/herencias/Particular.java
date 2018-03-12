package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre, String nif, String email, String direccion,Date fechaAlta, double tarifa, String apellidos, boolean tipoParticular ) {
        super(nombre, nif, email, direccion,fechaAlta, tarifa, tipoParticular);
        this.apellidos= apellidos;
    }

    public Particular() {

    }

    public String getApellidos() { return apellidos; }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
