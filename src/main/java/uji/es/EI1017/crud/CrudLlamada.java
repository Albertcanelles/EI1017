package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Llamada;

import java.io.Serializable;
import java.util.*;

public class CrudLlamada implements Serializable {
    private ArrayList<Llamada> llamadas = new ArrayList<>();
    private HashMap<String, ArrayList<Llamada>> listaLlamadas = new HashMap<>();




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

    public ArrayList<Llamada> listarLlamadas(String DNI) {
        ArrayList<Llamada> nueva = new ArrayList<Llamada>();
        if(listaLlamadas.containsKey(DNI)){
            Object valor = null;
            for (HashMap.Entry entry : listaLlamadas.entrySet()){
                if(entry.getKey().equals(DNI))

                         valor = entry.getValue();
                         nueva = (ArrayList<Llamada>) valor;
            }
        }else {
            System.err.println("No existe el cliente");
        }
        return nueva;
    }


}
