package uji.es.EI1017.vistas;

import uji.es.EI1017.modelo.ModeloCliente;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.controlador.ControladorCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.time.LocalDateTime;


public class VistaClientes implements Serializable {
    ControladorCliente recolectorCliente;
    ModeloCliente modeloCliente;
    JRadioButton empresa;
    JRadioButton particular;
    public VistaClientes(ModeloCliente crud) {
        this.modeloCliente = crud;
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
        JButton cancelar = new JButton("Atras");

        panelUno.add(insertar);
        panelDos.add(eliminar);
        panelTres.add(listar);
        panelCuatro.add(listaruno);
        panelCinco.add(cambiarTarifa);
        panelSeis.add(CEntreFechas);
        panelSiete.add(cancelar);

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

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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


        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lPrecio);
        panelDos.add(precio);
        panelTres.add(aceptar);
        panelTres.add(cancelar);


        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);

        vClientes.add(panelTotal);

       //vClientes.add(panelTotal);
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recolectorCliente = new ControladorCliente(modeloCliente);
                try {
                    recolectorCliente.insertarTarifaBasica(nif.getText(), Float.parseFloat(precio.getText()));
                    nif.setText(""); precio.setText("");
                    JOptionPane.showMessageDialog(vClientes, "Tarfifa insertada");
                } catch (NoExisteClienteException e1) {
                    JOptionPane.showMessageDialog(vClientes, "Error");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });
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
        JLabel lPIni = new JLabel("Inicio xx Hora en punto formato 24h ");
        JTextField pIni= new JTextField(10);
        JLabel lPFin = new JLabel("Fin Hora en punto formato 24h ");
        JTextField pFin= new JTextField(10);


        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");


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

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recolectorCliente = new ControladorCliente(modeloCliente);
                try {
                    recolectorCliente.insertarTarifaPeriodo(nif.getText(),Integer.parseInt(pIni.getText()), Integer.parseInt(pFin.getText()), Float.parseFloat(precio.getText()));
                    nif.setText(""); pIni.setText(""); pFin.setText(""); precio.setText("");
                    JOptionPane.showMessageDialog(vClientes, "Tarfifa insertada");
                } catch (NoExisteClienteException e1) {
                    JOptionPane.showMessageDialog(vClientes, "Error");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });
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


        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(lPrecio);
        panelDos.add(precio);
        panelCuatro.add(lDia);
        panelCuatro.add(dia);
        panelTres.add(aceptar);
        panelTres.add(cancelar);

        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelCuatro);
        panelTotal.add(panelTres);

        vClientes.add(panelTotal);

        //vClientes.add(panelTotal);sdf
        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recolectorCliente = new ControladorCliente(modeloCliente); /*REVISAR CONTROL DE ERRORES HACIA ARRIBA ABAJO REVISAR EN AÑADIRCLIENTE*/
                float ptarifa = 0.0f;
                int pdia = 0;
                try {
                    ptarifa = Float.parseFloat(precio.getText());
                    pdia = Integer.parseInt(dia.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(vClientes, "Tarifa tiene que ser X.Xo dia tiene que ser 1-7");
                }
                try {
                    recolectorCliente.insertarTarifaDia(nif.getText(),Integer.parseInt(dia.getText()) ,ptarifa);
                    nif.setText(""); dia.setText(""); precio.setText(" ");
                    JOptionPane.showMessageDialog(vClientes, "Tarfifa insertada");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(vClientes, "Error");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });
    }

    public void limpiarTarifasCliente() {
        JFrame vClientes = new JFrame("Eliminar Tarifas de un Cliente");


        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTotal = new JPanel();

        JLabel lNif = new JLabel("NIF");
        JTextField nif = new JTextField(10);

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(aceptar);
        panelDos.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        vClientes.add(panelTotal);


        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorCliente = new ControladorCliente(modeloCliente);

                if(nif.getText() == "")
                    JOptionPane.showMessageDialog(vClientes, "Inserta un DNI porfavor");

                    try {
                        recolectorCliente.limpiarTarifas(nif.getText());
                        JOptionPane.showMessageDialog(vClientes, "Tarifas eliminadas");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(vClientes, "Inserta un DNI valido porfavor");
                    }
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });
    }

    public void listarTarifasCliente() {
        JFrame vClientes = new JFrame("Recuperar Facturas Cliente");
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
        vClientes.add(panelTotal);

        vClientes.setSize(500,500);
        vClientes.setResizable(true);
        vClientes.setVisible(true);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recolectorCliente = new ControladorCliente(modeloCliente);
                try {
                    lista.setListData( recolectorCliente.listaTarifaCliente(dni.getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vClientes, "Todavia error en el DNI o no existe cliente");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });
    }


    public void clientesCambiarTarifa() {
        JFrame vClientes = new JFrame("Cambiar Tarifa Clientes");

        JPanel panelUno = new JPanel();
        JPanel panelDos = new JPanel();
        JPanel panelTres = new JPanel();
        JPanel panelCuatro = new JPanel();
        JPanel panelCinco = new JPanel();
        JPanel panelSeis = new JPanel();
        JPanel panelTotal = new JPanel();

        JButton TBasica = new JButton("Tarifa basica");
        JButton TPeriodo = new JButton("Tarifa Periodo");
        JButton TDia = new JButton("Tarifa dia");
        JButton borrar = new JButton("Borrar Todas Tarifas");
        JButton listar = new JButton("Listar Todas Tarifas un Cliente");
        JButton cancelar = new JButton("Atras");

        panelUno.add(TBasica);
        panelDos.add(TPeriodo);
        panelTres.add(TDia);
        panelCuatro.add(cancelar);
        panelCinco.add(borrar);
        panelSeis.add(listar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        panelTotal.add(panelTres);
        panelTotal.add(panelCinco);
        panelTotal.add(panelSeis);
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

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTarifasCliente();
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTarifasCliente();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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
                recolectorCliente = new ControladorCliente(modeloCliente);

                try {


                    String fech = ini.getText();
                    int dia, mes, año, hora, min;
                    dia = Integer.parseInt(fech.substring(0, 2));
                    mes = Integer.parseInt(fech.substring(3, 5));
                    año = Integer.parseInt(fech.substring(6, 10));
                    hora = min = 0;
                    LocalDateTime ini = LocalDateTime.of(año, mes, dia, hora, min);
                    String fecha = fin.getText();
                    dia = Integer.parseInt(fecha.substring(0, 2));
                    mes = Integer.parseInt(fecha.substring(3, 5));
                    año = Integer.parseInt(fecha.substring(6, 10));
                    hora = min = 0;
                    LocalDateTime fina = LocalDateTime.of(año, mes, dia, hora, min);

                    lista.setListData(recolectorCliente.listarFacturas(ini, fina));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vClientes, "Introduce las fechas");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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
                recolectorCliente = new ControladorCliente(modeloCliente);
                try {
                    String n = recolectorCliente.recuperarClientePorDNI(nif.getText());
                    nombre.setText(n);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vClientes, "DNI Incorrecto");
                }

            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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
                recolectorCliente = new ControladorCliente(modeloCliente);
                if(recolectorCliente.listarClientes().length == 0) {
                    JOptionPane.showMessageDialog(vClientes, "Todavia no tenemos clientes");
                }
                lista.setListData(recolectorCliente.listarClientes());

            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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
        JButton cancelar = new JButton("Cancelar");

        panelUno.add(lNif);
        panelUno.add(nif);
        panelDos.add(aceptar);
        panelDos.add(cancelar);
        panelTotal.add(panelUno);
        panelTotal.add(panelDos);
        vClientes.add(panelTotal);


        vClientes.setSize(500,200);
        vClientes.setResizable(false);
        vClientes.setVisible(true);

         aceptar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
                 recolectorCliente = new ControladorCliente(modeloCliente);
                 if(nif.getText() == "")
                     JOptionPane.showMessageDialog(vClientes, "Inserta un DNI porfavor");
                 else {
                     try {
                         if (recolectorCliente.eliminarClienteDNI(nif.getText()))
                             JOptionPane.showMessageDialog(vClientes, "Cliente eliminado correctamente");
                     } catch (Exception e) {
                         JOptionPane.showMessageDialog(vClientes, "DNI Incorrecto");
                     }
                 }
             }
         });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
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

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vClientes.setVisible(false);
            }
        });

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
                recolectorCliente = new ControladorCliente(modeloCliente);

                if(nombre.getText() == " " || email.getText() == " " ||  direccion.getText() == " " || tarifa.getText() == " " ) {
                    JOptionPane.showMessageDialog(vClientes, "Los campos son obligatorios");
                    return;
                }

                if(nif.getText() == " " || nif.getText().length() != 9) {
                    JOptionPane.showMessageDialog(vClientes, "El dni no cumple con el formato 8N 1L :NNNNNNNNL");
                    return;
                }
                float ptarifa = 0.0f;
                try {
                    ptarifa = Float.parseFloat(tarifa.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(vClientes, "Tarifa tiene que ser X.X");
                }

                if(apellidos.getText().equals(" ")) {
                    recolectorCliente.insertarDatosClienteVista(nombre.getText(), nif.getText(), email.getText(), direccion.getText() ,false, ptarifa ,"");

                }
                else {
                    recolectorCliente.insertarDatosClienteVista(nombre.getText(), nif.getText(), email.getText(), direccion.getText(), true, ptarifa, apellidos.getText());
                    apellidos.setText("");
                }
                nombre.setText(""); nif.setText(""); email.setText(""); direccion.setText(""); tarifa.setText("");
                JOptionPane.showMessageDialog(vClientes, "Insertado Correctamente");
            }
        });



        vClientes.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                super.windowOpened(windowEvent);
                empresa.setSelected(true);

            }
        });

    }
}
