package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Factura;
import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.crud.CrudCliente;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudGenerico;
import uji.es.EI1017.crud.CrudLlamada;
import uji.es.EI1017.decorador.*;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;


import java.time.LocalDateTime;
import java.util.*;

public class RecolectorDatosFactura {
    private CrudFactura crudFactura;  // Llamamos a los recoleccionDatos de la clase CrudFactura
    private CrudLlamada crudLlamada;  // Llamamos a los recoleccionDatos de la clase CrudLlamada
    private RecolectorDatosGenerico recolectorDatosGenerico;
    private TarifaBasica basica;
    private TarifaPeriodo periodo;
    private TarifaDia dia;
    private CrudCliente crudCliente;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public RecolectorDatosFactura(CrudLlamada crudLlamada, CrudFactura crudFactura, CrudCliente crudCliente) {
        this.crudFactura = crudFactura;
        this.crudLlamada = crudLlamada;
        this.crudCliente = crudCliente;
        this.recolectorDatosGenerico = new RecolectorDatosGenerico();

    }

    public RecolectorDatosFactura(CrudLlamada crudLlamada,CrudCliente crudCliente, CrudFactura crudFactura, TarifaBasica basica, TarifaPeriodo periodo, TarifaDia dia) {
        this.crudFactura = crudFactura;
        this.crudCliente = crudCliente;
        this.crudLlamada = crudLlamada;
        this.recolectorDatosGenerico = new RecolectorDatosGenerico();
        this.basica = basica;
        this.dia = dia;
        this.periodo = periodo;
    }

    public void insertarDatosFactura() throws ErrorEntreFechasException {
        System.out.println("Introduce el DNI del cliente:");
        String DNI = scanner.next();
        while ( DNI.length()!= 9){
            System.out.println("DNI invalido, ha de tener 8 números y una letra al final");
            System.out.println("Introduce el DNI del cliente:");
            DNI = scanner.next();
        }
        Cliente cliente = crudCliente.getCliente(DNI);
        int codigoFactura = crudFactura.numFacturas()+1;

        LocalDateTime emisionFactura = LocalDateTime.now();
        System.out.println("Introduce la fecha inicio");
        LocalDateTime fechaInicio = RecolectorDatosGenerico.pedirFecha();

        System.out.println("Introduce la fecha final");
        LocalDateTime fechaFinal = RecolectorDatosGenerico.pedirFecha();

        if(!recolectorDatosGenerico.compruebaFecha(fechaInicio, fechaFinal)) {
            return;
        }
        float importeTemporal = 0;
        float importeTotal = 0;
        ArrayList<Llamada> lista = crudLlamada.listarLlamadas(DNI);
        ArrayList<Tarifa> listaTarifas = cliente.getTarifa();
        Tarifa ultimaTarifa = listaTarifas.get(listaTarifas.size()-1);
        Collection<Llamada> nuevaLlamadas = CrudGenerico.extraerConjunto(lista, fechaInicio, fechaFinal);
        for  (Llamada i : nuevaLlamadas){
            importeTemporal = ultimaTarifa.getPrecio(i.getFecha());
            importeTotal += importeTemporal*i.getDuracion();
        }

        Factura factura = new Factura(codigoFactura, emisionFactura,fechaInicio, fechaFinal,importeTotal);
        crudFactura.emitirFactura(factura, DNI);
    }

    public void devolverFactuasPorCodigo() {
        System.out.println("Introduce el codigo de la factura:");
        int codigoFactura= scanner.nextInt();
        crudFactura.devolverDatosFacturaPorCodigo(codigoFactura);
    }

    public void devolverFacturasUnCliente() {
        System.out.println("Introduce el DNI del cliente para listar sus facturas:");
        String DNI = scanner.next();
        crudFactura.recuperarTodasFacturas(DNI);
    }
    public void listarFacturas(){
        LocalDateTime fechaIni = RecolectorDatosGenerico.pedirFecha();
        LocalDateTime fechaFin = RecolectorDatosGenerico.pedirFecha();
        try {
            RecolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Factura> todas = crudFactura.getFacturas();
            Collection<Factura> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            for (Factura iter : lista) {
                System.out.println(iter.toString());
            }
        } catch (ErrorEntreFechasException e){
            System.out.println("Error");
        }
    }


}
