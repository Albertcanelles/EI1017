package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.herencias.Empresa;
import uji.es.EI1017.herencias.Particular;
import uji.es.EI1017.menu.OpcionesMenuTipoCliente;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class recolectorDatosCliente {


    CrudCliente crudCliente = new CrudCliente();  // Llamamos a los recoleccionDatos de la clase CrudCliente
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);


    public void insertarDatosCliente() {
        /* RECOLECCION DE DATOS POR TECLADO */
        System.out.println("Introduce el nombre:");
        String nombre = scanner.next();
        while (nombre == null) {
            System.out.println("No se admiten nombres de valor null");
            System.out.println("Introduce el nombre:");
            nombre = scanner.next();
        }
        System.out.println("Introduce el NIF:");
        String nif = scanner.next();
        while (nif.length() != 9) {
            System.out.println("Su NIF no es valido, ha de tener 8 números y una letra al final");
            System.out.println("Introduce el NIF:");
            nif = scanner.next();
        }
        System.out.println("Introduce el email:");
        String email = scanner.next();
        while (email.length() < 10) {
            System.out.println("Email demasiado corto, ha de tener más de 10 carácteres ");
            System.out.println("Introduce el email:");
            email = scanner.next();
        }
        System.out.println("Introduce la direccion:");
        String direccion = scanner.next();
        while (direccion.length() < 10) {
            System.out.println("Dirección no valida, ha de tener 10 o más carácteres");
            System.out.println("Introduce la direccion:");
            direccion = scanner.next();
        }
        Date fechaAlta = calendar.getTime();
        double tarifa = 5.5;
        /* FIN DE RECOLECCION DE DATOS POR TECLADO*/

        /* LLAMADA DEL SUB MENU TIPO CLIENTES*/
        System.out.println(OpcionesMenuTipoCliente.getMenu());
        System.out.print("Elije una opción:");
        byte opcion_TipoCliente = scanner.nextByte();
        OpcionesMenuTipoCliente opcionesMenuTipoCliente = OpcionesMenuTipoCliente.getOpcion(opcion_TipoCliente);
        /* FINAL LLAMADA SUB MENU TIPO CLIENTES*/

        /*SELECCION DE TIPO DE CLIENTE*/
        switch (opcionesMenuTipoCliente) {
            case PARTICULAR:
                System.out.println("Introduce el apellido:");
                String apellido = scanner.next();
                Cliente particular = new Particular(nombre, nif, email, direccion, fechaAlta, tarifa, apellido, true);
                crudCliente.insertarCliente(particular);
                break;
            case EMPRESA:
                Cliente empresa = new Empresa(nombre, nif, email, direccion, fechaAlta, tarifa, false);
                crudCliente.insertarCliente(empresa);
                break;
        }
    }

    public void eliminarClienteDNI() {
            System.out.println("Introduce el DNI de la persona a eliminar");
            Cliente cs;
            String nif = scanner.next();
            cs = crudCliente.unCliente(nif);
            if (crudCliente.listaClientes.contains(cs))
                crudCliente.borrarCliente(cs);

    }

    public void recuperarClientePorDNI() {
        System.out.println("Introduce el NIF de la persona a recuperar");
        String nif = scanner.next();
        crudCliente.unCliente(nif);
    }
}
