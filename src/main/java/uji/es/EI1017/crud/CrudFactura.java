package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Factura;

import java.io.Serializable;
import java.util.*;

public class CrudFactura implements Serializable {
    private ArrayList<Factura> facturas = new ArrayList<>();
    private HashMap<String, ArrayList<Factura>> listaFacturas = new HashMap<>();
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


    public HashMap<String, ArrayList<Factura>> getListaFacturas() {
        return listaFacturas;
    }
    public ArrayList<Factura> recuperarTodasFacturas(String DNI) {

        ArrayList<Factura> nueva = new ArrayList<>();
        if(listaFacturas.containsKey(DNI)){
            Object valor = null;
            for (HashMap.Entry entry : listaFacturas.entrySet()){
                if(entry.getKey().equals(DNI))
                        valor = entry.getValue();
                        nueva = (ArrayList<Factura>) valor;
            }
        }else {
            System.err.println("No existe el cliente");
        }
        return nueva;
    }
    public int numFacturas(){
        return facturas.size();
    }
}
