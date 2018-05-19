package uji.es.EI1017.vistas;

import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.recoleccionDatos.RecolectorDatosCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.time.LocalDateTime;


public class VistaClientes implements Serializable {
    RecolectorDatosCliente recolectorCliente;
    CrudCliente crudCliente;
    JRadioButton empresa;
    JRadioButton particular;
    public VistaClientes(CrudCliente crud) {
        this.crudCliente = crud;
    }
    public void ejecutarVentanaClientes() {
        JFrame vClientes = new JFrame("Clientes");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelSeis = new JPanel();
        JPanel panelSiete = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton insertar = new JButton("Insertar Cliente");
        JButton eliminar = new JButton("Eliminar Cliente");
        JButton listar = new JButton("Listar Clientes");
        JButton listaruno = new JButton("Mostrar Cliente");
        JButton cambiarTarifa = new JButton("Cambiar Tarifa Cliente");
        JButton CEntreFechas = new JButton("Cliente Entre Fechas");
        JButton atras = new JButton("Atras");

        panelUno.add(insertar);

        panelDos.add(eliminar);

        panelTres.add(listar);

        panelCuatro.add(listaruno);

        panelCinco.add(cambiarTarifa);

        panelSeis.add(CEntreFechas);

        panelSiete.add(atras);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelCinco);
        panelTotal.add(panelSeis);
        panelTotal.add(panelSiete);
        vClientes.add(panelTotal);

