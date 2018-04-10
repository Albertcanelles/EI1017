package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Llamada;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class CrudLlamada implements Serializable {
    ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
    HashMap<String, ArrayList<Llamada>> listaLlamadas = new HashMap<String, ArrayList<Llamada>>();


    public void insertarLlamada(Llamada llamada, String DNI) {
        llamadas.add(llamada);
        if(listaLlamadas.containsKey(DNI)) {
            listaLlamadas.replace(DNI, llamadas, llamadas);
        }
        else {
            listaLlamadas.put(DNI, llamadas);
        }
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public ArrayList<Llamada> listarLlamadas(String DNI) {  // Ineficiente lo mas seguro revisar para entrega final DE NADA ;)
        ArrayList<Llamada> nueva = new ArrayList<Llamada>();
        if(listaLlamadas.containsKey(DNI)){
            Object valor = null;
            for (HashMap.Entry entry : listaLlamadas.entrySet()){
                if(entry.getKey().equals(DNI))
                        System.out.println(listaLlamadas.entrySet().toString());
                         valor = entry.getValue();
                         nueva = (ArrayList<Llamada>) valor;
            }
        }else {
            System.err.println("No existe el cliente");
        }
        return nueva;
    }


}
