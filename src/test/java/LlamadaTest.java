import org.junit.Assert;
import org.junit.Test;
import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.crud.CrudLlamada;

public class LlamadaTest {

    @Test
    public void InsertarLlamadaTest() {
        Cliente cs = new Cliente("Albert","47628956G","bomberocanelles","Apartat de correus",null,null,false);
        Llamada llm = new Llamada(666405658,null, (float) 1.5);
        CrudLlamada cr = new CrudLlamada();
        cr.insertarLlamada(llm, cs.getNif());
        Assert.assertEquals(1, cr.getLlamadas().size());
    }
}
