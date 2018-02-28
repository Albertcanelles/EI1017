package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.herencias.Particular;

import java.util.ArrayList;
import java.util.List;

public class CrudCliente {

    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public void insertarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void borrarCliente (Cliente cliente){
        if (listaClientes.contains(cliente))
            listaClientes.remove(cliente);
    }

    public ArrayList<Cliente> listarClientes(){
        return listaClientes;
    }

    public Cliente unCliente(String nif) {
        for(int i = 0; i<=listaClientes.size(); i++) {
            if(listaClientes.get(i).getNif() == nif) {
                System.out.println(listaClientes.get(i).getNombre());
                return listaClientes.get(i);
            }
        }
        return null;
    }
    }
