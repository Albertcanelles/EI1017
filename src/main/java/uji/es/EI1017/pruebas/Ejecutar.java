package uji.es.EI1017.pruebas;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.menu.*;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosCliente;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosFactura;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosLlamada;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Scanner;

public class Ejecutar implements Serializable {

    CrudCliente crudCliente;
    CrudLlamada crudLlamada;
    CrudFactura crudFactura;

    public Ejecutar(){
        crudCliente = new CrudCliente();
        crudFactura = new CrudFactura();
        crudLlamada = new CrudLlamada();
    }


    public void menu() throws ErrorEntreFechasException, NoExisteClienteException {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        RecolectorDatosCliente recolectorCliente = new RecolectorDatosCliente(crudCliente); // Clase utilizada para la recoleccion datos de clientes
        RecolectorDatosLlamada recolectorLlamada = new RecolectorDatosLlamada(crudLlamada, crudCliente); // Clase utilizada para la recoleccion datos de llamadas
        RecolectorDatosFactura recolectorFactura = new RecolectorDatosFactura(crudLlamada, crudFactura, crudCliente); // Clase utilizada para la recoleccion datos de facturas
        JFrame ventana = new JFrame("BoxLayout Manager");
        Container contenedor = ventana.getContentPane();
        JPanel panelTexto = new JPanel();
        JPanel panelNorte = new JPanel();
        panelTexto.add(new JLabel("Telefonia"));
        contenedor.add(panelTexto, BorderLayout.NORTH);
        panelNorte.add(new JButton("Clientes"));
        panelNorte.add(new JButton("Facturas"));
        panelNorte.add(new JButton("Llamadas"));

        contenedor.add(panelNorte, BorderLayout.CENTER);
        ventana.setSize(400, 400);
        ventana.setVisible(true);
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
                        case RECUPERAR_CLIENTE_POR_NIF: // Recuperamos solamente un cliente por nif
                            recolectorCliente.recuperarClientePorDNI();
                            break;
                        case RECUPERAR_TODOS_CLIENTES:  // Recuperamos todos los clientes en la lista actualmente
                            if(crudCliente.listarClientes().size() == 0) {
                                System.err.println("Todavia no hay clientes");
                                break;
                            }
                            System.out.println("Has seleccionado recuperar todos clientes");
                            for (int i = 0; i < crudCliente.tamanyoLista(); i++) {
                                System.out.println(crudCliente.listarClientes().get(i).toString());
                            }
                            break;
                        case LISTAR_CLIENTES_ENTRE_FECHAS:
                            recolectorCliente.listarFacturas();
                            break;
                        case CAMBIAR_TARIFA_CLIENTE:
                            recolectorCliente.modificarTarifa();
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
                            recolectorFactura.insertarDatosFactura();
                            break;
                        case RECUPERAR_DATOS_FACTURA_POR_CODIGO:
                            recolectorFactura.devolverFactuasPorCodigo();
                            break;
                        case RECUPERAR_TODAS_FACTUAS_CLIENTE:
                            recolectorFactura.devolverFacturasUnCliente();
                            break;
                        case LISTAR_FACTURAS_ENTRE_FECHAS:
                            recolectorFactura.listarFacturas();
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
                            recolectorLlamada.insertarDatosLlamada();
                            break;
                        case LISTAR_LLAMADAS_DE_UN_CLIENTE:
                            recolectorLlamada.listarLlamadasUnCliente();
                            break;
                        case LISTAR_LLAMADAS_ENTRE_FECHAS:
                            recolectorLlamada.listarLLamadas();
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