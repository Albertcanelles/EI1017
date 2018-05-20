package uji.es.EI1017.controlador;

import uji.es.EI1017.Clases.Cliente;
import uji.es.EI1017.Clases.Factura;
import uji.es.EI1017.Clases.Llamada;
import uji.es.EI1017.Clases.Tarifa;
import uji.es.EI1017.modelo.ModeloCliente;
import uji.es.EI1017.modelo.ModeloFactura;
import uji.es.EI1017.modelo.ModeloGenerico;
import uji.es.EI1017.modelo.ModeloLlamada;
import uji.es.EI1017.decorador.*;
import uji.es.EI1017.excepciones.ErrorEntreFechasException;


import java.time.LocalDateTime;
import java.util.*;

public class ControladorFactura {
    private ModeloFactura crudFactura;  // Llamamos a los controlador de la clase ModeloFactura
    private ModeloLlamada modeloLlamada;  // Llamamos a los controlador de la clase ModeloLlamada
    private ControladorGenerico controladorGenerico;
    private TarifaBasica basica;
    private TarifaPeriodo periodo;
    private TarifaDia dia;
    private ModeloCliente modeloCliente;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public ControladorFactura(ModeloLlamada modeloLlamada, ModeloFactura crudFactura, ModeloCliente modeloCliente) {
        this.crudFactura = crudFactura;
        this.modeloLlamada = modeloLlamada;
        this.modeloCliente = modeloCliente;
        this.controladorGenerico = new ControladorGenerico();

    }

    public ControladorFactura(ModeloLlamada modeloLlamada, ModeloCliente modeloCliente, ModeloFactura crudFactura, TarifaBasica basica, TarifaPeriodo periodo, TarifaDia dia) {
        this.crudFactura = crudFactura;
        this.modeloCliente = modeloCliente;
        this.modeloLlamada = modeloLlamada;
        this.controladorGenerico = new ControladorGenerico();
        this.basica = basica;
        this.dia = dia;
        this.periodo = periodo;
    }


    public void insertarDatosFactura(String DNI, LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws ErrorEntreFechasException {

        Cliente cliente = modeloCliente.getCliente(DNI);
        int codigoFactura = crudFactura.numFacturas()+1;

        LocalDateTime emisionFactura = LocalDateTime.now();

        if(!controladorGenerico.compruebaFecha(fechaInicio, fechaFinal)) {
            return;
        }
        float importeTemporal = 0;
        float importeTotal = 0;
        ArrayList<Llamada> lista = modeloLlamada.listarLlamadas(DNI);
        ArrayList<Tarifa> listaTarifas = cliente.getTarifa();
        Tarifa ultimaTarifa = listaTarifas.get(listaTarifas.size()-1);
        Collection<Llamada> nuevaLlamadas = ModeloGenerico.extraerConjunto(lista, fechaInicio, fechaFinal);
        for  (Llamada i : nuevaLlamadas){
            importeTemporal = ultimaTarifa.getPrecio(i.getFecha());
            importeTotal += importeTemporal*i.getDuracion();
        }

        Factura factura = new Factura(codigoFactura, emisionFactura,fechaInicio, fechaFinal,importeTotal);
        crudFactura.emitirFactura(factura, DNI);
    }



    public Factura devolverFacturasPorCodigo(int codigoFactura) {

            Factura listado;
            for(int i = 0; i< crudFactura.getFacturas().size();i++) {
                if (crudFactura.getFacturas().get(i).getCodigo() == codigoFactura) {
                    listado = crudFactura.getFacturas().get(i);
                    return listado;
                }
            }
            return null;
    }

    public Factura[] devolverFacturasUnCliente(String DNI) {
        Factura[] listado = new Factura[crudFactura.getFacturas().size()];
        for(int i = 0; i<crudFactura.recuperarTodasFacturas(DNI).size(); i++) {
           listado[i] = crudFactura.recuperarTodasFacturas(DNI).get(i);
        }
        return listado;
    }

    public Factura[] listarFacturas(LocalDateTime fechaIni, LocalDateTime fechaFin){

        try {
            Factura[] listado = new Factura[crudFactura.getFacturas().size()];
            ControladorGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Factura> todas = crudFactura.getFacturas();
            Collection<Factura> lista = ModeloGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            int i = 0;
            for (Factura iter : lista) {
                System.out.println(iter.toString());
                listado[i] = iter;
                i++;
            }
            return listado;
        } catch (ErrorEntreFechasException e){
            System.out.println("Error");
        }
        return null;
    }


}
