package uji.es.EI1017.herencias;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Cliente;

import java.time.LocalDateTime;
import java.util.Date;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, String email, String direccion, LocalDateTime fechaAlta, double tarifa, boolean tipoParticular) {
        super(nombre, nif, email, direccion,fechaAlta, tarifa, tipoParticular);
    }

}
