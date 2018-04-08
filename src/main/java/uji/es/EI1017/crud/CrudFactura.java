package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Factura;

import java.io.Serializable;
import java.util.*;

public class CrudFactura implements Serializable {
    ArrayList<Factura> facturas = new ArrayList<Factura>();
    HashMap<String, ArrayList<Factura>> listaFacturas = new HashMap<String, ArrayList<Factura>>();
    private CrudLlamada crudLlamada = new CrudLlamada();

    public Factura emitirFactura(Factura factura, String DNI) {
        facturas.add(factura);
        if(listaFacturas.containsKey(DNI)) {
            listaFacturas.replace(DNI, facturas, facturas);
        }
        else {
            listaFacturas.put(DNI, facturas);
        }
        return factura;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public String devolverDatosFacturaPorCodigo(int codigoFactura) {
        for(int i = 0; i< listaFacturas.size();i++) {
            if(listaFacturas.get(i).equals(codigoFactura)) {
                return listaFacturas.get(i).toString();
            }
        }
        return "No existe la factura";
    }

    public ArrayList<Factura> recuperarTodasFacturas(String DNI) {
        if(listaFacturas.containsKey(DNI)){
            for (HashMap.Entry entry : listaFacturas.entrySet()){
                if(entry.getKey().equals(DNI))
                    for(int i = 0; i<listaFacturas.entrySet().size(); i++) {
                        System.out.println(listaFacturas.entrySet().toString());
                    }
            }
        }else {
            System.err.println("No existe el cliente");
        }
        return null;
    }
}
