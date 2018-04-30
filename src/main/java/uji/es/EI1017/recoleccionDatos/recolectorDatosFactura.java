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
import uji.es.EI1017.excepciones.NoExisteClienteException;


import java.time.LocalDateTime;
import java.util.*;

public class recolectorDatosFactura {
    private CrudFactura crudFactura;  // Llamamos a los recoleccionDatos de la clase CrudFactura
    private CrudLlamada crudLlamada;  // Llamamos a los recoleccionDatos de la clase CrudLlamada
    private TarifaBasica basica;
    private TarifaPeriodo tardes;
    private TarifaDia domingos;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public recolectorDatosFactura(CrudLlamada crudLlamada, CrudFactura crudFactura) {
        this.crudFactura = crudFactura;
        this.crudLlamada = crudLlamada;

    }

    public recolectorDatosFactura(CrudLlamada crudLlamada, CrudFactura crudFactura, TarifaBasica basica, TarifaPeriodo tardes, TarifaDia domingos) {
        this.crudFactura = crudFactura;
        this.crudLlamada = crudLlamada;
        this.basica = basica;
        this.domingos = domingos;
        this.tardes = tardes;
    }

    public void insertarDatosFactura() {
        System.out.println("Introduce el DNI del cliente:");
        String DNI = scanner.next();
        while ( DNI.length()!= 9){
            System.out.println("DNI invalido, ha de tener 8 números y una letra al final");
            System.out.println("Introduce el DNI del cliente:");
            DNI = scanner.next();
        }
        System.out.println("Introduce el codigo de la factura:");
        int codigoFactura= scanner.nextInt();
        while (codigoFactura<2){
            System.out.println("Código invalido, ha de ser un número de al menos 3 digitos");
            System.out.println("Introduce el codigo de la factura:");
            codigoFactura= scanner.nextInt();
        }
        LocalDateTime emisionFactura = LocalDateTime.now();
        System.out.println("Introduce el la fecha inicio");
        LocalDateTime fechaInicio = recolectorDatosGenerico.pedirFecha();

        System.out.println("Introduce el la fecha final");
        LocalDateTime fechaFinal = recolectorDatosGenerico.pedirFecha();

        float duracion = sumarMinutos(DNI, fechaInicio, fechaFinal);
        Factura factura = new Factura(codigoFactura, duracion, emisionFactura,fechaInicio, fechaFinal);
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
        LocalDateTime fechaIni = recolectorDatosGenerico.pedirFecha();
        LocalDateTime fechaFin = recolectorDatosGenerico.pedirFecha();
        try {
            recolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Factura> todas = crudFactura.getFacturas();
            Collection<Factura> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            for (Factura iter : lista) {
                System.out.println(iter.toString());
            }
        } catch (ErrorEntreFechasException e){
            System.out.println("Error");
        }
    }


    private float sumarMinutos(String DNI, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        float suma = 0;
        try {
            recolectorDatosGenerico.compruebaFecha(fechaIni, fechaFin);
            ArrayList<Llamada> todas = crudLlamada.listarLlamadas(DNI);
            Collection<Llamada> lista = CrudGenerico.extraerConjunto(todas, fechaIni, fechaFin);
            for (Llamada iter : lista) {
                //System.out.println(iter.toString());
                suma= suma + iter.getDuracion();
            }
        } catch (ErrorEntreFechasException e){
            return suma;
        }
        return suma;
    }
    public float calcularFactura(String DNI) throws NoExisteClienteException {
        ArrayList<Llamada> llamadasCliente = crudLlamada.listarLlamadas(DNI);
        CrudCliente crudCliente = new CrudCliente();
        Cliente cliente = crudCliente.unCliente(DNI);
        float precioTotal = 0;
        float importe;
        for (Llamada iter : llamadasCliente) {
            if (!iter.getFecha().getDayOfWeek().equals(7)) {// Comprovado que sea 7 el domingo. Se hace con un .equals porque devuelve un dato de la clase DayOfTheWeek y no un entero
                if (iter.getFecha().getHour() < 16 && iter.getFecha().getHour() > 20) { //La tarifa de por las tardes se hace de 16 a 20
                    Tarifa tarifa = new TarifaPeriodo(cliente.getTarifa(), 0.5f);
                    importe = cliente.getTarifa().getPrecio();
                    precioTotal += iter.getDuracion() * importe;
                } else {
                    Tarifa tarifa = cliente.getTarifa();
                    importe = tarifa.getPrecio();
                    precioTotal += iter.getDuracion() * importe;
                }
            }


        }
        return precioTotal;
    }

}
