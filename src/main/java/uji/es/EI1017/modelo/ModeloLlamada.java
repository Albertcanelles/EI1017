package uji.es.EI1017.modelo;

import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.crud.*;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;

public class ModeloLlamada {
    private CrudLlamada crudLlamada;  // Llamamos a los modelo de la clase CrudLlamada
    private CrudCliente crudCliente;
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public ModeloLlamada(CrudLlamada crudLlamada, CrudCliente crudCliente) {
        this.crudLlamada = crudLlamada;
        this.crudCliente = crudCliente;
    }


    public void insertarDatosLlamadaVista(String DNI, int telefono, float duracion) {
        LocalDateTime fechaLlamada = LocalDateTime.now();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        crudLlamada.insertarLlamada(llamada,DNI);
    }

    public Llamada[] listarLlamadasUnCliente(String DNI) {
        Llamada[] nuevo = new Llamada[crudLlamada.listarLlamadas(DNI).size()];
        for(int i = 0; i< crudLlamada.listarLlamadas(DNI).size(); i++){
                nuevo[i] = crudLlamada.listarLlamadas(DNI).get(i);
        }
        return nuevo;
    }

    public Llamada[] listarLLamadas(LocalDateTime fechaIni, LocalDateTime fechaFin){
        Llamada[] listado = new Llamada[crudLlamada.getLlamadas().size()];
        try {
            ModeloGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Llamada> todas = crudLlamada.getLlamadas();
            Collection<Llamada> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            int i = 0;
            for(Llamada iter : lista){
                listado[i] = iter;
                i++;
            }
        }catch (ErrorEntreFechasException e){
            System.err.println("Error entre fechas");
        }
        return listado;
    }


}
