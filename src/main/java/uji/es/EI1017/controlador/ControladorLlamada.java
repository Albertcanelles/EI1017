package uji.es.EI1017.controlador;

import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.modelo.*;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;

public class ControladorLlamada {
    ModeloLlamada modeloLlamada;  // Llamamos a los controlador de la clase ModeloLlamada
    ModeloCliente modeloCliente;
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public ControladorLlamada(ModeloLlamada modeloLlamada, ModeloCliente modeloCliente) {
        this.modeloLlamada = modeloLlamada;
        this.modeloCliente = modeloCliente;
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
        modeloLlamada.insertarLlamada(llamada,DNI);
    }*/

    public void insertarDatosLlamadaVista(String DNI, int telefono, float duracion) {
        LocalDateTime fechaLlamada = LocalDateTime.now();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        modeloLlamada.insertarLlamada(llamada,DNI);
    }

    public Llamada[] listarLlamadasUnCliente(String DNI) {
        Llamada[] nuevo = new Llamada[modeloLlamada.listarLlamadas(DNI).size()];
        for(int i = 0; i< modeloLlamada.listarLlamadas(DNI).size(); i++){
                nuevo[i] = modeloLlamada.listarLlamadas(DNI).get(i);
        }
        return nuevo;
    }

    public Llamada[] listarLLamadas(LocalDateTime fechaIni, LocalDateTime fechaFin){
       // LocalDateTime fechaIni = ControladorGenerico.pedirFecha();
       // LocalDateTime fechaFin = ControladorGenerico.pedirFecha();
        Llamada[] listado = new Llamada[modeloLlamada.getLlamadas().size()];
        try {
            ControladorGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Llamada> todas = modeloLlamada.getLlamadas();
            Collection<Llamada> lista = ModeloGenerico.extraerConjunto(todas, fechaIni, fechaFin);
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
