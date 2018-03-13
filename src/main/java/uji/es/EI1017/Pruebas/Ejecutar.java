package uji.es.EI1017.Pruebas;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.menu.*;
import java.util.Scanner;

public class Ejecutar {
    public static void main (String [ ] args) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        CrudCliente crudCliente = new CrudCliente();  // Llamamos a los metodos de la clase CrudCliente
        CrudLlamada crudLlamada = new CrudLlamada();  // Llamamos a los metodos de la clase CrudLlamada
        CrudFactura crudFactura = new CrudFactura();  // Llamamos a los metodos de la clase CrudFactura
        do {
            /*LLAMADA DEL MENU PRINCIPAL*/
            System.out.println(OpcionesMenu.getMenu());
            System.out.println("Elije una opción:");
            opcion = scanner.nextByte();
            OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
            /*FINAL LLAMADA MENU PRINCIPAL*/

            switch (opcionMenu) {
                case GESTIONAR_CLIENTES:

                    /*LLAMADA DEL SUB MENU CLIENTES*/
                    System.out.println(OpcionesMenuClientes.getMenu());
                    System.out.print("Elije una opción:");
                    byte opcion_cliente = scanner.nextByte();
                    OpcionesMenuClientes opcionMenuCliente = OpcionesMenuClientes.getOpcion(opcion_cliente);
                    /*FINAL LLAMADA SUB MENU CLIENTES*/
                    switch (opcionMenuCliente) {
                        case DAR_DE_ALTA_CLIENTE:
                            crudCliente.insertarCliente(); // En la clase crudCliente metodo insertarCliente se realizan todas las operaciones
                            break;
                        case BORRAR_CLIENTE:
                            crudCliente.borrarCliente(); // En la clase crudCliente metodo borrarClient se realizan todas las operaciones
                            break;
                        case CAMBIAR_TARIFA_CLIENTE:
                            System.out.println("Has seleccionado modificar la tarifa del cliente");
                            break;
                        case RECUPERAR_CLIENTE_POR_NIF: // Recuperamos solamente un cliente por nif
                            System.out.println("Introduce el NIF de la persona a recuperar");
                            String nif = scanner.next();
                            crudCliente.unCliente(nif);
                            break;
                        case RECUPERAR_TODOS_CLIENTES:  // Recuperamos todos los clientes en la lista actualmente
                            if(crudCliente.listarClientes().size() == 0) {
                                System.err.println("Todavia no hay clientes");
                                break;
                            }
                            System.out.println("Has seleccionado recuperar todos clientes");
                            for (int i = 0; i < crudCliente.listarClientes().size(); i++) {
                                System.out.println(crudCliente.listarClientes().get(i).toString());
                            }
                            break;
                        case LISTAR_CLIENTES_ENTRE_FECHAS:
                            System.out.println("HAs seleccionado listar entre fechas");
                            break;
                    }
                    break;
                case GESTIONAR_FACTURAS:
                    /*LLAMADA DEL SUB MENU CLIENTES*/
                    System.out.println(OpcionesMenuFacturas.getMenu());
                    System.out.print("Elije una opción:");
                    byte opcion_factura = scanner.nextByte();
                    OpcionesMenuFacturas opcionesMenuFacturas = OpcionesMenuFacturas.getOpcion(opcion_factura);
                    /*FINAL LLAMADA SUB MENU CLIENTES*/
                    switch (opcionesMenuFacturas) {
                        case EMITIR_FACTURA_PARA_CLIENTE:
                            crudFactura.emitirFactura();
                            break;
                        case RECUPERAR_DATOS_FACTURA_POR_CODIGO:
                            crudFactura.devolverDatosFacturaPorCodigo();
                            break;
                        case RECUPERAR_TODAS_FACTUAS_CLIENTE:
                            crudFactura.recuperarTodasFacturas();
                            break;
                        case LISTAR_FACTURAS_ENTRE_FECHAS:
                            System.out.println("HAs seleccionado listar entre fechas");
                            break;
                    }
                    break;
                case GESTIONAR_LLAMADAS:
                    /*LLAMADA DEL SUB MENU LLAMADAS*/
                    System.out.println(OpcionesMenuLlamadas.getMenu());
                    System.out.print("Elije una opción:");
                    byte opcion_llamada = scanner.nextByte();
                    OpcionesMenuLlamadas opcionesMenuLlamadas = OpcionesMenuLlamadas.getOpcion(opcion_llamada);
                    /*FINAL LLAMADA SUB MENU LLAMADAS*/
                    switch (opcionesMenuLlamadas) {
                        case DAR_DE_ALTA_UNA_LLAMADA:
                            crudLlamada.insertarLlamada();
                            break;
                        case LISTAR_LLAMADAS_DE_UN_CLIENTE:
                            crudLlamada.listarLlamadas();
                            break;
                        case LISTAR_LLAMADAS_ENTRE_FECHAS:
                            System.out.println("HAs seleccionado listar entre fechas");
                            break;
                    }
                    break;
                case SALIR:
                    System.exit(0);
            }
        }while(opcion>=0);

    }
}