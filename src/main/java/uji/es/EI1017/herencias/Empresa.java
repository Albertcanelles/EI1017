package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, String email, String direccion, Date fechaAlta, double tarifa, boolean tipoParticular) {
        super(nombre, nif, email, direccion,fechaAlta, tarifa, tipoParticular);
    }

}
