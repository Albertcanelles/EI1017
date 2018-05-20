package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.crud.*;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;

public class RecolectorDatosLlamada {
    CrudLlamada crudLlamada;  // Llamamos a los recoleccionDatos de la clase CrudLlamada
    CrudCliente crudCliente;
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public RecolectorDatosLlamada(CrudLlamada crudLlamada, CrudCliente crudCliente) {
        this.crudLlamada = crudLlamada;
        this.crudCliente = crudCliente;
    }


    /*public void insertarDatosLlamada() {
        System.out.println("Introduce el DNI del cliente:");
        String DNI = scanner.next();
        while ( DNI.length()!= 9){
            System.out.println("DNI invalido, ha de tener 8 números y una letra al final");
            System.out.println("Introduce el DNI del cliente:");
            DNI = scanner.next();
        }
        System.out.println("Introduce el numero a llamar:");
        int telefono = scanner.nextInt();
        String cod_valor = String.valueOf(telefono);
        while ( cod_valor.length() != 9){
            System.out.println("El número no es válido, ha de ser un número de nueve dígitos");
            System.out.println("Introduce el numero a llamar:");
            telefono = scanner.nextInt();
        }
        System.out.println("Introduce la duracion:");
        float duracion = scanner.nextFloat();
        while (duracion < 0 ){
            System.out.println("Duración no valida, ha de ser un número mayor o igual a 0");
            System.out.println("Introduce la duracion:");
            duracion = scanner.nextFloat();
        }
        LocalDateTime fechaLlamada = LocalDateTime.now();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        crudLlamada.insertarLlamada(llamada,DNI);
    }*/

    public void insertarDatosLlamadaVista(String DNI, int telefono, float duracion) {
        LocalDateTime fechaLlamada = LocalDateTime.now();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        crudLlamada.insertarLlamada(llamada,DNI);
    }

    public Llamada[] listarLlamadasUnCliente(String DNI) {
        Llamada[] nuevo = new Llamada[crudLlamada.listarLlamadas(DNI).size()];
        for(int i =0; i< crudLlamada.listarLlamadas(DNI).size(); i++){
                nuevo[i] = crudLlamada.listarLlamadas(DNI).get(i);
        }
        return nuevo;
    }

    public Llamada[] listarLLamadas(LocalDateTime fechaIni, LocalDateTime fechaFin){
       // LocalDateTime fechaIni = RecolectorDatosGenerico.pedirFecha();
       // LocalDateTime fechaFin = RecolectorDatosGenerico.pedirFecha();
        Llamada[] listado = new Llamada[crudLlamada.getLlamadas().size()];
        try {
            RecolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Llamada> todas = crudLlamada.getLlamadas();
            Collection<Llamada> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            int i = 0;
            for(Llamada iter : lista){
                listado[i] = iter;
                i++;
                //System.out.println(iter.toString());
            }
        }catch (ErrorEntreFechasException e){};
        return listado;
    }


}