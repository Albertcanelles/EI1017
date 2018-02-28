package uji.es.EI1017.crud;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.herencias.Empresa;
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

    public List<Cliente> listarClientes(){
        System.out.println(listaClientes.toString());
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

    @Override
    public String toString(){
        Cliente cs = new Cliente();
        Cliente pr = new Particular();
        String cadena = null;
        for(int i = 0; i<listaClientes.size(); i++) {
            cs = listaClientes.get(i);
            cadena = cadena+"Cliente [Nombre: "+cs.getNombre()+"NIF: "+cs.getNif()+"Email: "+cs.getEmail()+"]";
            }
            return cadena;
        }
    }
