package uji.es.EI1017.herencias;

import uji.es.EI1017.clases.Cliente;

import java.util.Date;

public class Empresa extends Cliente{
    //Si tipo cliente es =false es un empresa
    private boolean tipoCliente;
    public Empresa(String nombre, String nif, String email, Date fechaAlta, double tarifa, boolean tipoCliente) {
        super(nombre, nif, email, fechaAlta, tarifa);
        this.tipoCliente=tipoCliente;

    }

}
