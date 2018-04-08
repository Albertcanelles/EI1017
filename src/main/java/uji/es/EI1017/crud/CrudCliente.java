package uji.es.EI1017.crud;
/*
 * Albert Cañelles Panisello
 * Daniel Garcia Ruiz
 */
import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.excepciones.NoExisteClienteException;
import uji.es.EI1017.recoleccionDatos.recolectorDatosGenerico;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class CrudCliente implements Serializable {

    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

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


    public int tamanyoLista(){
        return listaClientes.size();
    }
    public Cliente unCliente(String nif) throws NoExisteClienteException {

        for(int i = 0; i<=listaClientes.size(); i++) {
            if(listaClientes.get(i).getNif().equals(nif) ) {
                System.out.println(listaClientes.get(i).getNombre());
                return listaClientes.get(i);
            }
        }
        throw new NoExisteClienteException();

    }


    }