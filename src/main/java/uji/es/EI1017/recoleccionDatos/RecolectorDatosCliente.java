package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudGenerico;

import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.factoria.FabricaClientes;
import uji.es.EI1017.factoria.FabricaTarifas;
import uji.es.EI1017.menu.OpcionesMenuTipoCliente;


import java.time.LocalDateTime;
import java.util.*;

public class RecolectorDatosCliente {


    private CrudCliente crudCliente;
    Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);
    // Constructor para pasar la referencia del ejecutar.
    public RecolectorDatosCliente(CrudCliente crud){
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
        ArrayList<Tarifa> listaTarifas = new ArrayList<Tarifa>();
        FabricaTarifas fabricaTarifas = new FabricaTarifas();
        Tarifa tarifaBasica = fabricaTarifas.getBasica(precio);
        listaTarifas.add(tarifaBasica);
        System.out.println("¿Deseas añadir más tarifas? (si/no)");
        String contestacion = scanner.next();
        while(contestacion.equals("si")){
            Tarifa tarifa1;
            System.out.println("¿De tipo 'periodo' o 'dia'?");
            String tipo = scanner.next();
            if(tipo.equals("periodo")){
                System.out.println("Introduce el precio de la tarifa periodo:");
                float precioPeriodo = scanner.nextFloat();
                System.out.println("¿Cual es la hora de inicio? ");
                int horaIni = scanner.nextInt();
                System.out.println("¿Cual es la hora final? ");
                int horaFin = scanner.nextInt();
                tarifa1 = fabricaTarifas.getPeriodo(tarifaBasica,precioPeriodo,horaIni, horaFin);
            }else{
                System.out.println("Introduce el precio de la tarifa dia:");
                float precioDia = scanner.nextFloat();
                System.out.println("¿Cual es el día de la semana que se aplica esta tarifa? ");
                int diaTarifa = scanner.nextInt();
                tarifa1 = fabricaTarifas.getDia(tarifaBasica, precioDia , diaTarifa);
            }
            listaTarifas.add(tarifa1);
            tarifaBasica = tarifa1;
            System.out.println("¿Deseas añadir más tarifas? (si/no)");
            contestacion = scanner.next();
        }
        /* FIN DE RECOLECCION DE DATOS POR TECLADO*/

        /* LLAMADA DEL SUB MENU TIPO CLIENTES*/
        System.out.println(OpcionesMenuTipoCliente.getMenu());
        System.out.print("Elije una opción:");
        byte opcion_TipoCliente = scanner.nextByte();
        OpcionesMenuTipoCliente opcionesMenuTipoCliente = OpcionesMenuTipoCliente.getOpcion(opcion_TipoCliente);
        /* FINAL LLAMADA SUB MENU TIPO CLIENTES*/

        /*SELECCION DE TIPO DE CLIENTE*/
        FabricaClientes fabricaClientes = new FabricaClientes();
        switch (opcionesMenuTipoCliente) {
            case PARTICULAR:
                System.out.println("Introduce el apellido:");
                String apellido = scanner.next();
                Cliente particular = fabricaClientes.getParticular(nombre, nif, email, direccion, fechaAlta, listaTarifas, apellido, true);
                crudCliente.insertarCliente(particular);

                break;
            case EMPRESA:
                Cliente empresa = fabricaClientes.getEmpresa(nombre, nif, email, direccion, fechaAlta, listaTarifas, false);
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

            }catch (NoExisteClienteException e){
                System.out.printf("Error");;
            }

    }
    public void recuperarClientePorDNI() {
        System.out.println("Introduce el NIF de la persona a recuperar");
        String nif = scanner.next();
        try{
            crudCliente.unCliente(nif);

        }catch (NoExisteClienteException e){
            System.out.println("Error");;
        }
    }
    public void listarFacturas(){
        LocalDateTime fechaIni = RecolectorDatosGenerico.pedirFecha();
        LocalDateTime fechaFin = RecolectorDatosGenerico.pedirFecha();
        try {
            RecolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Cliente> todas = crudCliente.getListaClientes();
            Collection<Cliente> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            for (Cliente iter : lista) {
                System.out.println(iter.toString());
            }
        }catch (ErrorEntreFechasException e){
            return;
        }
    }

    // TO DO
    public void modificarTarifa() throws NoExisteClienteException {
        System.out.println("Introduce DNI del cliente: ");
        String DNI = scanner.next();
        Cliente cliente = crudCliente.unCliente(DNI);
        System.out.println("Las tarifas que tienes son: " + cliente.getTarifa());
        System.out.println("Introduce las nuevas tarifas: ");
        System.out.println("Introduce el precio de la tarifa basica:");
        float precio = scanner.nextFloat();
        ArrayList<Tarifa> listaTarifas = new ArrayList<Tarifa>();
        FabricaTarifas fabricaTarifas = new FabricaTarifas();
        Tarifa tarifaBasica = fabricaTarifas.getBasica(precio);
        listaTarifas.add(tarifaBasica);
        System.out.println("¿Deseas añadir más tarifas? (si/no)");
        String contestacion = scanner.next();
        while(contestacion.equals("si")){
            Tarifa tarifa1;
            System.out.println("¿De tipo 'periodo' o 'dia'?");
            String tipo = scanner.next();
            if(tipo.equals("periodo")){
                System.out.println("Introduce el precio de la tarifa periodo:");
                float precioPeriodo = scanner.nextFloat();
                System.out.println("¿Cual es la hora de inicio? ");
                int horaIni = scanner.nextInt();
                System.out.println("¿Cual es la hora final? ");
                int horaFin = scanner.nextInt();
                tarifa1 = fabricaTarifas.getPeriodo(tarifaBasica,precioPeriodo,horaIni, horaFin);
            }else{
                System.out.println("Introduce el precio de la tarifa dia:");
                float precioDia = scanner.nextFloat();
                System.out.println("¿Cual es el día de la semana que se aplica esta tarifa? ");
                int diaTarifa = scanner.nextInt();
                tarifa1 = fabricaTarifas.getDia(tarifaBasica, precioDia , diaTarifa);
            }
            listaTarifas.add(tarifa1);
            tarifaBasica = tarifa1;
            System.out.println("¿Deseas añadir más tarifas? (si/no)");
            contestacion = scanner.next();
        }
        cliente.setTarifa(listaTarifas);

    }
}
