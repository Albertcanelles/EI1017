import org.junit.Assert;
import org.junit.Test;
import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.modelo.ModeloCliente;

public class ClienteTest {

    @Test
    public void TestInsertarCliente() {
        Cliente cs = new Cliente("Albert","47628956G","bomberocanelles","Apartat de correus",null,null,false);
        ModeloCliente modeloCliente = new ModeloCliente();
        modeloCliente.insertarCliente(cs);
        Assert.assertEquals(1, modeloCliente.tamanyoLista());

    }

    @Test
    public void TestBorrarCliente() {
        Cliente cs = new Cliente("Albert","47628956G","bomberocanelles","Apartat de correus",null,null,false);
        ModeloCliente modeloCliente = new ModeloCliente();
        modeloCliente.insertarCliente(cs);
        //modeloCliente.borrarCliente(cs);
        Assert.assertEquals(true, modeloCliente.borrarCliente(cs));
      //  Assert.assertEquals(false, modeloCliente.borrarCliente(cs));
    }




}
