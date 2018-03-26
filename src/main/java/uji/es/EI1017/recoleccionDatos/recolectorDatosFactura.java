package uji.es.EI1017.recoleccionDatos;

import uji.es.EI1017.clases.Factura;
import uji.es.EI1017.crud.CrudFactura;
import uji.es.EI1017.crud.CrudLlamada;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class recolectorDatosFactura {
    CrudFactura crudFactura;  // Llamamos a los recoleccionDatos de la clase CrudFactura
    CrudLlamada crudLlamada;  // Llamamos a los recoleccionDatos de la clase CrudLlamada
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);

    public recolectorDatosFactura(CrudLlamada crudLlamada, CrudFactura crudFactura) {
        this.crudFactura = crudFactura;
        this.crudLlamada = crudLlamada;
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
        Date emisionFactura = calendar.getTime();
        System.out.println("Introduce el la fecha inicio dd/MM/yyyy");
        String StrfechaInicio = scanner.nextLine();
        StrfechaInicio= scanner.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio  = null;
        String date = StrfechaInicio;
        try{
            fechaInicio  = df.parse(date);
        }catch (Exception e){
            System.out.println("Invalid format");
        }

        System.out.println("Introduce el la fecha final dd/MM/yyyy");
        String StrfechaFinal = scanner.nextLine();
        StrfechaFinal = scanner.nextLine();
        df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFinal  = null;
        date = StrfechaFinal;
        try{
            fechaFinal  = df.parse(date);
        }catch (Exception e){
            System.out.println("Invalid format");
        }
        float duracion = crudLlamada.sumarMinutos(DNI, fechaInicio, fechaFinal);
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

}
