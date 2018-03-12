package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Llamada;

import java.util.*;

public class CrudLlamada {
    ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
    HashMap<String, ArrayList<Llamada>> listaLlamadas = new HashMap<String, ArrayList<Llamada>>();
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void insertarLlamada() {
        System.out.println("Introduce el DNI del cliente:");
        String DNI = scanner.next();
        System.out.println("Introduce el numero a llamar:");
        int telefono = scanner.nextInt();
        System.out.println("Introduce la duracion:");
        float duracion = scanner.nextFloat();
        Date fechaLlamada = calendar.getTime();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        llamadas.add(llamada);
        if(listaLlamadas.containsKey(DNI)) {
            listaLlamadas.replace(DNI, llamadas, llamadas);
        }
        else {
            listaLlamadas.put(DNI, llamadas);
        }


    }



    public ArrayList<Llamada> listarLlamadas() {  // Ineficiente lo mas seguro revisar para entrega final DE NADA ;)
        System.out.println("Introduce el DNI del cliente a listar:");
        String DNI = scanner.next();
        ArrayList<Llamada> llamadasCliente = new ArrayList<Llamada>();
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
       return llamadasCliente;
    }
    /*
    * Metodo utilizado para la suma de los minutos totales a la hora de generar la factura
    * */
    public float sumarMinutos(String DNI, Date FechaInicio, Date FechaFinal) {
            float suma = 0;
        if(listaLlamadas.containsKey(DNI)){
            for (HashMap.Entry entry : listaLlamadas.entrySet()){
                if(entry.getKey().equals(DNI))
                    for(int i = 0; i<listaLlamadas.entrySet().size(); i++) {
                        suma+=listaLlamadas.get(i).get(i).getDuracion();
                    }
            }
        }else {
            System.err.println("No existe el cliente");
        }

        return suma;
    }
}
