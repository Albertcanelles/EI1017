package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.herencias.Empresa;
import uji.es.EI1017.herencias.Particular;
import uji.es.EI1017.menu.OpcionesMenuTipoCliente;

import java.util.*;

public class CrudCliente {

    public ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);
    public void insertarCliente(){

        /* RECOLECCION DE DATOS POR TECLADO */
        System.out.println("Introduce el nombre:");
        String nombre = scanner.next();
        System.out.println("Introduce el NIF:");
        String nif = scanner.next();
        System.out.println("Introduce el email:");
        String email = scanner.next();
        Date fechaAlta = calendar.getTime();
        double tarifa = 5.5;
        /* FIN DE RECOLECCION DE DATOS POR TECLADO*/

        /* LLAMADA DEL SUB MENU TIPO CLIENTES*/
        System.out.println(OpcionesMenuTipoCliente.getMenu());
        System.out.print("Elije una opción:");
        byte opcion_TipoCliente = scanner.nextByte();
        OpcionesMenuTipoCliente opcionesMenuTipoCliente = OpcionesMenuTipoCliente.getOpcion(opcion_TipoCliente);
        /* FINAL LLAMADA SUB MENU TIPO CLIENTES*/

        /*SELECCION DE TIPO DE CLIENTE*/
        switch (opcionesMenuTipoCliente) {
            case PARTICULAR:
                System.out.println("Introduce el apellido:");
                String apellido = scanner.next();

                Cliente particular = new Particular(nombre,nif, email, fechaAlta, tarifa, apellido,true);
                listaClientes.add(particular);
                break;
            case EMPRESA:
                Cliente empresa = new Cliente(nombre,nif, email, fechaAlta, tarifa,false);
                listaClientes.add(empresa);
                break;
        }
        /* FINAL DE SELECCION DE TIPO DE CLIENTE*/
    }


    public void borrarCliente (){
        try {
            System.out.println("Introduce el NIF de la persona a eliminar");
            Cliente cs;
            String nif = scanner.next();
            cs = unCliente(nif);
            if (listaClientes.contains(cs))
                listaClientes.remove(cs);
        } catch (Exception IndexOutOfBoundsException) {
            System.err.println("El cliente que quiere eliminar no existe");
        }
    }

    public ArrayList<Cliente> listarClientes(){
        return listaClientes;
    }

    public Cliente unCliente(String nif) {
        try {
        for(int i = 0; i<=listaClientes.size(); i++) {
            if(listaClientes.get(i).getNif().equals(nif) ) {
                System.out.println(listaClientes.get(i).getNombre());
                return listaClientes.get(i);
            }
        }

        }catch (Exception NullPointerException) {
            System.err.println("Todavia no hay clientes");
        }
        return null;
    }
    }