        vClientes.setSize(500,300);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientesAdd();
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientesDelete();
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientesList();
            }
        });

        listaruno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recuperarCliente();
            }
        });

        cambiarTarifa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientesCambiarTarifa();
            }
        });

        CEntreFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clientesEntreFechas();
            }
        });
    }

    public void insertarTarifaBasica(){
        JFrame vClientes = new JFrame("Insertar Tarifa Basica");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JLabel lPrecio = new JLabel("Precio");
        JTextField precio = new JTextField(10);


        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");
        JButton limpiar = new JButton("Limpiar Tarifas Basicas");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lPrecio);
        panelDos.add(precio);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTres.add(limpiar);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);

        vClientes.add(panelTotal);

       //vClientes.add(panelTotal);
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);
    }
    public void insertarTarifaPeriodo(){
        JFrame vClientes = new JFrame("Insertar Tarifa Periodo");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JLabel lPrecio = new JLabel("Precio");
        JTextField precio = new JTextField(10);
        JLabel lPIni = new JLabel("Inicio xx:xx");
        JTextField pIni= new JTextField(10);
        JLabel lPFin = new JLabel("Fin xx:xx");
        JTextField pFin= new JTextField(10);


        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");
        JButton limpiar = new JButton("Limpiar Tarifas Periodicas");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lPrecio);
        panelDos.add(precio);
        panelCuatro.add(lPIni);
        panelCuatro.add(pIni);
        panelCinco.add(lPFin);
        panelCinco.add(pFin);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTres.add(limpiar);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelCinco);
        panelTotal.add(panelTres);

        vClientes.add(panelTotal);

        //vClientes.add(panelTotal);
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);
    }
    public void insertarTarifaDia(){
        JFrame vClientes = new JFrame("Insertar Tarifa Basica");
        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JLabel lPrecio = new JLabel("Precio");
        JTextField precio = new JTextField(10);
        JLabel lDia = new JLabel("Dia 1 (Lunes)-7(Domingo)");
        JTextField dia = new JTextField(10);


        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");
        JButton limpiar = new JButton("Limpiar Tarifas Basicas");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lPrecio);
        panelDos.add(precio);
        panelCuatro.add(lDia);
        panelCuatro.add(dia);
        panelTres.add(aceptar);
        panelTres.add(cancelar);
        panelTres.add(limpiar);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelTres);

        vClientes.add(panelTotal);

        //vClientes.add(panelTotal);
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);
    }
    public void clientesCambiarTarifa() {
        JFrame vClientes = new JFrame("Cambiar Tarifa Clientes");

        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton TBasica = new JButton("Tarifa basica");
        JButton TPeriodo = new JButton("Tarifa Periodo");
        JButton TDia = new JButton("Tarifa dia");
        JButton borrar = new JButton("Borrar Todas Tarifas");
        JButton atras = new JButton("Atras");

        panelUno.add(TBasica);
        panelDos.add(TPeriodo);
        panelTres.add(TDia);
        panelCuatro.add(atras);
        panelCinco.add(borrar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCinco);
        panelTotal.add(panelCuatro);

        vClientes.add(panelTotal);
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        TBasica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarTarifaBasica();
            }
        });

        TPeriodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarTarifaPeriodo();
            }
        });

        TDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                insertarTarifaDia();
            }
        });
    }

    public void clientesEntreFechas() {
        JFrame vClientes = new JFrame("Clientes entre fechas");

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
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        vClientes.add(panelTotal);

        vClientes.setSize(500,200);
        vClientes.setResizable(true);
        vClientes.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorCliente = new RecolectorDatosCliente(crudCliente);
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

                lista.setListData(recolectorCliente.listarFacturas(ini,fina));
            }
        });

    }

    public void recuperarCliente() {
        JFrame vClientes = new JFrame("Un Cliente");


        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JTextField nombre = new JTextField(10);
        nombre.disable();
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(aceptar);
        panelDos.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTres.add(nombre);
        panelTotal.add(panelTres);
        vClientes.add(panelTotal);

        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorCliente = new RecolectorDatosCliente(crudCliente);
                String n = recolectorCliente.recuperarClientePorDNI(nif.getText());
                nombre.setText(n);

            }
        });
    }

    public void clientesList() {
        JFrame vClientes = new JFrame("Listado de Clientes");
        JList lista = new JList();

        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        panelUno.add(lista);


        JButton cancelar = new JButton("Cancelar");
        JPanel panelTotal = new JPanel();

        panelDos.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        vClientes.add(panelTotal);

        vClientes.setSize(500,200);
        vClientes.setResizable(true);
        vClientes.setVisible(true);

        vClientes.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                super.windowOpened(windowEvent);
                recolectorCliente = new RecolectorDatosCliente(crudCliente);
                lista.setListData(recolectorCliente.listarClientes());
            }
        });
    }

    public  void clientesDelete() {
        JFrame vClientes = new JFrame("Eliminar Cliente");


        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);

        JButton aceptar = new JButton("Aceptar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(aceptar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        vClientes.add(panelTotal);


        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

         aceptar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 recolectorCliente = new RecolectorDatosCliente(crudCliente);
                recolectorCliente.eliminarClienteDNI(nif.getText());
             }
         });
    }

    public void clientesAdd() {
        JFrame vClientes = new JFrame("Añadir Cliente");


        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelSeis = new JPanel();
        JPanel panelSiete = new JPanel();
        JPanel panelOcho = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNombre = new JLabel("Nombre");
        JTextField nombre = new JTextField(10);
        JLabel lApellidos = new JLabel("Apellidos");
        JTextField apellidos = new JTextField(10);
        apellidos.disable();
        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);
        JLabel lEmail = new JLabel("Email");
        JTextField email = new JTextField(10);
        JLabel lDireccion = new JLabel("Direccion");
        JTextField direccion = new JTextField(10);
        JLabel lTarifa = new JLabel("Tarifa Basica");
        JTextField tarifa = new JTextField(10);
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton empresa = new JRadioButton("Empresa");
        JRadioButton particular = new JRadioButton("Particular");
        grupo.add(empresa);
        grupo.add(particular);

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNombre);
        panelUno.add(nombre);
        panelOcho.add(lApellidos);
        panelOcho.add(apellidos);
        panelDos.add(lNif);
        panelDos.add(nif);
        panelTres.add(lEmail);
        panelTres.add(email);
        panelCuatro.add(lDireccion);
        panelCuatro.add(direccion);
        panelCinco.add(lTarifa);
        panelCinco.add(tarifa);

        panelSeis.add(aceptar);
        panelSeis.add(cancelar);
        panelSiete.add(empresa);
        panelSiete.add(particular);
        panelTotal.add(panelUno);
        panelTotal.add(panelOcho);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelCinco);
        panelTotal.add(panelSeis);
        panelTotal.add(panelSiete);
        vClientes.add(panelTotal);

        vClientes.setSize(500,300);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        particular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(particular.isSelected()) {
                    apellidos.enable();
                }

            }
        });

        empresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(empresa.isSelected()) {
                    apellidos.disable();
                    apellidos.setText("");
                }
            }
        });

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorCliente = new RecolectorDatosCliente(crudCliente);
                if(apellidos.getText().equals("")) {
                    recolectorCliente.insertarDatosClienteVista(nombre.getText(), nif.getText(), email.getText(), direccion.getText() ,false, Float.parseFloat(tarifa.getText()),"");
                }
                else {
                    recolectorCliente.insertarDatosClienteVista(nombre.getText(), nif.getText(), email.getText(), direccion.getText(), true, Float.parseFloat(tarifa.getText()), apellidos.getText());
                }
            }
        });

    }


}
