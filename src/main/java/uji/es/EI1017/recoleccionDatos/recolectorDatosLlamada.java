package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.Crud.CrudLlamada;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class recolectorDatosLlamada {
    CrudLlamada crudLlamada = new CrudLlamada();  // Llamamos a los recoleccionDatos de la clase CrudLlamada
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void insertarDatosLlamada() {
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
        Date fechaLlamada = calendar.getTime();
        Llamada llamada = new Llamada(telefono, fechaLlamada, duracion);
        crudLlamada.insertarLlamada(llamada,DNI);
    }

    public void listarLlamadasUnCliente() {
        System.out.println("Introduce el DNI del cliente a listar:");
        String DNI = scanner.next();
        crudLlamada.listarLlamadas(DNI);
    }
}
