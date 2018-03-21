package uji.es.EI1017.Crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Cliente;

import java.util.*;

public class CrudCliente {

    public ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();


    public void insertarCliente(Cliente cliente){
            listaClientes.add(cliente);
    }

    public boolean borrarCliente (Cliente cliente){
        try {
            listaClientes.remove(cliente);
            return true;
        } catch (Exception IndexOutOfBoundsException) {
            System.err.println("El cliente que quiere eliminar no existe");
        }
        return false;
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