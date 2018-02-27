package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;

public class Particular extends Cliente {

    private String apellidos;
    public Particular(String nombre, String nif, String email, Date fechaAlta, double tarifa, String apellidos) {
        super(nombre, nif, email, fechaAlta, tarifa);
        this.apellidos= apellidos;
    }
}