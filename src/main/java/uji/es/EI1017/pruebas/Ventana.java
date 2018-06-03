package uji.es.EI1017.pruebas;

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.vistas.VistaClientes;
import uji.es.EI1017.vistas.VistaFacturas;
import uji.es.EI1017.vistas.VistaLlamadas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;

public class Ventana implements Serializable {

    private CrudCliente crudCliente;
    private CrudLlamada crudLlamada;
    private CrudFactura crudFactura;

    public Ventana() {
        crudCliente = new CrudCliente();
        crudFactura = new CrudFactura();
        crudLlamada = new CrudLlamada();
    }

    public void cosa(){
        try {
            GuardadoDatos.escritura(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ventanaPrincipal() {



        VistaClientes vistaClientes = new VistaClientes(crudCliente);
        VistaLlamadas vistaLlamadas = new VistaLlamadas(crudCliente, crudLlamada);
        VistaFacturas vistaFacturas = new VistaFacturas(crudCliente, crudLlamada, crudFactura);


        /*Definimos la ventana y los 2 contenedores el de los botones y el texto*/
        JFrame ventana = new JFrame("Telefonia");
        JPanel panelBotones = new JPanel();
        JPanel panelTexto = new JPanel();

        /*Creamos el titulo y le ponemos una fuente y un tamaño nuevo*/
        JLabel titulo = new JLabel("Telefonia");
        titulo.setFont(new Font("Serif", Font.PLAIN, 30));

        /*Creamos los botones para acceder a las respectivas vistas*/
        JButton clientes= new JButton("Clientes");
        JButton facturas = new JButton("Facturas");
        JButton llamadas = new JButton("Llamadas");

        /*Añadimos al contenedor de texto el titulo*/
        panelTexto.add(titulo);

        /*Añadimos al contenedor de los botones los botones*/
        panelBotones.add(clientes,BorderLayout.WEST);
        panelBotones.add(facturas,BorderLayout.CENTER);
        panelBotones.add(llamadas,BorderLayout.EAST);
        /* Añadimos los paneles a la ventana */
        ventana.add(panelBotones);
        ventana.add(panelTexto , BorderLayout.NORTH);

        /* Tamaño de la ventana y que se cierre y que se muestre */
        ventana.setSize(500,150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);


        /* Llamadas a las ventanas de Clientes Facturas y Llamadas */


        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent windowEvent) {

                System.out.println("Cerrando");
                cosa();
                super.windowClosing(windowEvent);
            }
        });

        clientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaClientes.ejecutarVentanaClientes();
            }
        });

        llamadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaLlamadas.ejecutarVentanaLlamadas();
            }
        });

        facturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vistaFacturas.ejecutarVentanaFacturas();
            }
        });

        /* FIN DE LLAMADAS A LAS VENTANAS CLIENTES FACTURAS Y LLAMADAS*/


    }

}
