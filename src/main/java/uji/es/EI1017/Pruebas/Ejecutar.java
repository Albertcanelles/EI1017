package uji.es.EI1017.Pruebas;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.menu.*;
import uji.es.EI1017.recoleccionDatos.recolectorDatosCliente;
import uji.es.EI1017.recoleccionDatos.recolectorDatosFactura;
import uji.es.EI1017.recoleccionDatos.recolectorDatosLlamada;

import java.util.Scanner;

public class Ejecutar {
    public static void main (String [ ] args) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        recolectorDatosCliente recolectorCliente = new recolectorDatosCliente(); // Clase utilizada para la recoleccion datos de clientes
        recolectorDatosLlamada recolectorLlamada = new recolectorDatosLlamada(); // Clase utilizada para la recoleccion datos de llamadas
        recolectorDatosFactura recolectorFactura = new recolectorDatosFactura(); // Clase utilizada para la recoleccion datos de facturas
        CrudCliente crudCliente = new CrudCliente();  // Clase utilizada para obtener datos de Clientes
        CrudLlamada crudLlamada = new CrudLlamada();  // Clase utilizada para obtener datos de Llamadas
        CrudFactura crudFactura = new CrudFactura();  // Clase utilizada para obtener datos de Facturas
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
                            recolectorCliente.insertarDatosCliente(); // En la clase crudCliente metodo insertarCliente se realizan todas las operaciones
                            break;
                        case BORRAR_CLIENTE:
                            recolectorCliente.eliminarClienteDNI(); // En la clase crudCliente metodo borrarClient se realizan todas las operaciones
                            break;
                        case CAMBIAR_TARIFA_CLIENTE:
                            System.out.println("Has seleccionado modificar la tarifa de un cliente");
                            break;
                        case RECUPERAR_CLIENTE_POR_NIF: // Recuperamos solamente un cliente por nif
                            recolectorCliente.recuperarClientePorDNI();
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
                            recolectorFactura.insertarDatosFactura();
                            break;
                        case RECUPERAR_DATOS_FACTURA_POR_CODIGO:
                            recolectorFactura.devolverFactuasPorCodigo();
                            break;
                        case RECUPERAR_TODAS_FACTUAS_CLIENTE:
                            recolectorFactura.devolverFacturasUnCliente();
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
                            recolectorLlamada.insertarDatosLlamada();
                            break;
                        case LISTAR_LLAMADAS_DE_UN_CLIENTE:
                            recolectorLlamada.listarLlamadasUnCliente();
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