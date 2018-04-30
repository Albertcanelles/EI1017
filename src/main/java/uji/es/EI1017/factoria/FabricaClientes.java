package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.herencias.Empresa;
import uji.es.EI1017.herencias.Particular;

import java.time.LocalDateTime;

public class FabricaClientes {
    private Particular particular;
    private Empresa empresa;

    public Particular getParticular(String nombre, String nif, String email, String direccion, LocalDateTime fechaAlta,
                                    Tarifa tarifa, String apellidos, boolean tipoParticular ){
        particular = new Particular(nombre, nif, email, direccion, fechaAlta, tarifa, apellidos, false);
        return particular;

    }
    public  Empresa getEmpresa(String nombre, String nif, String email, String direccion, LocalDateTime fechaAlta,
                               Tarifa tarifa, boolean tipoParticular){
        empresa = new Empresa(nombre, nif, email, direccion, fechaAlta, tarifa, false);
        return empresa;
    }
}

