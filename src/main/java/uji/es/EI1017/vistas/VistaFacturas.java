package uji.es.EI1017.vistas;

import uji.es.EI1017.Clases.Factura;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosFactura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalDateTime;

public class VistaFacturas implements Serializable {

    CrudFactura crudFactura;
    CrudCliente crudCliente;
    CrudLlamada crudLlamada;

    public VistaFacturas(CrudCliente crudCliente, CrudLlamada crudLlamada, CrudFactura crudFactura) {
        this.crudCliente = crudCliente;
        this.crudFactura = crudFactura;
        this.crudLlamada = crudLlamada;
    }

    public void añadirFactura(){
        JFrame vFacturas = new JFrame("Añadir Facturas");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        JLabel lDni = new JLabel("DNI");
        JTextField dni = new JTextField(10);
        JLabel lIni = new JLabel("Fecha Inicial");
        JTextField ini = new JTextField(10);
        JLabel lFin = new JLabel("Fecha Final");
        JTextField fin = new JTextField(10);

        panelUno.add(lDni);
        panelUno.add(dni);
        panelDos.add(lIni);
        panelDos.add(ini);
        panelTres.add(lFin);
        panelTres.add(fin);
        panelCuatro.add(aceptar);
        panelCuatro.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        vFacturas.add(panelTotal);

        vFacturas.setSize(500,500);
        vFacturas.setResizable(true);
        vFacturas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RecolectorDatosFactura recolectorDatosFactura = new RecolectorDatosFactura(crudLlamada, crudFactura, crudCliente);
                String fech = ini.getText();
                int dia, mes, año, hora, min;
                dia = Integer.parseInt(fech.substring(0,2));
                mes = Integer.parseInt(fech.substring(3,5));
                año = Integer.parseInt(fech.substring(6,10));
                hora =min = 0;
                LocalDateTime inic = LocalDateTime.of(año, mes, dia, hora, min);
                String fecha = fin.getText();
                dia = Integer.parseInt(fecha.substring(0,2));
                mes = Integer.parseInt(fecha.substring(3,5));
                año = Integer.parseInt(fecha.substring(6,10));
                hora = min = 0;
                LocalDateTime fina = LocalDateTime.of(año, mes, dia, hora, min);
                try {
                    recolectorDatosFactura.insertarDatosFactura(dni.getText(), inic, fina);
                    dni.setText(""); ini.setText(""); fin.setText("");
                    JOptionPane.showMessageDialog(vFacturas, "Insertado Correctamente");
                } catch (ErrorEntreFechasException e) {
                    JOptionPane.showMessageDialog(vFacturas, "Revise el formato de las fechas DD/MM/YYYY");
                }

            }
        });
    }

    public void devolverFacturaCodigo(){
        JFrame vFacturas = new JFrame("Recuperar Facturas Codigo");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelTotal = new JPanel();

        JList lista = new JList();
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        JLabel lCodigo = new JLabel("Codigo Factura");
        JTextField codigo = new JTextField(10);

        JTextField resultado = new JTextField(40);

        panelUno.add(lCodigo);
        panelUno.add(codigo);
        panelDos.add(resultado);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        vFacturas.add(panelTotal);

        vFacturas.setSize(500,500);
        vFacturas.setResizable(false);
        vFacturas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RecolectorDatosFactura recolectorDatosFactura = new RecolectorDatosFactura(crudLlamada, crudFactura, crudCliente);
                //lista.setListData( recolectorDatosFactura.devolverFacturasPorCodigo(Integer.parseInt(codigo.getText())));
                Factura factura = recolectorDatosFactura.devolverFacturasPorCodigo(Integer.parseInt(codigo.getText()));
                resultado.setText(factura.toString());

            }
        });
    }
    public void recuperarFacturasCliente(){
        JFrame vFacturas = new JFrame("Recuperar Facturas Cliente");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelTotal = new JPanel();

        JList lista = new JList();
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        JLabel lDni = new JLabel("DNI Cliente");
        JTextField dni = new JTextField(10);

        panelUno.add(lDni);
        panelUno.add(dni);
        panelDos.add(lista);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        vFacturas.add(panelTotal);

        vFacturas.setSize(500,500);
        vFacturas.setResizable(true);
        vFacturas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RecolectorDatosFactura recolectorDatosFactura = new RecolectorDatosFactura(crudLlamada, crudFactura, crudCliente);
                lista.setListData( recolectorDatosFactura.devolverFacturasUnCliente(dni.getText()));
            }
        });
    }
    public void recuperarFechaFacturas(){
        JFrame vFacturas = new JFrame("Recuperar Todas Facturas");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelTotal = new JPanel();

        JList lista = new JList();

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        JLabel lIni = new JLabel("Fecha Inicial");
        JTextField ini = new JTextField(10);
        JLabel lFin = new JLabel("Fecha Final");
        JTextField fin = new JTextField(10);

        panelUno.add(lIni);
        panelUno.add(ini);
        panelDos.add(lFin);
        panelDos.add(fin);
        panelTres.add(lista);
        panelCuatro.add(aceptar);
        panelCuatro.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        vFacturas.add(panelTotal);
        vFacturas.setSize(500,500);
        vFacturas.setResizable(true);
        vFacturas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RecolectorDatosFactura recolectorDatosFactura = new RecolectorDatosFactura(crudLlamada, crudFactura, crudCliente);
                String fech = ini.getText();
                int dia, mes, año, hora, min;
                dia = Integer.parseInt(fech.substring(0,2));
                mes = Integer.parseInt(fech.substring(3,5));
                año = Integer.parseInt(fech.substring(6,10));
                hora =min = 0;
                LocalDateTime ini = LocalDateTime.of(año, mes, dia, hora, min);
                String fecha = fin.getText();
                dia = Integer.parseInt(fecha.substring(0,2));
                mes = Integer.parseInt(fecha.substring(3,5));
                año = Integer.parseInt(fecha.substring(6,10));
                hora = min = 0;
                LocalDateTime fina = LocalDateTime.of(año, mes, dia, hora, min);
                lista.setListData(recolectorDatosFactura.listarFacturas(ini,fina));

            }
        });
    }
    public void ejecutarVentanaFacturas() {
        JFrame vFacturas = new JFrame("Facturas");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton insertarFactura = new JButton("Insertar Datos Factura");
        JButton listarFacturaCodigo = new JButton("Devolver Factura Codigo");
        JButton listarFacturaCliente = new JButton("Recuperar Factura Cliente");
        JButton listarFechaFacturas = new JButton("Recuperar todas las facturas ");
        JButton atras = new JButton("Atras");

        panelUno.add(insertarFactura);
        panelDos.add(listarFacturaCodigo);
        panelTres.add(listarFacturaCliente);
        panelCuatro.add(listarFechaFacturas);
        panelCuatro.add(atras);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelCinco);

        vFacturas.add(panelTotal);


        vFacturas.setSize(500,500);
        vFacturas.setResizable(false);
        vFacturas.setVisible(true);

        insertarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                añadirFactura();
            }
        });

        listarFacturaCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                devolverFacturaCodigo();
            }
        });

        listarFacturaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recuperarFacturasCliente();
            }
        });

        listarFechaFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recuperarFechaFacturas();
            }
        });
    }



}
