package uji.es.EI1017.pruebas;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */

import uji.es.EI1017.modelo.ModeloFactura;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.menu.*;
import uji.es.EI1017.modelo.ModeloCliente;
import uji.es.EI1017.modelo.ModeloLlamada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Scanner;

public class Ejecutar implements Serializable {

    private CrudCliente crudCliente;
    private CrudLlamada crudLlamada;
    private CrudFactura crudFactura;

    public Ejecutar(){
        crudCliente = new CrudCliente();
        crudFactura = new CrudFactura();
        crudLlamada = new CrudLlamada();
    }


    public void menu() {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        ModeloCliente recolectorCliente = new ModeloCliente(crudCliente); // Clase utilizada para la recoleccion datos de clientes
        ModeloLlamada recolectorLlamada = new ModeloLlamada(crudLlamada, crudCliente); // Clase utilizada para la recoleccion datos de llamadas
        ModeloFactura recolectorFactura = new ModeloFactura(crudLlamada, crudFactura, crudCliente); // Clase utilizada para la recoleccion datos de facturas


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
                            //recolectorCliente.insertarDatosCliente(); // En la clase crudCliente metodo insertarCliente se realizan todas las operaciones
                            break;
                        case BORRAR_CLIENTE:
                            //recolectorCliente.eliminarClienteDNI(); // En la clase crudCliente metodo borrarClient se realizan todas las operaciones
                            break;
                        case RECUPERAR_CLIENTE_POR_NIF: // Recuperamos solamente un cliente por nif
                            //recolectorCliente.recuperarClientePorDNI();
                            break;
                        case RECUPERAR_TODOS_CLIENTES:  // Recuperamos todos los clientes en la lista actualmente
                            if(crudCliente.listarClientes().size() == 0) {
                                System.err.println("Todavia no hay clientes");
                                break;
                            }
                            System.out.println("Has seleccionado recuperar todos clientes");

                            break;
                        case LISTAR_CLIENTES_ENTRE_FECHAS:
                            //recolectorCliente.listarFacturas();
                            break;
                        case CAMBIAR_TARIFA_CLIENTE:
                            //recolectorCliente.modificarTarifa();
                            break;
                        case ATRAS:
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
                            //recolectorFactura.insertarDatosFactura();
                            break;
                        case RECUPERAR_DATOS_FACTURA_POR_CODIGO:
                            //recolectorFactura.devolverFactuasPorCodigo();
                            break;
                        case RECUPERAR_TODAS_FACTUAS_CLIENTE:
                            //recolectorFactura.devolverFacturasUnCliente();
                            break;
                        case LISTAR_FACTURAS_ENTRE_FECHAS:
                            //recolectorFactura.listarFacturas();
                            break;
                        case ATRAS:
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
                           // recolectorLlamada.insertarDatosLlamada();
                            break;
                        case LISTAR_LLAMADAS_DE_UN_CLIENTE:
                            //recolectorLlamada.listarLlamadasUnCliente();
                            break;
                        case LISTAR_LLAMADAS_ENTRE_FECHAS:
                            //recolectorLlamada.listarLLamadas();
                            break;
                        case ATRAS:
                            break;
                    }
                    break;
                case SALIR:
                    //System.exit(0);
                    return;
            }
        }while(opcion>=0);

    }
}