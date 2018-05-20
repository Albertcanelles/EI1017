package uji.es.EI1017.vistas;

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosLlamada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalDateTime;

public class VistaLlamadas implements Serializable {
    RecolectorDatosLlamada recolectorDatosLlamada;
    CrudLlamada crudLlamada;
    CrudCliente crudCliente;
    public VistaLlamadas(CrudCliente crudCliente, CrudLlamada crudLlamada) {
        this.crudCliente = crudCliente;
        this.crudLlamada = crudLlamada;
    }

    public void ejecutarVentanaLlamadas() {
        JFrame vLlamadas = new JFrame("Llamadas");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton insertarLlamada = new JButton("Insertar Llamada Cliente");
        JButton listarLlamadas = new JButton("Listar Llamadas un Cliente");
        JButton llamadasEntreFechas = new JButton("Recuperar Llamadas entre Fechas");
        JButton atras = new JButton("Atras");

        panelUno.add(insertarLlamada);
        panelDos.add(listarLlamadas);
        panelTres.add(llamadasEntreFechas);
        panelCuatro.add(atras);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);

        vLlamadas.add(panelTotal);


        vLlamadas.setSize(500,500);
        vLlamadas.setResizable(false);
        vLlamadas.setVisible(true);

        insertarLlamada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarLlamadas();
            }
        });

        listarLlamadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listarLlamadasCliente();
            }
        });

        llamadasEntreFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listarLlamadasFecha();
            }
        });
    }

    public void insertarLlamadas() {
        JFrame vLlamadas = new JFrame("Insertar Llamadas");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelTotal = new JPanel();
        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JLabel lDuracion = new JLabel("Duracion");
        JTextField duracion = new JTextField(10);
        JLabel lTelefono = new JLabel("Telefono");
        JTextField telefono = new JTextField(10);

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lDuracion);
        panelDos.add(duracion);
        panelTres.add(lTelefono);
        panelTres.add(telefono);
        panelCuatro.add(aceptar);
        panelCuatro.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        vLlamadas.add(panelTotal);

        vLlamadas.setSize(500,500);
        vLlamadas.setResizable(false);
        vLlamadas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorDatosLlamada = new RecolectorDatosLlamada(crudLlamada, crudCliente);
                recolectorDatosLlamada.insertarDatosLlamadaVista(nif.getText(), Integer.parseInt(telefono.getText()) , Float.parseFloat(duracion.getText()));
                nif.setText(""); telefono.setText(""); duracion.setText("");
                JOptionPane.showMessageDialog(vLlamadas, "Insertado Correctamente");
            }
        });
    }

    public void listarLlamadasCliente() {
        JFrame vLlamadas = new JFrame("Listar Llamadas Cliente");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);

        JList lista = new JList();

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lista);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        vLlamadas.add(panelTotal);

        vLlamadas.setSize(500,500);
        vLlamadas.setResizable(true);
        vLlamadas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorDatosLlamada= new RecolectorDatosLlamada(crudLlamada, crudCliente);
                lista.setListData(recolectorDatosLlamada.listarLlamadasUnCliente(nif.getText()));
            }
        });
    }

    public void listarLlamadasFecha() {
        JFrame vLlamadas = new JFrame("Listar Llamadas Fecha");
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
        vLlamadas.add(panelTotal);
        vLlamadas.setSize(500,500);
        vLlamadas.setResizable(false);
        vLlamadas.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorDatosLlamada = new RecolectorDatosLlamada(crudLlamada, crudCliente);
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
                lista.setListData(recolectorDatosLlamada.listarLLamadas(ini,fina));

            }
        });
    }
}
