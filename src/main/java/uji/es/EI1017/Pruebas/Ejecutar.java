package uji.es.EI1017.Pruebas;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.herencias.Particular;
import uji.es.EI1017.menu.OpcionesMenu;
import uji.es.EI1017.menu.OpcionesMenuClientes;

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
                Scanner clientes = new Scanner(System.in);
                System.out.print("Elije una opción:");
                byte opcion_cliente = scanner.nextByte();
                OpcionesMenuClientes opcionMenuCliente = OpcionesMenuClientes.getOpcion(opcion_cliente);
                /*FINAL LLAMADA SUB MENU CLIENTES*/
                switch (opcionMenuCliente) {
                    case DAR_DE_ALTA_CLIENTE:
                        System.out.println("Has seleccionado insertar cliente");
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
                System.out.println("Has seleccionado gestionar facturas");;
                break;
            case GESTIONAR_LLAMADAS:
                System.out.println("Has seleccionado gestionar llamadas");;
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
