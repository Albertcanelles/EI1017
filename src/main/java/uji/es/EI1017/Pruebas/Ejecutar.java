package uji.es.EI1017.Pruebas;

import uji.es.EI1017.clases.Cliente;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.herencias.Particular;

public class Ejecutar {
    public static void main (String [ ] args) {

        Cliente hola = new Cliente("Juanjo", "2323B", "bomberocanelles@gmail.com", null , 5.5,false);
        Particular adeu = new Particular("Albert", "2323A", "bomberocanelles@gmail.com", null , 5.5, "Campos",true);
        CrudCliente holax = new CrudCliente();
        holax.insertarCliente(hola);
        holax.insertarCliente(adeu);
        holax.listarClientes();
        holax.unCliente("2323A");

        holax.borrarCliente(hola);
        holax.listarClientes();
        //CrudCliente.insertarCliente(hola);
        //System.out.printf(hola.getEmail());

    }
}
