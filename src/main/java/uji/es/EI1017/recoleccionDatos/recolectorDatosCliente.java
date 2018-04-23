package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Factura;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudGenerico;
import uji.es.EI1017.decorador.TarifaDomingos;
import uji.es.EI1017.decorador.TarifaTardes;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.herencias.Empresa;
import uji.es.EI1017.herencias.Particular;
import uji.es.EI1017.menu.OpcionesMenuTipoCliente;
import uji.es.EI1017.menu.OpcionesTarifa;

import java.time.LocalDateTime;
import java.util.*;

public class recolectorDatosCliente {


    CrudCliente crudCliente;
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    // Constructor para pasar la referencia del ejecutar.
    public recolectorDatosCliente(CrudCliente crud){
        this.crudCliente = crud;
    }


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
        LocalDateTime fechaAlta = LocalDateTime.now();

        System.out.println("Introduce el precio de la tarifa basica:");
        float precio = scanner.nextFloat();
        Tarifa tarifa = new Tarifa(precio);
        System.out.println(OpcionesTarifa.getMenu());
        System.out.print("Elije una opción:");
        byte opcion_tarifa = scanner.nextByte();
        OpcionesTarifa opcionTarifa = OpcionesTarifa.getOpcion(opcion_tarifa);
        switch (opcionTarifa) {
            case TARIFA_POR_DIAS:
                System.out.println("Introduce el precio de la tarifa:");
                precio = scanner.nextFloat();
                tarifa = new TarifaTardes(tarifa,precio);
                break;
            case TARIFA_POR_HORAS:
                System.out.println("Introduce el precio de la tarifa:");
                precio = scanner.nextFloat();
                tarifa = new TarifaDomingos(tarifa,precio);
                break;
            case NO_GRACIAS:
                break;
        }
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
            try{
                cs = crudCliente.unCliente(nif);
                if (crudCliente.getListaClientes().contains(cs))
                    crudCliente.borrarCliente(cs);

            }catch (NoExisteClienteException e){};

    }

    public void recuperarClientePorDNI() {
        System.out.println("Introduce el NIF de la persona a recuperar");
        String nif = scanner.next();
        try{
            crudCliente.unCliente(nif);

        }catch (NoExisteClienteException e){};
    }
    public void listarFacturas(){
        LocalDateTime fechaIni = recolectorDatosGenerico.pedirFecha();
        LocalDateTime fechaFin = recolectorDatosGenerico.pedirFecha();
        try {
            recolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Cliente> todas = crudCliente.getListaClientes();
            Collection<Cliente> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            for (Cliente iter : lista) {
                System.out.println(iter.toString());
            }
        }catch (ErrorEntreFechasException e){};
    }
}
