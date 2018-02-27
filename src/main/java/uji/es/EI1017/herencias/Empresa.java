package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, String email, Date fechaAlta, double tarifa) {
        super(nombre, nif, email, fechaAlta, tarifa);
    }
}
