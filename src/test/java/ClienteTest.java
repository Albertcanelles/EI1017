import org.junit.Assert;
import org.junit.Test;
import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.crud.CrudCliente;

public class ClienteTest {

    @Test
    public void TestInsertarCliente() {
        Cliente cs = new Cliente("Albert","47628956G","bomberocanelles","Apartat de correus",null,null,false);
        CrudCliente crudCliente = new CrudCliente();
        crudCliente.insertarCliente(cs);
        Assert.assertEquals(1, crudCliente.tamanyoLista());

    }

    @Test
    public void TestBorrarCliente() {
        Cliente cs = new Cliente("Albert","47628956G","bomberocanelles","Apartat de correus",null,null,false);
        CrudCliente crudCliente = new CrudCliente();
        crudCliente.insertarCliente(cs);
        Assert.assertTrue(crudCliente.borrarCliente(cs));
    }




}
