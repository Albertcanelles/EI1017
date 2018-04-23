package uji.es.EI1017.factoria;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Factura;
import uji.es.EI1017.Clases.Llamada;

public class FabricaRecolectores {
    public Cliente datosCliente() { return new Cliente();}
    public Factura datosFactura() { return new Factura();}
    public Llamada datosLlamada() { return new Llamada();}
}
