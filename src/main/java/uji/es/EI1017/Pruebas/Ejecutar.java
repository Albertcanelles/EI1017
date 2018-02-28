package uji.es.EI1017.Pruebas;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.herencias.Particular;
import uji.es.EI1017.menu.*;

import java.util.Scanner;

public class Ejecutar {
    public static void main (String [ ] args) {
        /*LLAMADA DEL MENU PRINCIPAL*/
        System.out.println(OpcionesMenu.getMenu());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elije una opción:");
        byte opcion = scanner.nextByte();
        OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
        /*FINAL LLAMADA MENU PRINCIPAL*/

        switch(opcionMenu) {
            case GESTIONAR_CLIENTES:
                /*LLAMADA DEL SUB MENU CLIENTES*/
                System.out.println(OpcionesMenuClientes.getMenu());
                System.out.print("Elije una opción:");
                byte opcion_cliente = scanner.nextByte();
                OpcionesMenuClientes opcionMenuCliente = OpcionesMenuClientes.getOpcion(opcion_cliente);
                /*FINAL LLAMADA SUB MENU CLIENTES*/
                switch (opcionMenuCliente) {
                    case DAR_DE_ALTA_CLIENTE:
                        /*LLAMADA DEL SUB MENU TIPO CLIENTES*/
                        System.out.println(OpcionesMenuTipoCliente.getMenu());
                        System.out.print("Elije una opción:");
                        byte opcion_TipoCliente = scanner.nextByte();
                        OpcionesMenuTipoCliente opcionesMenuTipoCliente = OpcionesMenuTipoCliente.getOpcion(opcion_TipoCliente);
                        /*GINAL LLAMADA SUB MENU TIPO CLIENTES*/
                        switch (opcionesMenuTipoCliente) {
                            case PARTICULAR:
                                System.out.println("Has seleccionado particular");
                                break;
                            case EMPRESA:
                                System.out.println("Has seleccionado empresa");
                                break;
                        }
                        break;
                    case BORRAR_CLIENTE:
                        System.out.println("Has seleccionado borrar cliente");
                        break;
                    case CAMBIAR_TARIFA_CLIENTE:
                        System.out.println("Has seleccionado modificar la tarifa del cliente");
                        break;
                    case RECUPERAR_CLIENTE_POR_NIF:
                        System.out.println("Has seleccionado recuperar cliente por NIF");
                        break;
                    case RECUPERAR_TODOS_CLIENTES:
                        System.out.println("Has seleccionado recuperar todos clientes");
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
                        System.out.println("Has seleccionado emitir factura a un cliente");
                        break;
                    case RECUPERAR_DATOS_FACTURA_POR_CODIGO:
                        System.out.println("Has seleccionado recuperar datos de una factura por codigo");
                        break;
                    case RECUPERAR_TODAS_FACTUAS_CLIENTE:
                        System.out.println("Has seleccionado recuperar todas las facturas de un client");
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
                        System.out.println("Has seleccionado dar una llamada de alta");
                        break;
                    case LISTAR_LLAMADAS_DE_UN_CLIENTE:
                        System.out.println("Has seleccionado Listar llamadas de un cliente");
                        break;
                }
                break;
                default:
                    System.out.println("Te vas a la puta elige bien");
                    break;
        }
        /*Cliente hola = new Cliente("Juanjo", "2323B", "bomberocanelles@gmail.com", null , 5.5,false);
        Particular adeu = new Particular("Albert", "2323A", "bomberocanelles@gmail.com", null , 5.5, "Campos",true);
        CrudCliente holax = new CrudCliente();
        holax.insertarCliente(hola);
        holax.insertarCliente(adeu);
        holax.listarClientes();
        holax.unCliente("2323A");

        holax.borrarCliente(hola);
        holax.listarClientes();
        for(int i = 0; i<holax.listarClientes().size(); i++) {
            System.out.println(holax.listarClientes().get(i).toString());
        }
        //CrudCliente.insertarCliente(hola);
        System.out.printf(adeu.getEmail());*/

    }
}
