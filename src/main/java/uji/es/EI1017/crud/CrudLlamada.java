package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Llamada;

import java.time.LocalDateTime;
import java.util.*;

public class CrudLlamada {
    private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
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
        if(listaLlamadas.containsKey(DNI)){
            for (HashMap.Entry entry : listaLlamadas.entrySet()){
                if(entry.getKey().equals(DNI))
                    for(int i = 0; i<listaLlamadas.entrySet().size(); i++) {
                        System.out.println(listaLlamadas.entrySet().toString());
                    }
            }
        }else {
            System.err.println("No existe el cliente");
        }
       return null;
    }

    /*
    * Metodo utilizado para la suma de los minutos totales a la hora de generar la factura
    * */
    public float sumarMinutos(String DNI, LocalDateTime FechaInicio, LocalDateTime FechaFinal) {
        float suma = 0;
        if (listaLlamadas.containsKey(DNI)) {
            for (HashMap.Entry entry : listaLlamadas.entrySet()) {
                if (entry.getKey().equals(DNI))
                    for (int i = 0; i < listaLlamadas.entrySet().size(); i++) {
                        suma += listaLlamadas.get(i).get(i).getDuracion();
                    }
            }
        } else {
            System.err.println("No existe el cliente");
        }

        return suma;
    }

}
