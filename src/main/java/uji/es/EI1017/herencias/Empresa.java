package uji.es.EI1017.herencias;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;

import java.time.LocalDateTime;

public class Empresa extends Cliente{

    public Empresa(String nombre, String nif, String email, String direccion, LocalDateTime fechaAlta, Tarifa tarifa, boolean tipoParticular) {
        super(nombre, nif, email, direccion,fechaAlta, tarifa, tipoParticular);
    }

    public Empresa() {

    }
}
