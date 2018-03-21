package uji.es.EI1017.Herencias;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Cliente;

import java.util.Date;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, String email, String direccion, Date fechaAlta, double tarifa, boolean tipoParticular) {
        super(nombre, nif, email, direccion,fechaAlta, tarifa, tipoParticular);
    }

}
