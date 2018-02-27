package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.herencias.Particular;

import java.util.ArrayList;
import java.util.List;

public class CrudCliente {

    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    Cliente cs = new Particular("", "","", null,0.0,"",true);

    public void insertarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void borrarCliente (Cliente cliente){

    }

    public List<Cliente> listarClientes(){

        return null;
    }

    public Cliente unCliente(String nif) {

        return null;
    }
}
