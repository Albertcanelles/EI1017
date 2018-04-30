package uji.es.EI1017.herencias;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
public class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre, String nif, String email, String direccion, LocalDateTime fechaAlta, ArrayList<Tarifa> tarifa, String apellidos, boolean tipoParticular ) {
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
